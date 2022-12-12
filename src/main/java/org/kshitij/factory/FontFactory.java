package org.kshitij.factory;

import java.awt.*;
import java.util.HashMap;

public class FontFactory {
    HashMap<String, Font> factory = new HashMap<>();

    private static FontFactory instance = null;

    private FontFactory() {

    }

    public static FontFactory getInstance() {
        if(instance == null) {
            instance = new FontFactory();
        }
        return instance;
    }

    private String getHash(String fontName , int fontSize, int fontStyle) {
        return fontName + fontSize + fontStyle;
    }

    public Font getFont(String fontName , int fontSize, int fontStyle) {
        String key = getHash(fontName,fontSize,fontStyle);
        if(!factory.containsKey(key)) {
            factory.put(key, new Font(fontName, fontSize, fontStyle));
        }
        return factory.get(key);
    }

    public static void clearInstance() {
        instance = new FontFactory();
    }
}
