package org.kshitij.factory;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FontFactoryTest {

    @Test
    void testFactoryPersistence() {
        FontFactory fontFactory = FontFactory.getInstance();
        Font expectedFont = fontFactory.getFont("TIMES NEW ROMAN",12, Font.BOLD);
        FontFactory fontFactory2= FontFactory.getInstance();
        Font actualFont = fontFactory2.getFont("TIMES NEW ROMAN",12, Font.BOLD);
        assertEquals(expectedFont,actualFont);
    }

    @Test
    void getFont() {
        FontFactory fontFactory = FontFactory.getInstance();
        Font expectedFont = new Font("TIMES NEW ROMAN",12, Font.BOLD);
        Font actualFont = fontFactory.getFont("TIMES NEW ROMAN",12, Font.BOLD);
        assertEquals(actualFont.toString(),expectedFont.toString());
    }
}