package org.kshitij;



import org.kshitij.flyweight.ICharacter;

import java.awt.*;

public class EditorICharacter implements ICharacter {
    int unicode;
    public EditorICharacter(char character) {
        unicode = character;
    }

    @Override
    public void applyFont(Font font) {
        System.out.println("Applied font - " + font + " to " + (char)unicode );
    }

    public String toString() {
        return Character.toString((char)unicode);
    }
}
