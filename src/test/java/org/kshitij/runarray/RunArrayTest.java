package org.kshitij.runarray;

import org.junit.jupiter.api.Test;
import org.kshitij.factory.FontFactory;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RunArrayTest {
    private FontFactory aFontFactory = FontFactory.getInstance();

    @Test
    void addRun() {
        Font fontA = aFontFactory.getFont("TIMES NEW ROMAN",Font.ITALIC,10);
        Font fontB = aFontFactory.getFont("ARIAL",Font.BOLD,12);

        RunArray runArray = new RunArray();
        runArray.addRun(1,5,fontA);
        runArray.addRun(6,8,fontB);

        assertEquals(runArray.getFont(2),fontA);
        assertEquals(runArray.getFont(7),fontB);

    }

    @Test
    void appendRun() {
        Font fontA = aFontFactory.getFont("TIMES NEW ROMAN",Font.ITALIC,10);
        Font fontB = aFontFactory.getFont("ARIAL",Font.BOLD,12);

        RunArray runArray = new RunArray();
        runArray.addRun(1,5,fontA);
        runArray.addRun(6,8,fontB);
        runArray.appendRun(10,fontA);


        assertEquals(runArray.getFont(12),fontA);
    }

    @Test
    void getFont() {
        Font fontA = aFontFactory.getFont("TIMES NEW ROMAN",Font.ITALIC,10);
        Font fontB = aFontFactory.getFont("ARIAL",Font.BOLD,12);

        RunArray runArray = new RunArray();
        runArray.addRun(1,5,fontA);



        assertEquals(runArray.getFont(2),fontA);
    }
}