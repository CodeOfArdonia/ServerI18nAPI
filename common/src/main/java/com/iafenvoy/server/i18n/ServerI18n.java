package com.iafenvoy.server.i18n;

import com.iafenvoy.server.i18n.util.ServerPlayerEntityAccessor;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public final class ServerI18n {
    public static final String DEFAULT_LANGUAGE = ServerI18nReloader.DEFAULT_LANGUAGE;

    public static Text translateToLiteral(ServerPlayerEntity player, String key, String... format) {
        return translateToLiteral(((ServerPlayerEntityAccessor) player).server_i18n_api$getLanguage(), key, format);
    }

    public static Text translateToLiteral(String language, String key, String... format) {
        return Text.literal(translate(language, key, format));
    }

    public static Text translateToLiteral(ServerCommandSource source, String key, String... format) throws CommandSyntaxException {
        return source.isExecutedByPlayer() ? translateToLiteral(source.getPlayerOrThrow(), key, format) : translateToLiteral(DEFAULT_LANGUAGE, key, format);
    }

    public static String translate(ServerPlayerEntity player, String key, String... format) {
        return translate(((ServerPlayerEntityAccessor) player).server_i18n_api$getLanguage(), key, format);
    }

    public static String translate(String language, String key, String... format) {
        return ServerI18nReloader.translate(language, key).formatted((Object[]) format);
    }

    public static String translate(ServerCommandSource source, String key, String... format) throws CommandSyntaxException {
        return source.isExecutedByPlayer() ? translate(source.getPlayerOrThrow(), key, format) : translate(DEFAULT_LANGUAGE, key, format);
    }

    public static void broadcast(MinecraftServer server, String key, String... format) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList())
            player.sendMessage(translateToLiteral(player, key, format));
    }
}
