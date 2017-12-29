package day4;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Johanna on 29/12/2017.
 */
public class Passphrases {
    public int countValidPassphrases (String input) {
        int numOfValidPhrase = 0;
        for (String phraseLine : input.split("\\n")) {
            int repeatedWords = 0;
            ArrayList<String> listOfPhrases = new ArrayList<>();
            Collections.addAll(listOfPhrases, phraseLine.split(" "));

            for(int i = 0; i < listOfPhrases.size(); i++) {
                for(int j = i + 1; j < listOfPhrases.size(); j++ ) {
                    if(listOfPhrases.get(i).equals(listOfPhrases.get(j))) {
                        repeatedWords++;
                    }
                }
            }

            if(repeatedWords == 0) {
                numOfValidPhrase++;
            }
            System.out.println(numOfValidPhrase);
        }
        return numOfValidPhrase;
    }
}
