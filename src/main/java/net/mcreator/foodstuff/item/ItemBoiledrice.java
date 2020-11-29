
package net.mcreator.foodstuff.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item;
import net.minecraft.item.EnumAction;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.foodstuff.creativetab.TabFoodstuffFromMod;
import net.mcreator.foodstuff.ElementsFoodstuff;

@ElementsFoodstuff.ModElement.Tag
public class ItemBoiledrice extends ElementsFoodstuff.ModElement {
	@GameRegistry.ObjectHolder("foodstuff:boiledrice")
	public static final Item block = null;
	public ItemBoiledrice(ElementsFoodstuff instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemFoodCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("foodstuff:boiledrice", "inventory"));
	}
	public static class ItemFoodCustom extends ItemFood {
		public ItemFoodCustom() {
			super(2, 0.7f, true);
			setUnlocalizedName("boiledrice");
			setRegistryName("boiledrice");
			setCreativeTab(TabFoodstuffFromMod.tab);
			setMaxStackSize(64);
		}

		@Override
		public int getMaxItemUseDuration(ItemStack stack) {
			return 56;
		}

		@Override
		public EnumAction getItemUseAction(ItemStack par1ItemStack) {
			return EnumAction.EAT;
		}
	}
}
