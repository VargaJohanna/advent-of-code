package day5;

/**
 * Created by Johanna on 02/01/2018.
 */
public class MazePart2 extends Maze {
    public int countStepsToEscapeMazePart2(String input) {
        setListOfOffsets(input);

        int counter = 0;
        int index = 0;
        int offset;

        while(index < getListOfOffsets().size()) {
            counter++;
            offset = getOffsetAndDecreaseIncrease(index);
            if(offset != 0) {
                index = index + offset;
            }
        }
        return counter;
    }

    public int getOffsetAndDecreaseIncrease(int index) {
        int originalValue = getListOfOffsets().get(index);
        if(originalValue >= 3) {
            getListOfOffsets().set(index, originalValue - 1);
        } else {
            getListOfOffsets().set(index, originalValue + 1);
        }
        return originalValue;
    }
}
