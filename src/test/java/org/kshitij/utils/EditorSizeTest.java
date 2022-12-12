package org.kshitij.utils;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.kshitij.EditorICharacter;
import org.kshitij.editor.EditorWithFlyweight;
import org.kshitij.editor.EditorWithoutFlyweight;
import org.kshitij.editor.IEditor;
import org.kshitij.factory.CharacterFactory;
import org.kshitij.factory.FontFactory;
import org.kshitij.flyweight.ICharacter;
import org.kshitij.runarray.RunArray;

import java.awt.*;
import java.util.ArrayList;

public class EditorSizeTest {
    private String text = "CS 635 Advanced Object-Oriented Design & Programming\n" +
            "Fall Semester, 2018\n" +
            "Doc 17 Mediator, Flyweight, Facade, Demeter, Active Object\n" +
            "Nov 19, 2019\n" +
            "Copyright ©, All rights reserved. 2019 SDSU & Roger Whitney, 5500 Campanile Drive, San\n" +
            "Diego, CA 92182-7700 USA. OpenContent (http://www.opencontent.org/opl.shtml) license defines the copyright on this document.";
    private int count = 0;


    @Test
    public void testSpaceSaving() {
        IEditor editorWithoutFlyweight = new EditorWithoutFlyweight(text);
        IEditor editorWithFlyweight = new EditorWithFlyweight(text);
        System.out.println(editorWithFlyweight.size() + "-" + editorWithoutFlyweight.size());
        Assertions.assertTrue(editorWithFlyweight.size()<editorWithoutFlyweight.size());
    }

    /**
     * Tests if the calculated size of the editor is correct. The expected value is calculated by a similar process
     * by which we calculate the actual value.The only difference is that we use the sample data information like, running
     * the loop 356 times and creating new objects only 54 times since the given sample is 356 characters long and has
     * 54 distinct objects, which implies that if the flyweight pattern is implemented correctly the actual size should
     * match the expected size.
     */
    @Test
    public void testEditorSizeCalculation() {
        IEditor editorWithFlyweight = new EditorWithFlyweight(text);

        double expectedSize = new SizeofUtil()  {

            CharacterFactory characterFactory = CharacterFactory.getInstance();
            FontFactory fontFactory = FontFactory.getInstance();
            ArrayList<ICharacter> characterList = new ArrayList<>();

            @Override
            protected int create() {

                count = 0;
                Font font = fontFactory.getFont("Arial", Font.BOLD,12);
                Font font1 = fontFactory.getFont("Times New Roman", Font.ITALIC,10);


                RunArray aRun = new RunArray();
                aRun.addRun(0,115,font ); // 0 -- 114
                aRun.addRun(115, 211, font1); // 114- 325

                for(int i=0; i<356; i++){
                    EditorICharacter editorCharacter = (EditorICharacter) characterFactory.getEditorCharacter((char)count);
                    if(count<54) {
                        count +=1;
                    }
                    characterList.add(editorCharacter);

                }
                FontFactory.clearInstance();
                CharacterFactory.clearInstance();
                return 1;
            }
        }.averageBytes();
        Assertions.assertEquals(editorWithFlyweight.size(),expectedSize);
    }
}