package org.kshitij.factory;

import org.junit.jupiter.api.Test;
import org.kshitij.EditorICharacter;
import org.kshitij.flyweight.ICharacter;

import static org.junit.jupiter.api.Assertions.*;

class CharacterFactoryTest {
    private CharacterFactory characterFactory = CharacterFactory.getInstance();
    @Test
    void getEditorCharacter() {
        char expected = 'A';
        EditorICharacter actual = (EditorICharacter) characterFactory.getEditorCharacter('A');
        assertEquals(Character.toString(expected),actual.toString());
    }

    @Test
    void testFactoryPersistence() {
        ICharacter expected = characterFactory.getEditorCharacter('A');
        CharacterFactory characterFactory2 = CharacterFactory.getInstance();
        ICharacter actual = characterFactory2.getEditorCharacter('A');
        assertEquals(expected,actual);
    }

    @Test
    void clearInstance() {
        ICharacter testValue = characterFactory.getEditorCharacter('B');
        CharacterFactory.clearInstance();

    }
}