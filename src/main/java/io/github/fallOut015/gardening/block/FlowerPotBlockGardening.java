package io.github.fallOut015.gardening.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.item.DyeColor;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class FlowerPotBlockGardening extends FlowerPotBlock {
    private static final EnumProperty<DyeColor> COLOR = EnumProperty.create("color", DyeColor.class);

    public FlowerPotBlockGardening(@Nullable Supplier<FlowerPotBlock> emptyPot, Supplier<? extends Block> block, Properties properties) {
        super(emptyPot, block, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(COLOR, ((FlowerBlockGardening) block.get()).getFlowerType().getColors().get(0)));

        if(emptyPot != null) {
            emptyPot.get().addPlant(this.getContent().getRegistryName(), () -> this);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(COLOR);
    }
}