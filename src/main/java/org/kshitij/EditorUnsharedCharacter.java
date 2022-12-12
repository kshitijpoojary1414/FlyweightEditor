package org.kshitij;

import org.kshitij.flyweight.ICharacter;

import java.awt.*;

public class EditorUnsharedCharacter implements ICharacter {
    private int unicode;
    private Font font;
    public EditorUnsharedCharacter(char character) {
        unicode = character;
    }

    public void applyFont(Font font) {
        this.font = font;
    }

    public String toString() {
        return Character.toString((char)unicode);
    }
}
