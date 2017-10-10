package anagrams.engine;

import anagrams.exceptions.IllegalSizeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
    public String check(String firstString, String secondString) throws IllegalSizeException {
        String returnString;

        //checking length of strings
        if (firstString.length() != secondString.length() || firstString.length() == 0) {
            throw new IllegalSizeException();
        }

        //I used HashMap solution, because complexity of algorithms search, delete and put is O(1),
        //so it give fastest way to check Strings
        //Here I put chars from second string to know count of each letter.
        Map<Character, Integer> mapWithLetters = new HashMap<>();
        ArrayList<Character> lettersToEdit = new ArrayList<>();
        for (int i = 0; i < secondString.length(); i++) {
            char letter = secondString.charAt(i);
            if (!mapWithLetters.containsKey(letter)) {
                mapWithLetters.put(letter, 1);
            } else {
                Integer lettersCount = mapWithLetters.get(letter);
                mapWithLetters.put(letter, ++lettersCount);
            }
        }

        //Here I check existence of each letter from first string,
        //and put all letters that don't existence
        //or have value <0 or >0 in ArrayList
        for (int i = 0; i < firstString.length(); i++) {
            char letter = firstString.charAt(i);
            if (mapWithLetters.containsKey(letter)) {
                Integer lettersCount = mapWithLetters.get(letter);
                mapWithLetters.put(letter, --lettersCount);
            } else if (!mapWithLetters.containsKey(letter)) {
                lettersToEdit.add(letter);
            }
        }

        //Here I check ArrayList size, if it empty - Strings are anagrams
        //if not - show every letter that you need to change
        if (lettersToEdit.size() == 0) {
            returnString = "Strings are anagrams";
            return returnString;
        } else {
            returnString = lettersToEdit.toString();
            return returnString;
        }

        //Time complexity: O(n), where n - each operation with letters
    }
}
