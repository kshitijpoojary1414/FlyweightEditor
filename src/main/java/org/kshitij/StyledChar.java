package org.kshitij;

import org.kshitij.flyweight.ICharacter;

import java.awt.*;

public class StyledChar implements ICharacter {
    private int unicode;
    private Font font;
    public StyledChar(char character) {
        unicode = character;
    }

    public void applyFont(Font font) {
        this.font = font;
    }

    @Override
    public String toString() {
        return Character.toString((char)unicode);
    }
}
