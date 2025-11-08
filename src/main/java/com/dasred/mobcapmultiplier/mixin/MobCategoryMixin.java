package com.dasred.mobcapmultiplier.mixin;

import com.dasred.mobcapmultiplier.Config;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.entity.MobCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MobCategory.class)
public abstract class MobCategoryMixin {

    @ModifyReturnValue(method = "getMaxInstancesPerChunk", at = @At("RETURN"))
    private int mobcapmultiplier$boostCap(int original) {
        MobCategory self = (MobCategory) (Object) this;

        if (self == MobCategory.MONSTER) {
            double mul = Config.MONSTER.get();
            return Math.max(0, (int) Math.round(original * mul));
        }

        if (self == MobCategory.CREATURE) {
            double mul = Config.CREATURE.get();
            return Math.max(0, (int) Math.round(original * mul));
        }

        if (self == MobCategory.AMBIENT) {
            double mul = Config.AMBIENT.get();
            return Math.max(0, (int) Math.round(original * mul));
        }

        if (self == MobCategory.AXOLOTLS) {
            double mul = Config.AXOLOTLS.get();
            return Math.max(0, (int) Math.round(original * mul));
        }

        if (self == MobCategory.UNDERGROUND_WATER_CREATURE) {
            double mul = Config.UNDERGROUND_WATER_CREATURE.get();
            return Math.max(0, (int) Math.round(original * mul));
        }

        if (self == MobCategory.WATER_CREATURE) {
            double mul = Config.WATER_CREATURE.get();
            return Math.max(0, (int) Math.round(original * mul));
        }

        if (self == MobCategory.WATER_AMBIENT) {
            double mul = Config.WATER_AMBIENT.get();
            return Math.max(0, (int) Math.round(original * mul));
        }

        if (self == MobCategory.MISC) {
            double mul = Config.MISC.get();
            return Math.max(0, (int) Math.round(original * mul));
        }

        return original;
    }
}