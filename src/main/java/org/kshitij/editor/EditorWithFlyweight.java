package org.kshitij.editor;

import org.kshitij.EditorICharacter;
import org.kshitij.factory.CharacterFactory;
import org.kshitij.factory.FontFactory;
import org.kshitij.flyweight.ICharacter;
import org.kshitij.utils.SizeofUtil;

import java.util.*;

// Size here is hardcoded with 356, It should be generalized for editor text.
public class EditorWithFlyweight implements Editor {
    private String text = "";
    private int noOfObjects = 0;
    public EditorWithFlyweight(String text) {
        this.text = text;
    }

    public int getNumberOfCharacterObjectsCreated (){
        return noOfObjects;
    }

    public double size() {
        return new SizeofUtil() {

            char[] textArray = text.toCharArray();

            CharacterFactory characterFactory = CharacterFactory.getInstance();
            FontFactory fontFactory = FontFactory.getInstance();
            ArrayList<ICharacter> characterList = new ArrayList<>();

            @Override
            protected int create() {

//                noOfObjects = 0;
//                Font font = fontFactory.getFont("Arial", Font.BOLD,12);
//                Font font1 = fontFactory.getFont("Times New Roman", Font.ITALIC,10);
//
//
//                RunArray aRun = new RunArray();
//                aRun.addRun(0,115,font ); // 0 -- 114
//                aRun.addRun(115, 211, font1); // 114- 325

                for(int i=0; i< 356; i++){
                    EditorICharacter editorCharacter = (EditorICharacter) characterFactory.getEditorCharacter(textArray[i]);

                    if(!characterList.contains(editorCharacter)) {

                        noOfObjects ++;
                    }

                    characterList.add(editorCharacter);

                }
//                FontFactory.clearInstance();
//                CharacterFactory.clearInstance();
                return 1;
            }
        }.averageBytes();
    }

}
