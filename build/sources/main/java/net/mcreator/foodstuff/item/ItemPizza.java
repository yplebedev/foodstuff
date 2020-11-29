
package net.mcreator.foodstuff.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.foodstuff.procedure.ProcedureTuntuntuntuntunrun;
import net.mcreator.foodstuff.creativetab.TabFoodstuffFromMod;
import net.mcreator.foodstuff.ElementsFoodstuff;

@ElementsFoodstuff.ModElement.Tag
public class ItemPizza extends ElementsFoodstuff.ModElement {
	@GameRegistry.ObjectHolder("foodstuff:pizza")
	public static final Item block = null;
	public ItemPizza(ElementsFoodstuff instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("foodstuff:pizza", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(12, 1.6f, false);
			setUnlocalizedName("pizza");
			setRegistryName("pizza");
			setCreativeTab(TabFoodstuffFromMod.tab);
			setMaxStackSize(8);
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}

		@Override
		protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entity) {
			super.onFoodEaten(itemStack, world, entity);
			int x = (int) entity.posX;
			int y = (int) entity.posY;
			int z = (int) entity.posZ;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureTuntuntuntuntunrun.executeProcedure($_dependencies);
			}
		}
	}
}
