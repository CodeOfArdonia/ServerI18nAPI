package com.iafenvoy.server.i18n._loader.neoforge;

import com.iafenvoy.server.i18n.ServerI18nApi;
import com.iafenvoy.server.i18n.ServerI18nReloader;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;

@Mod(ServerI18nApi.MOD_ID)
@EventBusSubscriber
public final class ServerI18nApiNeoForge {
    public ServerI18nApiNeoForge() {
    }

    @SubscribeEvent
    public static void registerServerListener(AddServerReloadListenersEvent event) {
        event.addListener(ServerI18nReloader.ID, ServerI18nReloader.INSTANCE);
    }
}
