
package net.mcreator.foodstuff.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.foodstuff.gui.GuiJuiceBlock;
import net.mcreator.foodstuff.creativetab.TabFoodstuffFromMod;
import net.mcreator.foodstuff.Foodstuff;
import net.mcreator.foodstuff.ElementsFoodstuff;

@ElementsFoodstuff.ModElement.Tag
public class BlockJuicerBlock extends ElementsFoodstuff.ModElement {
	@GameRegistry.ObjectHolder("foodstuff:juicerblock")
	public static final Block block = null;
	public BlockJuicerBlock(ElementsFoodstuff instance) {
		super(instance, 54);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("juicerblock"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("foodstuff:juicerblock", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("juicerblock");
			setSoundType(SoundType.GLASS);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(255);
			setCreativeTab(TabFoodstuffFromMod.tab);
		}

		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction,
				float hitX, float hitY, float hitZ) {
			super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).openGui(Foodstuff.instance, GuiJuiceBlock.GUIID, world, x, y, z);
			}
			return true;
		}
	}
}
