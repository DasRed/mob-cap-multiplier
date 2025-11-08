package com.dasred.mobcapmultiplier;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.DoubleValue MONSTER;
    public static final ModConfigSpec.DoubleValue CREATURE;
    public static final ModConfigSpec.DoubleValue AMBIENT;
    public static final ModConfigSpec.DoubleValue AXOLOTLS;
    public static final ModConfigSpec.DoubleValue UNDERGROUND_WATER_CREATURE;
    public static final ModConfigSpec.DoubleValue WATER_CREATURE;
    public static final ModConfigSpec.DoubleValue WATER_AMBIENT;
    public static final ModConfigSpec.DoubleValue MISC;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("Every multiplier can have a value between 0.0 and 100.0 as max-per-chunk cap (e.g. 1.0 = vanilla, 2.0 = double)")
                .comment("Has the multiplier the value 0.0, the spawn of this category is disabled.");

        builder.push("multiplier");
        MONSTER = builder
                .comment("Multiplier for MobCategory.MONSTER")
                .defineInRange("monster", 1.0D, 0.0D, 100.0D);

        CREATURE = builder
                .comment("Multiplier for MobCategory.CREATURE")
                .defineInRange("creature", 1.0D, 0.0D, 100.0D);

        AMBIENT = builder
                .comment("Multiplier for MobCategory.AMBIENT")
                .defineInRange("ambient", 1.0D, 0.0D, 100.0D);

        AXOLOTLS = builder
                .comment("Multiplier for MobCategory.AXOLOTLS")
                .defineInRange("axolotls", 1.0D, 0.0D, 100.0D);

        UNDERGROUND_WATER_CREATURE = builder
                .comment("Multiplier for MobCategory.UNDERGROUND_WATER_CREATURE")
                .defineInRange("undergroundWaterCreature", 1.0D, 0.0D, 100.0D);

        WATER_CREATURE = builder
                .comment("Multiplier for MobCategory.WATER_CREATURE")
                .defineInRange("waterCreature", 1.0D, 0.0D, 100.0D);

        WATER_AMBIENT = builder
                .comment("Multiplier for MobCategory.WATER_AMBIENT")
                .defineInRange("waterAmbient", 1.0D, 0.0D, 100.0D);

        MISC = builder
                .comment("Multiplier for MobCategory.MISC")
                .defineInRange("misc", 1.0D, 0.0D, 100.0D);

        builder.pop();
        SPEC = builder.build();
    }
}