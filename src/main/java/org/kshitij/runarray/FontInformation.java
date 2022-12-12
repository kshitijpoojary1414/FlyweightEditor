package org.kshitij.runarray;

import java.awt.*;

public class FontInformation {
    private int start ;
    private int end;
    private Font font;


    public FontInformation(int start, int end, Font font) {
        this.start = start;
        this.end = end;
        this.font = font;
    }

    public Font getFont() {
        return font;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}