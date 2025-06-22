package com.iafenvoy.server.i18n.fabric;

import com.iafenvoy.server.i18n.ServerI18nApi;
import com.iafenvoy.server.i18n.ServerI18nReloader;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.util.Identifier;

public enum ServerI18nReloaderFabric implements SynchronousResourceReloader, IdentifiableResourceReloadListener {
    INSTANCE;

    @Override
    public Identifier getFabricId() {
        return Identifier.of(ServerI18nApi.MOD_ID, ServerI18nApi.MOD_ID);
    }

    @Override
    public void reload(ResourceManager manager) {
        ServerI18nReloader.INSTANCE.reload(manager);
    }
}
