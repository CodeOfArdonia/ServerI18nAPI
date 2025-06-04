package com.iafenvoy.server.i18n.mixin;

import com.iafenvoy.server.i18n.ServerI18nReloader;
import com.iafenvoy.server.i18n.util.ServerPlayerEntityAccessor;
import net.minecraft.network.packet.c2s.play.ClientSettingsC2SPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerEntityMixin implements ServerPlayerEntityAccessor {
    @Unique
    private String server_i18n_api$language = ServerI18nReloader.DEFAULT_LANGUAGE;

    @Inject(method = "setClientSettings", at = @At("HEAD"))
    private void handleLanguage(ClientSettingsC2SPacket packet, CallbackInfo ci) {
        this.server_i18n_api$language = packet.language();
    }

    @Override
    public String server_i18n_api$getLanguage() {
        return this.server_i18n_api$language;
    }
}
