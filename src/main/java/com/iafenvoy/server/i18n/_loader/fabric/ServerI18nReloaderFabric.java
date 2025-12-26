package com.iafenvoy.server.i18n._loader.fabric;

//? fabric && <=1.21.8 {
import com.iafenvoy.server.i18n.ServerI18nReloader;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

public enum ServerI18nReloaderFabric implements ResourceManagerReloadListener, IdentifiableResourceReloadListener {
    INSTANCE;

    @Override
    public ResourceLocation getFabricId() {
        return ServerI18nReloader.ID;
    }

    @Override
    public void onResourceManagerReload(ResourceManager manager) {
        ServerI18nReloader.INSTANCE.onResourceManagerReload(manager);
    }
}