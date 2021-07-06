package io.github.fallOut015.gardening.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerBlock;
import net.minecraft.item.DyeColor;
import net.minecraft.potion.Effect;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;

public class FlowerBlockGardening extends FlowerBlock {
    private static final EnumProperty<DyeColor> COLOR = EnumProperty.create("color", DyeColor.class);
    final FlowerType flowerType;

    public FlowerBlockGardening(final FlowerType flowerType, Effect effect, int duration, Properties properties) {
        super(effect, duration, properties);
        this.flowerType = flowerType;
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, flowerType.getColors().get(0)));
    }

    public final FlowerType getFlowerType() {
        return this.flowerType;
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }
}