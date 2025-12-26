package com.iafenvoy.server.i18n._loader.fabric;

//? fabric {
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
//? >=1.21.9 {
/*import com.iafenvoy.server.i18n.ServerI18nApi;
import com.iafenvoy.server.i18n.ServerI18nReloader;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
*///?} else {
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
//?}

public final class ServerI18nApiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        //? >=1.21.9 {
        /*ResourceLoader.get(PackType.SERVER_DATA).registerReloader(ResourceLocation.fromNamespaceAndPath(ServerI18nApi.MOD_ID, "server_config_reload"), ServerI18nReloader.INSTANCE);
        *///?} else {
         ResourceManagerHelper.get(PackType.SERVER_DATA).registerReloadListener(ServerI18nReloaderFabric.INSTANCE);
         //?}
    }
}
