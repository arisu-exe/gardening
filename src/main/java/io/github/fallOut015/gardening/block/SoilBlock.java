package io.github.fallOut015.gardening.block;

import io.github.fallOut015.gardening.item.SeedsItem;
import io.github.fallOut015.gardening.tileentity.SoilTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class SoilBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(0d, 0d, 0d, 16d, 15d, 16d);
    private static final Predicate<ItemStack> PLANTABLE = itemStack -> itemStack.getItem() instanceof SeedsItem || (itemStack.getItem() instanceof BlockItem && ((BlockItem) itemStack.getItem()).getBlock() instanceof FlowerBlock);

    public SoilBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType use(BlockState state, World level, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        SoilTileEntity soilTileEntity = (SoilTileEntity) level.getBlockEntity(pos);
        Vector3d l = result.getLocation();
        double xoff = l.x() - (double) pos.getX() >= 0.5d ? 0.5d : 0;
        double zoff = l.z() - (double) pos.getZ() >= 0.5d ? 0.5d : 0;

        int i = (int) Math.round(zoff * 4d + xoff * 2d);

        ItemStack itemStack = player.getItemInHand(hand);

        if(!soilTileEntity.getFlowerAt(i).hasFlower() && PLANTABLE.test(itemStack)) {
            soilTileEntity.placeFlowerAt(((SeedsItem) itemStack.getItem()).getFlowerType(), SeedsItem.getColor(itemStack), i);
            itemStack.shrink(1);

            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }
    @Override
    public VoxelShape getShape(BlockState s, IBlockReader l, BlockPos p, ISelectionContext c) {
        return SHAPE;
    }
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new SoilTileEntity(world);
    }
}