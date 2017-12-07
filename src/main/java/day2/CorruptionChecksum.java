package day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Johanna on 05/12/2017.
 */
public class CorruptionChecksum {
    public int countChecksum(String input) {
        int diff;
        int sumOfDiffs = 0;

        for(String line : input.split("\\n")){
            TreeSet<Integer> setOfNums = new TreeSet<Integer>();
            for(String num : line.split("\\t")){
                Integer number = Integer.valueOf(num);
                setOfNums.add(number);
            }

            diff = setOfNums.last() - setOfNums.first();
            sumOfDiffs += diff;
        }
        return sumOfDiffs;
    }

    public int findEvenlyDivisibleValues(String input) {
        int division = 0;
        int sumOfDivisions = 0;

        for(String line : input.split("\\n")){
            ArrayList<Integer> listOfNums = new ArrayList<Integer>();
            for(String num : line.split("\\t")){
                Integer number = Integer.valueOf(num);
                listOfNums.add(number);
            }
            for(int i = 0; i < listOfNums.size(); i++) {
                for(int j = i + 1; j < listOfNums.size(); j++) {
                    if(listOfNums.get(i) / listOfNums.get(j) < 1) {
                        if(listOfNums.get(j) % listOfNums.get(i) == 0) {
                            division = listOfNums.get(j) / listOfNums.get(i);
                        }
                    } else {
                        if(listOfNums.get(i) % listOfNums.get(j) == 0) {
                            division = listOfNums.get(i) / listOfNums.get(j);
                        }
                    }
                }
            }
            sumOfDivisions += division;
        }
        return sumOfDivisions;
    }
}
