package org.kshitij.editor;

import org.kshitij.EditorUnsharedCharacter;
import org.kshitij.utils.SizeofUtil;

import java.awt.*;
import java.util.ArrayList;

public class EditorWithoutFlyweight implements IEditor {
    private String text = "";

    private int noOfObjects = 0;
    public EditorWithoutFlyweight(String text) {
        this.text = text;
    }

    public int getNumberOfCharacterObjectsCreated (){
        return noOfObjects;
    }

    public double size() {


        return new SizeofUtil() {

            char[] textArray = text.toCharArray();

            ArrayList<EditorUnsharedCharacter> characterList = new ArrayList<EditorUnsharedCharacter>();

            @Override
            protected int create() {
                for(int i=0; i<textArray.length; i++){
                    Font font = new Font("Arial", Font.BOLD,12);
                    EditorUnsharedCharacter editorUnsharedCharacter = new EditorUnsharedCharacter(textArray[i]);
                    editorUnsharedCharacter.applyFont(font);
                    characterList.add(editorUnsharedCharacter);
                }
                return 1;
            }
        }.averageBytes();
    }
}
