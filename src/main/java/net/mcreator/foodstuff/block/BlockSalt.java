
package net.mcreator.foodstuff.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.foodstuff.ElementsFoodstuff;

import java.util.Random;

@ElementsFoodstuff.ModElement.Tag
public class BlockSalt extends ElementsFoodstuff.ModElement {
	@GameRegistry.ObjectHolder("foodstuff:salt")
	public static final Block block = null;
	public BlockSalt(ElementsFoodstuff instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("salt"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("foodstuff:salt", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("salt");
			setSoundType(SoundType.SAND);
			setHarvestLevel("shovel", 1);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0.01F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.FOOD);
		}

		@Override
		public int quantityDropped(Random random) {
			return 2;
		}
	}
}
