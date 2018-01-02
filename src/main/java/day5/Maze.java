package day5;

import java.util.ArrayList;

/**
 * Created by Johanna on 30/12/2017.
 */
public class Maze {
    ArrayList<Integer> listOfOffsets = new ArrayList<>();

    public int countStepsToEscapeMaze(String input) {
        setListOfOffsets(input);

        int counter = 0;
        int index = 0;
        int offset;

        while(index < getListOfOffsets().size()) {
            counter++;
            offset = getOffsetAndIncrease(index);
            if(offset != 0) {
                index = index + offset;
            }
        }
        return counter;
    }

    public int getOffsetAndIncrease(int index) {
        int originalValue = getListOfOffsets().get(index);
        getListOfOffsets().set(index, originalValue + 1);

        return originalValue;
    }

    public void setListOfOffsets(String input) {
        for(String line : input.split("\\n")) {
            int offSet;
            if(line.substring(0, 1).equals("-")) {
                offSet = Integer.valueOf(line.substring(1)) * (-1);
            } else {
                offSet = Integer.valueOf(line);
            }
            listOfOffsets.add(offSet);
        }
    }

    public ArrayList<Integer> getListOfOffsets() {
        return listOfOffsets;
    }
}
