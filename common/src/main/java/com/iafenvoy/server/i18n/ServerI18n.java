package com.iafenvoy.server.i18n;

import com.iafenvoy.server.i18n.util.ServerPlayerEntityAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public final class ServerI18n {
    public static final String DEFAULT_LANGUAGE = ServerI18nReloader.DEFAULT_LANGUAGE;

    public static String translate(ServerPlayerEntity player, String key, String... format) {
        return translate(((ServerPlayerEntityAccessor) player).server_i18n_api$getLanguage(), key, format);
    }

    public static String translate(String language, String key, String... format) {
        return ServerI18nReloader.translate(language, key).formatted((Object[]) format);
    }

    public static void broadcast(MinecraftServer server, String key, String... format) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList())
            player.sendMessage(Text.literal(translate(player, key, format)));
    }
}
