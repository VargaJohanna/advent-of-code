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
}
