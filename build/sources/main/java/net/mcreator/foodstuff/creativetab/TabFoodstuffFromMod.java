
package net.mcreator.foodstuff.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.foodstuff.item.ItemChocolate;
import net.mcreator.foodstuff.ElementsFoodstuff;

@ElementsFoodstuff.ModElement.Tag
public class TabFoodstuffFromMod extends ElementsFoodstuff.ModElement {
	public TabFoodstuffFromMod(ElementsFoodstuff instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabfoodstufffrommod") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemChocolate.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
