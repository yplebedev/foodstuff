
package net.mcreator.foodstuff.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.Block;

import net.mcreator.foodstuff.gui.GuiGlazerMenu;
import net.mcreator.foodstuff.creativetab.TabFoodstuffFromMod;
import net.mcreator.foodstuff.Foodstuff;
import net.mcreator.foodstuff.ElementsFoodstuff;

import java.util.Random;

@ElementsFoodstuff.ModElement.Tag
public class BlockGlazer extends ElementsFoodstuff.ModElement {
	@GameRegistry.ObjectHolder("foodstuff:glazer")
	public static final Block block = null;
	@GameRegistry.ObjectHolder("foodstuff:glazer_double")
	public static final Block block_slab_double = null;
	public BlockGlazer(ElementsFoodstuff instance) {
		super(instance, 46);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("glazer"));
		elements.blocks.add(() -> new BlockCustom.Double().setRegistryName("glazer_double"));
		elements.items.add(() -> new ItemSlab(block, (BlockSlab) block, (BlockSlab) block_slab_double).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("foodstuff:glazer", "inventory"));
	}
	public static class BlockCustom extends BlockSlab {
		public BlockCustom() {
			super(Material.ANVIL);
			setUnlocalizedName("glazer");
			setSoundType(SoundType.GROUND);
			setHardness(1F);
			setResistance(10F);
			setLightLevel(0F);
			setLightOpacity(0);
			setCreativeTab(TabFoodstuffFromMod.tab);
			IBlockState state = this.blockState.getBaseState().withProperty(VARIANT, BlockCustom.Variant.DEFAULT);
			if (!this.isDouble())
				state = state.withProperty(BlockSlab.HALF, EnumBlockHalf.BOTTOM);
			this.setDefaultState(state);
			this.useNeighborBrightness = !this.isDouble();
		}
		public static final PropertyEnum<BlockCustom.Variant> VARIANT = PropertyEnum.<BlockCustom.Variant>create("variant",
				BlockCustom.Variant.class);
		@Override
		public Item getItemDropped(IBlockState state, Random rand, int fortune) {
			return Item.getItemFromBlock(block);
		}

		@Override
		public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
			return new ItemStack(block);
		}

		@Override
		protected net.minecraft.block.state.BlockStateContainer createBlockState() {
			return this.isDouble()
					? new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{VARIANT})
					: new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{HALF, VARIANT});
		}

		@Override
		public IBlockState getStateFromMeta(int meta) {
			if (this.isDouble()) {
				return this.getDefaultState();
			} else {
				return this.getDefaultState().withProperty(HALF, BlockSlab.EnumBlockHalf.values()[meta % 2]);
			}
		}

		@Override
		public int getMetaFromState(IBlockState state) {
			if (this.isDouble()) {
				return 0;
			} else {
				return state.getValue(HALF).ordinal();
			}
		}

		@Override
		public String getUnlocalizedName(int meta) {
			return super.getUnlocalizedName();
		}

		@Override
		public IProperty<?> getVariantProperty() {
			return VARIANT;
		}

		@Override
		public Comparable<?> getTypeForItem(ItemStack stack) {
			return BlockCustom.Variant.DEFAULT;
		}

		@Override
		public boolean isDouble() {
			return false;
		}

		@Override
		public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
			if (isDouble())
				return true;
			return super.doesSideBlockRendering(state, world, pos, face);
		}
		public enum Variant implements IStringSerializable {
			DEFAULT;
			public String getName() {
				return "default";
			}
		}

		public static class Double extends BlockCustom {
			@Override
			public boolean isDouble() {
				return true;
			}
		}
		@Override
		public boolean isOpaqueCube(IBlockState state) {
			return false;
		}

		@Override
		public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing direction,
				float hitX, float hitY, float hitZ) {
			super.onBlockActivated(world, pos, state, entity, hand, direction, hitX, hitY, hitZ);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (entity instanceof EntityPlayer) {
				((EntityPlayer) entity).openGui(Foodstuff.instance, GuiGlazerMenu.GUIID, world, x, y, z);
			}
			return true;
		}
	}
}
