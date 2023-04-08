package io.github.schntgaispock.gastronomicon.util;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ChunkPDC {

    private static String locationToString(Block b) {
        final Location l = b.getLocation();
        return l.getBlockX() + " " + l.getBlockY() + " " + l.getBlockZ();
    }

    // private static Location locationFromString(World w, String s) {
    //     final String[] locations = s.split(" ");
    //     return new Location(w, Integer.parseInt(locations[0]), Integer.parseInt(locations[1]), Integer.parseInt(locations[2]));
    // }
    
    public static JsonElement get(Block b, NamespacedKey key) {
        final JsonObject obj = PersistentDataAPI.getJsonObject(b.getChunk(), key);
        return obj == null ? null : obj.get(locationToString(b));
    }

    public static String getString(Block b, NamespacedKey key) {
        final JsonElement elem = get(b, key);
        return elem == null ? null : elem.getAsString();
    }

    public static Integer getInt(Block b, NamespacedKey key) {
        final JsonElement elem = get(b, key);
        return elem == null ? null : elem.getAsInt();
    }

    public static Boolean getBool(Block b, NamespacedKey key) {
        final JsonElement elem = get(b, key);
        return elem == null ? null : elem.getAsBoolean();
    }

    public static JsonElement getOrCreateDefault(Block b, NamespacedKey key, JsonElement def) {
        final JsonElement elem = get(b, key);
        if (elem == null) {
            final JsonObject obj = new JsonObject();
            obj.add(locationToString(b), def);
            PersistentDataAPI.setJsonObject(b.getChunk(), key, obj);
            return def;
        } else {
            return elem;
        }
    }

    public static String getOrCreateDefault(Block b, NamespacedKey key, String def) {
        final JsonElement elem = get(b, key);
        if (elem == null) {
            final JsonObject obj = new JsonObject();
            obj.addProperty(locationToString(b), def);
            PersistentDataAPI.setJsonObject(b.getChunk(), key, obj);
            return def;
        } else {
            return elem.getAsString();
        }
    }

    public static Integer getOrCreateDefault(Block b, NamespacedKey key, int def) {
        final JsonElement elem = get(b, key);
        if (elem == null) {
            final JsonObject obj = new JsonObject();
            obj.addProperty(locationToString(b), def);
            PersistentDataAPI.setJsonObject(b.getChunk(), key, obj);
            return def;
        } else {
            return elem.getAsInt();
        }
    }

    public static Boolean getOrCreateDefault(Block b, NamespacedKey key, boolean def) {
        final JsonElement elem = get(b, key);
        if (elem == null) {
            final JsonObject obj = new JsonObject();
            obj.addProperty(locationToString(b), def);
            PersistentDataAPI.setJsonObject(b.getChunk(), key, obj);
            return def;
        } else {
            return elem.getAsBoolean();
        }
    }

    public static void set(Block b, NamespacedKey key, JsonElement value) {
        final JsonObject obj = PersistentDataAPI.getJsonObject(b.getChunk(), key, new JsonObject());
        obj.add(locationToString(b), value);
        PersistentDataAPI.setJsonObject(b.getChunk(), key, obj);
    }

    public static void set(Block b, NamespacedKey key, String value) {
        final JsonObject obj = PersistentDataAPI.getJsonObject(b.getChunk(), key, new JsonObject());
        obj.addProperty(locationToString(b), value);
        PersistentDataAPI.setJsonObject(b.getChunk(), key, obj);
    }

    public static void set(Block b, NamespacedKey key, int value) {
        final JsonObject obj = PersistentDataAPI.getJsonObject(b.getChunk(), key, new JsonObject());
        obj.addProperty(locationToString(b), value);
        PersistentDataAPI.setJsonObject(b.getChunk(), key, obj);
    }

    public static void set(Block b, NamespacedKey key, boolean value) {
        final JsonObject obj = PersistentDataAPI.getJsonObject(b.getChunk(), key, new JsonObject());
        obj.addProperty(locationToString(b), value);
        PersistentDataAPI.setJsonObject(b.getChunk(), key, obj);
    }

    public static void remove(Block b, NamespacedKey key) {
        final JsonObject obj = PersistentDataAPI.getJsonObject(b.getChunk(), key);
        if (obj == null) return;
        obj.remove(locationToString(b));
    }

}
