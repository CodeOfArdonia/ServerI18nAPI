package com.iafenvoy.server.i18n;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum ServerI18nReloader implements ResourceManagerReloadListener {
    INSTANCE;
    public static final Identifier ID = Identifier.fromNamespaceAndPath(ServerI18nApi.MOD_ID, ServerI18nApi.MOD_ID);
    public static final String DEFAULT_LANGUAGE = "en_us";
    private static volatile Map<String, Map<String, String>> DATA = Collections.emptyMap();

    @Override
    public void onResourceManagerReload(ResourceManager manager) {
        final Map<String, Map<String, String>> pendingData = new HashMap<>();
        for (Map.Entry<Identifier, Resource> entry : manager.listResources("lang", p -> p.getPath().endsWith(".json")).entrySet()) {
            String language = removeSurrounding(entry.getKey().getPath());

            Map<String, String> map = pendingData.computeIfAbsent(language, k -> new HashMap<>());
            try {
                JsonElement element;
                try (Reader reader = entry.getValue().openAsReader()) {
                    element = JsonParser.parseReader(reader);
                }
                if (!element.isJsonObject()) continue;
                JsonObject obj = element.getAsJsonObject();
                obj.asMap().forEach((key, value) -> {
                    if (!value.isJsonPrimitive()) return;
                    map.put(key, value.getAsString());
                });
            } catch (Exception e) {
                ServerI18nApi.LOGGER.error("Failed to load {}", entry.getKey().toString(), e);
            }
        }
        DATA = Collections.unmodifiableMap(pendingData);
    }

    private static String removeSurrounding(String s) {
        int startIndex = 0, endIndex = s.length();
        if (s.startsWith("lang/")) startIndex = "lang/".length();
        if (s.endsWith(".json")) endIndex -= ".json".length();

        if (startIndex > endIndex) return "";   // does not happen
        return s.substring(startIndex, endIndex);
    }

    public static String translate(String language, String key) {
        String value = null;
        Map<String, String> map;
        if ((map = DATA.get(language)) != null) {
            value = map.get(key);
        }
        if (value == null && (map = DATA.get(DEFAULT_LANGUAGE)) != null) {
            value = map.get(key);
        }
        return value != null ? value : key;
    }
}
