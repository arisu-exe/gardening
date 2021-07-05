package io.github.fallOut015.gardening.block;

import com.mojang.datafixers.util.Pair;
import io.github.fallOut015.gardening.item.FlowerItem;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class FlowerInstance {
    Optional<Pair<FlowerType, DyeColor>> flowerInfo;
    int age;
    float ageUp;

    public FlowerInstance() {
        this.flowerInfo = Optional.empty();
        this.age = 0;
        this.ageUp = 0;
    }

    public void serialize(CompoundNBT nbt) {
        this.flowerInfo.ifPresent(type -> {
            nbt.putString("flowerType", type.getFirst().getID());
            nbt.putInt("color_id", type.getSecond().getId());
        });
        nbt.putInt("age", this.age);
        nbt.putFloat("ageUp", this.ageUp);
    }
    public void deserialize(CompoundNBT nbt) {
        if (nbt.contains("flowerType")) {
            this.flowerInfo = Optional.of(Pair.of(FlowerTypes.fromID(nbt.getString("flowerType")), DyeColor.byId(nbt.getInt("color_id"))));
        }
        this.age = nbt.getInt("age");
        this.ageUp = nbt.getFloat("ageUp");
    }
    public boolean hasFlower() {
        return this.flowerInfo.isPresent();
    }
    public void tick(World level) {
        if(this.age < 5) {
            this.ageUp += new Random().nextFloat() * (level.isRaining() ? 0.002f : 0.001f);
            if(this.ageUp >= 1.0f) {
                this.ageUp = 0;
                ++ this.age;
                if(this.age == 5) {
                    this.remove();
                }
            }
        }
    }
    public void setFlowerType(FlowerType flowerType, DyeColor color) {
        this.flowerInfo = Optional.of(Pair.of(flowerType, color));
        this.age = 0;
        this.ageUp = 0;
    }
    public ResourceLocation getTextureForAge() {
        return this.flowerInfo.get().getFirst().getTextureForAgeAndColor(this.age, this.flowerInfo.get().getSecond());
    }
    public boolean canEnhance() {
        return this.age < 4;
    }
    public void enhance() {
        ++ this.age;
        this.ageUp = 0;
    }
    public boolean pickable() {
        return this.age >= 3;
    }
    public void remove() {
        this.age = 0;
        this.ageUp = 0;
        this.flowerInfo = Optional.empty();
    }
    public ItemStack getAsItemStack() {
        ItemStack itemStack = new ItemStack(this.flowerInfo.get().getFirst().getFlowerItem());
        FlowerItem.setColor(itemStack, this.flowerInfo.get().getSecond());
        return itemStack;
    }
}