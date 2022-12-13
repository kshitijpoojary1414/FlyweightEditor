package org.kshitij.factory;

import org.kshitij.EditorICharacter;
import org.kshitij.flyweight.ICharacter;

import java.util.HashMap;

public class CharacterFactory {
    private static HashMap<Character, ICharacter> factory = new HashMap<>();

    private static CharacterFactory instance = null;

    private CharacterFactory() {
    }

    public ICharacter getEditorCharacter(Character character) {
        if (!factory.containsKey(character)) {
            factory.put(character,new EditorICharacter(character));
        }
        return factory.get(character);
    }
    public static CharacterFactory getInstance() {
        if (instance == null) {
            instance = new CharacterFactory();
        }
        return instance;
    }

    public static void clearInstance() {
        factory = new HashMap<>();
    }
}
