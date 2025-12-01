package com.dasred.mobcapmultiplier.api;

import com.dasred.mobcapmultiplier.api.handler.AllEntitiesHandler;
import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import net.minecraft.server.MinecraftServer;

import java.net.InetSocketAddress;

public class HttpApiServer {
    private static HttpServer server;
    private static final Gson gson = new Gson();

    public static void start(MinecraftServer mcServer, int port) {
        try {
            server = HttpServer.create(new InetSocketAddress(port), 0);

            server.createContext("/entities", new AllEntitiesHandler(mcServer));

            server.start();
            System.out.println("[MobCapMultiplier] HTTP API gestartet auf Port " + port);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        if (server != null) {
            server.stop(0);
            System.out.println("[MobCapMultiplier] HTTP API gestoppt.");
        }
    }
}