package day4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Johanna on 29/12/2017.
 */
public class Passphrases {
    public int countValidPassphrases (String input) {
        int numOfValidPhrase = 0;
        for (String phraseLine : input.split("\\n")) {
            ArrayList<String> listOfWords = new ArrayList<>();
            Collections.addAll(listOfWords, phraseLine.split(" "));

            if(countRepeatedWords(listOfWords) == 0) {
                numOfValidPhrase++;
            }
        }
        return numOfValidPhrase;
    }

    public int countValidPassphrasesNoAnagrams(String input) {
        int numOfValidPhrase = 0;
        for (String phraseLine : input.split("\\n")) {
            ArrayList<String> listOfWords = new ArrayList<>();
            ArrayList<String> sortedListOfWords = new ArrayList<>();
            Collections.addAll(listOfWords, phraseLine.split(" "));

            for (String listOfWord : listOfWords) {
                List<Character> listOfChars = createListOfChars(listOfWord);
                Collections.sort(listOfChars);
                sortedListOfWords.add(createStringOfCharList(listOfChars));
            }

            if(countRepeatedWords(sortedListOfWords) == 0) {
                numOfValidPhrase++;
            }
        }
        return numOfValidPhrase;
    }

    public List<Character> createListOfChars(String string) {
        List<Character> listOfChars = new ArrayList<>();
        for(int i = 0; i < string.length(); i++) {
            listOfChars.add(string.charAt(i));
        }
        return listOfChars;
    }

    public String createStringOfCharList(List<Character> listOfChars) {
        StringBuilder newString = new StringBuilder();
        for(char character : listOfChars) {
            newString.append(character);
        }
        return newString.toString();
    }

    public int countRepeatedWords(ArrayList<String> listOfWords) {
        int repeatedWords = 0;
        for(int i = 0; i < listOfWords.size(); i++) {
            for(int j = i + 1; j < listOfWords.size(); j++ ) {
                if(listOfWords.get(i).equals(listOfWords.get(j))) {
                    repeatedWords++;
                }
            }
        }
        return repeatedWords;
    }
}
