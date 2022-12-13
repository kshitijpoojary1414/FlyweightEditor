package org.kshitij.editor;

import org.kshitij.StyledChar;
import org.kshitij.utils.SizeofUtil;

import java.awt.*;
import java.util.ArrayList;

public class EditorWithoutFlyweight implements Editor {
    private String text = "";

    private int noOfObjects = 0;
    public EditorWithoutFlyweight(String text) {
        this.text = text;
    }
    @Override
    public int getNumberOfCharacterObjectsCreated (){
        return noOfObjects;
    }
    @Override
    public double size() {

        return new SizeofUtil() {

            char[] textArray = text.toCharArray();

            ArrayList<StyledChar> characterList = new ArrayList<StyledChar>();

            @Override
            protected int create() {
                for(int i=0; i<textArray.length; i++){
                    Font font = new Font("Arial", Font.BOLD,12);
                    StyledChar styledChar = new StyledChar(textArray[i]);
                    styledChar.applyFont(font);
                    characterList.add(styledChar);
                }
                return 1;
            }
        }.averageBytes();
    }
}
