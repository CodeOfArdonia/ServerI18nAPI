package com.iafenvoy.server.i18n;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

import java.util.HashMap;
import java.util.Map;

public enum ServerI18nReloader implements ResourceManagerReloadListener {
    INSTANCE;
    public static final ResourceLocation ID = /*? >=1.21 {*/ResourceLocation.fromNamespaceAndPath/*?} else {*//*new ResourceLocation*//*?}*/(ServerI18nApi.MOD_ID, ServerI18nApi.MOD_ID);
    public static final String DEFAULT_LANGUAGE = "en_us";
    private static final Map<String, Map<String, String>> DATA = new HashMap<>();

    @Override
    public void onResourceManagerReload(ResourceManager manager) {
        DATA.clear();
        for (Map.Entry<ResourceLocation, Resource> entry : manager.listResources("lang", p -> p.getPath().endsWith(".json")).entrySet()) {
            String language = entry.getKey().getPath().replaceAll(".json", "").replaceAll("lang/", "");
            if (!DATA.containsKey(language)) DATA.put(language, new HashMap<>());
            Map<String, String> map = DATA.get(language);
            try {
                JsonElement element = JsonParser.parseReader(entry.getValue().openAsReader());
                if (!element.isJsonObject()) continue;
                JsonObject obj = element.getAsJsonObject();
                for (String s : obj.keySet()) map.put(s, obj.get(s).getAsString());
            } catch (Exception e) {
                ServerI18nApi.LOGGER.error("Failed to load {}", entry.getKey().toString(), e);
            }
        }
    }

    public static String translate(String language, String key) {
        if (DATA.containsKey(language)) {
            Map<String, String> map = DATA.get(language);
            if (map.containsKey(key)) return DATA.get(language).get(key);
        }
        if (DATA.containsKey(DEFAULT_LANGUAGE)) return DATA.get(DEFAULT_LANGUAGE).getOrDefault(key, key);
        return key;
    }
}
