package com.iafenvoy.server.i18n.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
//? <=1.18.2 {
/*import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
*///?}

public interface TextUtil {
    static MutableComponent empty() {
        return /*? >=1.19 {*/Component.empty();/*?} else {*//*new TextComponent("");*//*?}*/
    }

    static MutableComponent literal(String text) {
        return /*? >=1.19 {*/Component.literal/*?} else {*//*new TextComponent*//*?}*/(text);
    }

    static MutableComponent translatable(String text, Object... args) {
        return /*? >=1.19 {*/Component.translatable/*?} else {*//*new TranslatableComponent*//*?}*/(text, args);
    }

    //Fallback only available on 1.19.2+
    static MutableComponent translatableWithFallback(String text, String fallback, Object... args) {
        //? >=1.19.3 {
        return Component.translatableWithFallback(text, fallback, args);
        //?} else >=1.19 {
        /*return Component.translatable(text, args);
         *///?} else {
        /*return new TranslatableComponent(text,args);
         *///?}
    }
}
