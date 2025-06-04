package com.iafenvoy.server.i18n.fabric;

import com.iafenvoy.server.i18n.ServerI18nApi;
import com.iafenvoy.server.i18n.ServerI18nReloader;
import net.fabricmc.fabric.api.resource.IdentifiableResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public enum ServerI18nReloaderFabric implements IdentifiableResourceReloadListener {
    INSTANCE;

    @Override
    public Identifier getFabricId() {
        return Identifier.of(ServerI18nApi.MOD_ID, ServerI18nApi.MOD_ID);
    }

    @Override
    public CompletableFuture<Void> reload(Synchronizer synchronizer, ResourceManager manager, Profiler prepareProfiler, Profiler applyProfiler, Executor prepareExecutor, Executor applyExecutor) {
        return ServerI18nReloader.INSTANCE.reload(synchronizer, manager, prepareProfiler, applyProfiler, prepareExecutor, applyExecutor);
    }
}
