package com.iafenvoy.server.i18n;

import com.iafenvoy.server.i18n.util.ServerPlayerEntityAccessor;
import com.iafenvoy.server.i18n.util.TextUtil;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

public final class ServerI18n {
    public static final String DEFAULT_LANGUAGE = ServerI18nReloader.DEFAULT_LANGUAGE;

    public static Component translateToLiteral(ServerPlayer player, String key, String... format) {
        return translateToLiteral(((ServerPlayerEntityAccessor) player).server_i18n_api$getLanguage(), key, format);
    }

    public static Component translateToLiteral(String language, String key, String... format) {
        return TextUtil.literal(translate(language, key, format));
    }

    public static Component translateToLiteral(CommandSourceStack stack, String key, String... format) throws CommandSyntaxException {
        return stack.isPlayer() ? translateToLiteral(stack.getPlayerOrException(), key, format) : translateToLiteral(DEFAULT_LANGUAGE, key, format);
    }

    public static String translate(ServerPlayer player, String key, String... format) {
        return translate(((ServerPlayerEntityAccessor) player).server_i18n_api$getLanguage(), key, format);
    }

    public static String translate(String language, String key, String... format) {
        return ServerI18nReloader.translate(language, key).formatted((Object[]) format);
    }

    public static String translate(CommandSourceStack stack, String key, String... format) throws CommandSyntaxException {
        return stack.isPlayer() ? translate(stack.getPlayerOrException(), key, format) : translate(DEFAULT_LANGUAGE, key, format);
    }

    public static void sendMessage(CommandSourceStack stack, String key, String... format) throws CommandSyntaxException {
        stack.sendSystemMessage(translateToLiteral(stack, key, format));
    }

    public static void sendMessage(ServerPlayer player, String key, String... format) {
        player.sendSystemMessage(translateToLiteral(player, key, format));
    }

    public static void broadcast(MinecraftServer server, String key, String... format) {
        for (ServerPlayer player : server.getPlayerList().getPlayers())
            sendMessage(player, key, format);
    }
}
