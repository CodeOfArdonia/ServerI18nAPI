package com.iafenvoy.server.i18n;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.SynchronousResourceReloader;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public enum ServerI18nReloader implements SynchronousResourceReloader {
    INSTANCE;
    private static final Map<String, Map<String, String>> DATA = new HashMap<>();

    @Override
    public void reload(ResourceManager manager) {
        DATA.clear();
        for (Map.Entry<Identifier, Resource> entry : manager.findResources("lang", p -> p.getPath().endsWith(".json")).entrySet()) {
            String language = entry.getKey().getPath().replaceAll(".json", "").replaceAll("lang/", "");
            if (!DATA.containsKey(language)) DATA.put(language, new HashMap<>());
            Map<String, String> map = DATA.get(language);
            try {
                JsonElement element = JsonParser.parseReader(entry.getValue().getReader());
                if (!element.isJsonObject()) continue;
                JsonObject obj = element.getAsJsonObject();
                for (String s : obj.keySet()) map.put(s, obj.get(s).getAsString());
            } catch (Exception e) {
                ServerI18nApi.LOGGER.error("Failed to load {}", entry.getKey().toString(), e);
            }
        }
    }

    public static String translate(String language, String key) {
        if (!DATA.containsKey(language)) return key;
        return DATA.get(language).getOrDefault(key, key);
    }
}
