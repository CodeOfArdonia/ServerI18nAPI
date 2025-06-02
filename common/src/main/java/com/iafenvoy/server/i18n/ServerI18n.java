package com.iafenvoy.server.i18n;

import com.iafenvoy.server.i18n.util.ServerPlayerEntityAccessor;
import net.minecraft.server.network.ServerPlayerEntity;

public final class ServerI18n {
    public static String translate(ServerPlayerEntity player, String key) {
        return ServerI18nReloader.translate(((ServerPlayerEntityAccessor) player).server_i18n_api$getLanguage(), key);
    }

    public static String translate(String language, String key) {
        return ServerI18nReloader.translate(language, key);
    }
}
