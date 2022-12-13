package org.kshitij.runarray;

import java.awt.*;
import java.util.ArrayList;


//RunArray is only applicable with EditorWI
public class RunArray {

    private ArrayList<FontInformation> runArray;
    public RunArray() {
        runArray = new ArrayList<>();
    }

    public void addRun(int start, int end, Font font) {
        FontInformation fontInformation = new FontInformation(start,end,font);
        runArray.add(fontInformation);
    }

    public void appendRun(int characterCount, Font font) {
        FontInformation lastElement = runArray.get(runArray.size()-1);
        int lastIndex = lastElement.getEnd() + 1;
        runArray.add(new FontInformation(lastIndex , lastIndex + characterCount, font));
    }

    public Font getFont(int index) {
        for (int i = 0;i<runArray.size();i++) {
            FontInformation fontInformation = runArray.get(i);
            if(index >= fontInformation.getStart() && index <= fontInformation.getEnd()) {
                return fontInformation.getFont();
            }
        }
        return null;
    }

}
