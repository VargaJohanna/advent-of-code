package day6;

import java.util.ArrayList;

/**
 * Created by johannavarga on 15/01/2018.
 */
public class MemoryReallocation {

    public int reallocation(String input) {
        ArrayList<Integer> banks = new ArrayList<>();

        for(String num : input.split("\\t")) {
            banks.add(Integer.parseInt(num));
        }

        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        array.add(banks);
        boolean equals = false;
        int counter = 0;

        while(!equals) {
            banks = redistribute(banks);
            array.add(banks);
            counter++;
            for(int j = 2; j <= array.size(); j++){
                equals = array.get(array.size() - 1).equals(array.get(array.size() - j));
                if(equals) {
                    break;
                }
            }
        }
        return counter;
    }

    public ArrayList<Integer> redistribute(ArrayList<Integer> list) {
        ArrayList<Integer> redistributedList = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            redistributedList.add(list.get(i));
        }
        int max = getMax(redistributedList);
        int indexOfMax = redistributedList.indexOf(max);

        int originalMax = max;
        while(max > 0) {
            for(int i : listOfIndexesForDistribution(indexOfMax, redistributedList)) {
                redistributedList.set(i, redistributedList.get(i) + 1);
                max--;
                if(max == 0) {
                    break;
                }
            }
        }
        redistributedList.set(indexOfMax, redistributedList.get(indexOfMax) - originalMax);
        return redistributedList;
    }

    public ArrayList<Integer> listOfIndexesForDistribution(int maxIndex, ArrayList<Integer> list) {
        ArrayList<Integer> indexList = new ArrayList<>();
        int startIndex = maxIndex;

        while(maxIndex + 1 < list.size()) {
            indexList.add(maxIndex + 1);
            maxIndex++;
        }

        for(int i = 0; i <= startIndex; i++) {
            indexList.add(i);
        }
        return indexList;
    }

    public int getMax(ArrayList<Integer> list) {
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}
