package org.kshitij.factory;



import org.kshitij.EditorICharacter;
import org.kshitij.flyweight.ICharacter;

import java.util.HashMap;

public class CharacterFactory {
    private static HashMap<Character, ICharacter> factory = new HashMap<>();

    private static CharacterFactory singleInstance = null;

    private CharacterFactory() {
    }

    public ICharacter getEditorCharacter(Character character) {
        if (!factory.containsKey(character)) {
            factory.put(character,new EditorICharacter(character));
        }
        return factory.get(character);
    }
    public static CharacterFactory getInstance() {
        if (singleInstance == null) {
            singleInstance= new CharacterFactory();
        }
        return singleInstance;
    }

    public static void clearInstance() {
        factory = new HashMap<>();
    }
}
