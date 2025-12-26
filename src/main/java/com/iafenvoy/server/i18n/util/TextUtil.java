package com.iafenvoy.server.i18n.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
//? <=1.18.2 {
/*import net.minecraft.network.chat.TextComponent;
*///?}

public interface TextUtil {
    static MutableComponent literal(String text) {
        return /*? >=1.19 {*/Component.literal/*?} else {*//*new TextComponent*//*?}*/(text);
    }
}
