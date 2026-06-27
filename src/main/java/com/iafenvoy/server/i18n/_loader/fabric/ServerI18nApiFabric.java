package com.iafenvoy.server.i18n._loader.fabric;

import net.fabricmc.api.ModInitializer;
import net.minecraft.server.packs.PackType;
import com.iafenvoy.server.i18n.ServerI18nReloader;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;

public final class ServerI18nApiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ResourceLoader.get(PackType.SERVER_DATA).registerReloadListener(ServerI18nReloader.ID, ServerI18nReloader.INSTANCE);
    }
}