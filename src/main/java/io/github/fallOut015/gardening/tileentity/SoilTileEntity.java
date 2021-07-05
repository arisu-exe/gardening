package io.github.fallOut015.gardening.tileentity;

import io.github.fallOut015.gardening.block.FlowerInstance;
import io.github.fallOut015.gardening.block.FlowerType;
import net.minecraft.block.BlockState;
import net.minecraft.item.DyeColor;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SoilTileEntity extends TileEntity implements ITickableTileEntity {
    FlowerInstance[] flowers;

    public SoilTileEntity(TileEntityType<?> type) {
        super(type);
        this.flowers = new FlowerInstance[] {
            new FlowerInstance(), new FlowerInstance(), new FlowerInstance(), new FlowerInstance()
        };
    }
    public SoilTileEntity() {
        this(TileEntitiesGardening.SOIL.get());
    }
    public SoilTileEntity(IBlockReader blockReader) {
        this();
        this.level = (World) blockReader;
    }

    public FlowerInstance getFlowerAt(int i) { // 0 is top-left, 1 is top-right, 2 is bottom-left, 3 is bottom-right
        return this.flowers[i];
    }
    public FlowerInstance removeFlowerAt(int i) {
        FlowerInstance flower = this.getFlowerAt(i);
        this.flowers[i].remove();
        return flower;
    }
    public void placeFlowerAt(FlowerType flowerType, DyeColor color, int i) {
        this.flowers[i].setFlowerType(flowerType, color);
    }
    public int numSlots() {
        return this.flowers.length;
    }

    @Override
    public void tick() {
        for(FlowerInstance flower : this.flowers) {
            flower.tick(this.level);
        }
    }
    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        for(int i = 0; i < this.flowers.length; ++ i) {
            CompoundNBT _nbt = new CompoundNBT();
            this.flowers[i].serialize(_nbt);
            nbt.put("flower" + i, _nbt);
        }
        return super.save(nbt);
    }
    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        for(int i = 0; i < this.flowers.length; ++ i) {
            if(nbt.contains("flower" + i)) {
                this.flowers[i].deserialize((CompoundNBT) nbt.get("flower" + i));
            }
        }
        super.load(state, nbt);
    }
}