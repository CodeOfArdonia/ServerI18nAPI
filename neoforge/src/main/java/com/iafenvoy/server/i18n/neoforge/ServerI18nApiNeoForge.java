package com.iafenvoy.server.i18n.neoforge;

import com.iafenvoy.server.i18n.ServerI18nApi;
import com.iafenvoy.server.i18n.ServerI18nReloader;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.AddReloadListenerEvent;

@Mod(ServerI18nApi.MOD_ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
public final class ServerI18nApiNeoForge {
    public ServerI18nApiNeoForge() {
    }

    @SubscribeEvent
    public static void onReload(AddReloadListenerEvent event) {
        event.addListener(ServerI18nReloader.INSTANCE);
    }
}
