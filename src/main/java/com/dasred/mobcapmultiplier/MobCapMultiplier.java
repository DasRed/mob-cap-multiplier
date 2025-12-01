package com.dasred.mobcapmultiplier;

import com.dasred.mobcapmultiplier.api.HttpApiServer;
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


        // Start server at MC start
        NeoForge.EVENT_BUS.addListener((net.neoforged.neoforge.event.server.ServerStartedEvent e) -> {
            HttpApiServer.start(e.getServer(), Config.PORT.getAsInt());
        });

        // Stop server when MC stops
        NeoForge.EVENT_BUS.addListener((net.neoforged.neoforge.event.server.ServerStoppingEvent e) -> {
            HttpApiServer.stop();
        });
    }
}