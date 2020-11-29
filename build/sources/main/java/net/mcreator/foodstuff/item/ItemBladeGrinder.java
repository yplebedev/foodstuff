
package net.mcreator.foodstuff.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.foodstuff.creativetab.TabFoodstuffFromMod;
import net.mcreator.foodstuff.ElementsFoodstuff;

@ElementsFoodstuff.ModElement.Tag
public class ItemBladeGrinder extends ElementsFoodstuff.ModElement {
	@GameRegistry.ObjectHolder("foodstuff:bladegrinder")
	public static final Item block = null;
	public ItemBladeGrinder(ElementsFoodstuff instance) {
		super(instance, 60);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("foodstuff:bladegrinder", "inventory"));
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			setMaxDamage(0);
			maxStackSize = 64;
			setUnlocalizedName("bladegrinder");
			setRegistryName("bladegrinder");
			setCreativeTab(TabFoodstuffFromMod.tab);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			return 1F;
		}

		@Override
		public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
			return true;
		}
	}
}
