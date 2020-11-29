
package net.mcreator.foodstuff.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.foodstuff.item.ItemBanana;
import net.mcreator.foodstuff.creativetab.TabFoodstuffFromMod;
import net.mcreator.foodstuff.ElementsFoodstuff;

@ElementsFoodstuff.ModElement.Tag
public class BlockLeavesforbanana extends ElementsFoodstuff.ModElement {
	@GameRegistry.ObjectHolder("foodstuff:leavesforbanana")
	public static final Block block = null;
	public BlockLeavesforbanana(ElementsFoodstuff instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("leavesforbanana"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0,
				new ModelResourceLocation("foodstuff:leavesforbanana", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.LEAVES);
			setUnlocalizedName("leavesforbanana");
			setSoundType(SoundType.PLANT);
			setHardness(1.05F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(153);
			setCreativeTab(TabFoodstuffFromMod.tab);
			setDefaultSlipperiness(0.7999999999999999f);
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(ItemBanana.block, (int) (1)));
		}
	}
}
