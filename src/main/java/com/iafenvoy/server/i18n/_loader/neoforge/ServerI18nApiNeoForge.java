package com.iafenvoy.server.i18n._loader.neoforge;

//? neoforge {

/*import com.iafenvoy.server.i18n.ServerI18nApi;
import com.iafenvoy.server.i18n.ServerI18nReloader;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
//? <=1.20.6 {
/^import net.neoforged.neoforge.common.NeoForge;
 ^///?}
//? >=1.21.4 {
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;
//?} else {
/^import net.neoforged.neoforge.event.AddReloadListenerEvent;
^///?}

@Mod(ServerI18nApi.MOD_ID)
//? >=1.21 {
@EventBusSubscriber
//?} elif >=1.20.5 {
/^@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
 ^///?} else {
/^@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
 ^///?}
public final class ServerI18nApiNeoForge {
    public ServerI18nApiNeoForge() {
        //? <=1.20.6 {
        /^NeoForge.EVENT_BUS.addListener(JupiterNeoForge::registerServerListener);
         ^///?}
    }

    //? >=1.21 {
    @SubscribeEvent
            //?}
    public static void registerServerListener(/^? >=1.21.4 {^/AddServerReloadListenersEvent/^?} else {^//^AddReloadListenerEvent^//^?}^/ event) {
        event.addListener( /^? >=1.21.4 {^/ServerI18nReloader.ID,/^?}^/ServerI18nReloader.INSTANCE);
    }
}
*/