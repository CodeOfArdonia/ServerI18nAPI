package com.iafenvoy.server.i18n;

import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;

public class ServerI18nExceptionType implements CommandExceptionType {
    private final String key;

    public ServerI18nExceptionType(String key) {
        this.key = key;
    }

    public CommandSyntaxException create(CommandSourceStack source, String... format) throws CommandSyntaxException {
        return new CommandSyntaxException(this, ServerI18n.translateToLiteral(source, this.key, format));
    }
}
