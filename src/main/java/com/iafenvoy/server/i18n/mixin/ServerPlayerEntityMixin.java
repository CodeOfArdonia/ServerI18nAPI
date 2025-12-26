package com.iafenvoy.server.i18n.mixin;

import com.iafenvoy.server.i18n.ServerI18nReloader;
import com.iafenvoy.server.i18n.util.ServerPlayerEntityAccessor;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class ServerPlayerEntityMixin implements ServerPlayerEntityAccessor {
    @Unique
    private String server_i18n_api$language = ServerI18nReloader.DEFAULT_LANGUAGE;

    @Inject(method = "updateOptions", at = @At("HEAD"))
    private void handleLanguage(ClientInformation clientOptions, CallbackInfo ci) {
        this.server_i18n_api$language = clientOptions.language();
    }

    @Override
    public String server_i18n_api$getLanguage() {
        return this.server_i18n_api$language;
    }
}
