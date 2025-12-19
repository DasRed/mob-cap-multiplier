package com.dasred.mobcapmultiplier.api.handler;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

import java.io.IOException;
import java.io.OutputStream;

public class AllEntitiesHandler implements HttpHandler {
    private final MinecraftServer mcServer;
    private static final Gson gson = new Gson();

    public AllEntitiesHandler(MinecraftServer mcServer) {
        this.mcServer = mcServer;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        JsonArray arr = new JsonArray();

        for (ServerLevel level : mcServer.getAllLevels()) {
            String dimensionId = level.dimension().location().toString();

            for (Entity entity : level.getEntities().getAll()) {
                JsonObject obj = new JsonObject();
                obj.addProperty("uuid", entity.getStringUUID());
                obj.addProperty("type", entity.getType().builtInRegistryHolder().key().location().toString());
                obj.addProperty("category", entity instanceof ItemEntity ? "item" : entity.getType().getCategory().getName());
                obj.addProperty("name", entity.getType().getDescription().getString());
                obj.addProperty("customName", entity.getCustomName() == null ? null : entity.getCustomName().getString());
                obj.addProperty("dimension", dimensionId);
                obj.addProperty("x", entity.getX());
                obj.addProperty("y", entity.getY());
                obj.addProperty("z", entity.getZ());
                obj.addProperty("onGround", entity.onGround());

                obj.addProperty("chunkLoaded", level.isLoaded(entity.blockPosition()));

                if (entity instanceof ItemEntity) {
                    JsonObject objItem = new JsonObject();
                    ItemStack itemStack = ((ItemEntity) entity).getItem();
                    objItem.addProperty("name", itemStack.getItem().getName().getString());
                    objItem.addProperty("type", itemStack.getItem().builtInRegistryHolder().key().location().toString());
                    objItem.addProperty("age", ((ItemEntity) entity).getAge());
                    objItem.addProperty("lifespan", ((ItemEntity) entity).lifespan);
                    objItem.addProperty("count", itemStack.getCount());
                    objItem.addProperty("popTime", itemStack.getPopTime());
                    obj.add("item", objItem);
                }

                JsonArray tags = new JsonArray();
                for (String tag : entity.getTags()) {
                    tags.add(tag);
                }
                obj.add("tags", tags);

                arr.add(obj);
            }
        }

        byte[] json = gson.toJson(arr).getBytes();
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        exchange.sendResponseHeaders(200, json.length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(json);
        }
    }
}
