package com.dasred.mobcapmultiplier;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;

@Mod(MobCapMultiplier.MODID)
public class MobCapMultiplier {
    public static final String MODID = "mobcapmultiplier";

    public MobCapMultiplier(IEventBus modBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);

        NeoForge.EVENT_BUS.addListener(MobCapCommands::register);
    }
}