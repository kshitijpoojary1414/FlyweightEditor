package org.kshitij.factory;

import java.awt.*;
import java.util.HashMap;

public class FontFactory {
    HashMap<String, Font> factory = new HashMap<>();

    private static FontFactory singleInstance = null;

    private FontFactory() {

    }

    public static FontFactory getInstance() {
        if(singleInstance == null) {
            singleInstance = new FontFactory();
        }
        return singleInstance;
    }

    private String createHash(String fontName , int fontSize, int fontStyle) {
        return fontName + fontSize + fontStyle;
    }

    public Font getFont(String fontName , int fontSize, int fontStyle) {
        String key = createHash(fontName,fontSize,fontStyle);
        if(!factory.containsKey(key)) {
            factory.put(key, new Font(fontName, fontSize, fontStyle));
        }
        return factory.get(key);
    }

    public static void clearInstance() {
        singleInstance = new FontFactory();
    }
}
