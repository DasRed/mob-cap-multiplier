package com.dasred.mobcapmultiplier;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

public final class MobCapCommands {
    private MobCapCommands() {
    }

    private static final String ARG_CATEGORY = "category";
    private static final String ARG_VALUE = "value";

    private static final String[] CATEGORIES = new String[]{
            "monster",
            "creature",
            "ambient",
            "axolotls",
            "undergroundWaterCreature",
            "waterCreature",
            "waterAmbient",
            "misc"
    };

    private static final SuggestionProvider<CommandSourceStack> CATEGORY_SUGGESTIONS = (ctx, builder) -> {
        for (String s : CATEGORIES) builder.suggest(s);
        return builder.buildFuture();
    };

    public static void register(final RegisterCommandsEvent event) {
        var dispatcher = event.getDispatcher();

        // Full command: /mobcapmultiplier ...
        LiteralArgumentBuilder<CommandSourceStack> root = literalRoot("mobcapmultiplier");
        dispatcher.register(root);

        // Alias: /mcm ...
        LiteralArgumentBuilder<CommandSourceStack> alias = literalRoot("mcm");
        dispatcher.register(alias);
    }

    private static LiteralArgumentBuilder<CommandSourceStack> literalRoot(String name) {
        return Commands.literal(name)
                .requires(src -> src.hasPermission(2)) // level 2+: commands allowed
                .then(Commands.literal("get")
                        .then(Commands.argument(ARG_CATEGORY, StringArgumentType.word())
                                .suggests(CATEGORY_SUGGESTIONS)
                                .executes(MobCapCommands::get)))
                .then(Commands.literal("set")
                        .then(Commands.argument(ARG_CATEGORY, StringArgumentType.word())
                                .suggests(CATEGORY_SUGGESTIONS)
                                .then(Commands.argument(ARG_VALUE, DoubleArgumentType.doubleArg(0.0D, 100.0D))
                                        .executes(MobCapCommands::set))))
                .then(Commands.literal("reset")
                        .executes(MobCapCommands::resetAll))
                .then(Commands.literal("list")
                        .executes(MobCapCommands::list))
                ;
    }

    private static int get(CommandContext<CommandSourceStack> ctx) {
        String cat = StringArgumentType.getString(ctx, ARG_CATEGORY);
        double val = getValue(cat);
        if (Double.isNaN(val)) {
            ctx.getSource().sendFailure(Component.literal("Unknown category: " + cat));
            return 0;
        }
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier[" + cat + "] = " + val), false);
        return Command.SINGLE_SUCCESS;
    }

    private static int set(CommandContext<CommandSourceStack> ctx) {
        String cat = StringArgumentType.getString(ctx, ARG_CATEGORY);
        double newVal = DoubleArgumentType.getDouble(ctx, ARG_VALUE);
        boolean ok = setValue(cat, newVal);
        if (!ok) {
            ctx.getSource().sendFailure(Component.literal("Unknown category: " + cat));
            return 0;
        }
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: " + cat + " set to " + newVal + " (effective immediately)"), true);
        return Command.SINGLE_SUCCESS;
    }

    private static int resetAll(CommandContext<CommandSourceStack> ctx) {
        // Reset all multipliers back to 1.0 (vanilla)
        Config.MONSTER.set(1.0D);
        Config.CREATURE.set(1.0D);
        Config.AMBIENT.set(1.0D);
        Config.AXOLOTLS.set(1.0D);
        Config.UNDERGROUND_WATER_CREATURE.set(1.0D);
        Config.WATER_CREATURE.set(1.0D);
        Config.WATER_AMBIENT.set(1.0D);
        Config.MISC.set(1.0D);
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: all categories reset to 1.0 (vanilla)"), true);
        return Command.SINGLE_SUCCESS;
    }

    private static int list(CommandContext<CommandSourceStack> ctx) {
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: monster = " + Config.MONSTER.get()), true);
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: creature = " + Config.CREATURE.get()), true);
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: ambient = " + Config.AMBIENT.get()), true);
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: axolotls = " + Config.AXOLOTLS.get()), true);
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: undergroundWaterCreature = " + Config.UNDERGROUND_WATER_CREATURE.get()), true);
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: waterCreature = " + Config.WATER_CREATURE.get()), true);
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: waterAmbient = " + Config.WATER_AMBIENT.get()), true);
        ctx.getSource().sendSuccess(() -> Component.literal("MobCapMultiplier: misc = " + Config.MISC.get()), true);
        return Command.SINGLE_SUCCESS;
    }

    private static double getValue(String category) {
        return switch (category) {
            case "monster" -> Config.MONSTER.get();
            case "creature" -> Config.CREATURE.get();
            case "ambient" -> Config.AMBIENT.get();
            case "axolotls" -> Config.AXOLOTLS.get();
            case "undergroundWaterCreature" -> Config.UNDERGROUND_WATER_CREATURE.get();
            case "waterCreature" -> Config.WATER_CREATURE.get();
            case "waterAmbient" -> Config.WATER_AMBIENT.get();
            case "misc" -> Config.MISC.get();
            default -> Double.NaN;
        };
    }

    private static boolean setValue(String category, double value) {
        switch (category) {
            case "monster":
                Config.MONSTER.set(value);
                return true;
            case "creature":
                Config.CREATURE.set(value);
                return true;
            case "ambient":
                Config.AMBIENT.set(value);
                return true;
            case "axolotls":
                Config.AXOLOTLS.set(value);
                return true;
            case "undergroundWaterCreature":
                Config.UNDERGROUND_WATER_CREATURE.set(value);
                return true;
            case "waterCreature":
                Config.WATER_CREATURE.set(value);
                return true;
            case "waterAmbient":
                Config.WATER_AMBIENT.set(value);
                return true;
            case "misc":
                Config.MISC.set(value);
                return true;
            default:
                return false;
        }
    }
}