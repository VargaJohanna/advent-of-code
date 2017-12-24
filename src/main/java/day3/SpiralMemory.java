package day3;

import java.util.TreeSet;

/**
 * Created by Johanna on 07/12/2017.
 */
public class SpiralMemory {
    // 37 36 35 34 33 32 31
    // 38 17 16 15 14 13 30
    // 39 18  5  4  3 12 29
    // 40 19  6  1  2 11 28
    // 41 20  7  8  9 10 27
    // 42 21 22 23 24 25 26
    // 43 44 45 46 47 47 49 ...
    //
    // First square is 1
    // Second square is: 9, 2, 3, 4, 5, 6, 7, 8
    //
    // axisRight: 2, 22, 28, ...
    // axisUp: 4, 15, 34, ...
    // axisLeft: 6, 19, 40, ...
    // axisDown: 8, 23, 46, ...

    public int findDistance(int input) {
        // First step: Find out in which square the input is
        int numOfSquare;
        int multiplyEightBy = 0;
        if((int)Math.sqrt(input) % 2 == 0) {
            numOfSquare = (int)Math.sqrt(input) + 1;
        } else {
            numOfSquare = (int)Math.sqrt(input) + 2;
        }
        numOfSquare = numOfSquare / 2;

        // Step 2: Find out the numbers of the axis in the given square
        // Note: The axis are made up of numbers where the difference between the neighbours is a fixed number +
        // 8 multiplied by the number of square - 1
        for(int i = numOfSquare - 1; i > 0; i--) {
            multiplyEightBy += i;
        }
        System.out.println("multiplyEightBy " + multiplyEightBy);
        int axisRight = 1 + numOfSquare * 1 + multiplyEightBy * 8;
        int axisUp = 1 + numOfSquare * 3 + multiplyEightBy * 8;
        int axisLeft = 1 + numOfSquare * 5 + multiplyEightBy * 8;
        int axisDown = 1 + numOfSquare * 7 + multiplyEightBy * 8;

        // Step 3: Find the difference of the axis and the input number.
        // The smallest one will be the number of steps to get to the axis.
        TreeSet<Integer> setOfDistancesFromAxis = new TreeSet<Integer>();
        setOfDistancesFromAxis.add(Math.abs(input - axisRight));
        setOfDistancesFromAxis.add(Math.abs(input - axisUp));
        setOfDistancesFromAxis.add(Math.abs(input - axisLeft));
        setOfDistancesFromAxis.add(Math.abs(input - axisDown));

        // The number of steps to the middle is simply the number of square where the input is.
        return setOfDistancesFromAxis.first() + numOfSquare;
    }
}
