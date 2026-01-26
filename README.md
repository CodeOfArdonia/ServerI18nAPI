# Server I18n API

This is a server side only mod to provide i18n for server side only mods.

Language detection is automatically so players don't need to do anything.

**This mod is not needed on client**

## Guide for developers

You need to put language jsons in `data/<mod id>/lang/`, in vanilla assets pack format.

The only API is `ServerI18n` class.

Examples:

`Text.literal(ServerI18n.translate(player,"translation key","arg1","arg2"))`

`ServerI18n.broadcast(server,"translation key","arg1","arg2")`