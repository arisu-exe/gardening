package io.github.fallOut015.gardening.item;

import io.github.fallOut015.gardening.block.BlocksGardening;
import io.github.fallOut015.gardening.block.FlowerInstance;
import io.github.fallOut015.gardening.tileentity.SoilTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.UseAction;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import java.util.Random;

public class WateringCanItem extends Item {
    public WateringCanItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getUseDuration(ItemStack itemStack) {
        return 36000;
    }
    @Override
    public UseAction getUseAnimation(ItemStack itemStack) {
        return UseAction.EAT;
    }
    @Override
    public ActionResultType useOn(ItemUseContext itemUseContext) {
        World level = itemUseContext.getLevel();
        BlockPos pos = itemUseContext.getClickedPos();
        BlockState state = level.getBlockState(pos);

        Random random = level.getRandom();

        if(state.is(BlocksGardening.SOIL.get())) {
            Vector3d l = itemUseContext.getClickLocation();
            int x = l.x() - (double) pos.getX() >= 0.5d ? 1 : 0;
            int z = l.z() - (double) pos.getZ() >= 0.5d ? 0 : 1;
            int i = z * 2 + x;

            SoilTileEntity soilTileEntity = (SoilTileEntity) level.getBlockEntity(pos);
            FlowerInstance flower = soilTileEntity.getFlowerAt(i);
            if(flower.hasFlower() && flower.canEnhance()) {
                flower.enhance();

                if(level.isClientSide) {
                    level.addParticle(ParticleTypes.RAIN, (double) pos.getX() + random.nextDouble() / 2d + ((double) x / 2d), (double) pos.getY() + 1.5d, (double) pos.getZ() + random.nextDouble() / 2d + ((double) z / 2d), 0, 0, 0);
                    level.addParticle(ParticleTypes.RAIN, (double) pos.getX() + random.nextDouble() / 2d + ((double) x / 2d), (double) pos.getY() + 1.5d, (double) pos.getZ() + random.nextDouble() / 2d + ((double) z / 2d), 0, 0, 0);
                }
            }
        }

        if(level.isClientSide) {
            level.addParticle(ParticleTypes.RAIN, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + (state.getMaterial().isSolid() ? 1.5d : 0.5d), (double) pos.getZ() + random.nextDouble(), 0, 0, 0);
            level.addParticle(ParticleTypes.RAIN, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + (state.getMaterial().isSolid() ? 1.5d : 0.5d), (double) pos.getZ() + random.nextDouble(), 0, 0, 0);
        }
        if(state.is(Blocks.FARMLAND) && state.getValue(FarmlandBlock.MOISTURE).intValue() < 7) {
            itemUseContext.getItemInHand().hurtAndBreak(1, itemUseContext.getPlayer(), (p_220043_1_) -> p_220043_1_.broadcastBreakEvent(itemUseContext.getHand()));
            level.setBlockAndUpdate(pos, state.setValue(FarmlandBlock.MOISTURE, state.getValue(FarmlandBlock.MOISTURE) + 1));
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.FAIL;
    }
}