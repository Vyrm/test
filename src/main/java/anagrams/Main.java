package anagrams;

import anagrams.engine.AnagramChecker;
import anagrams.exceptions.IllegalSizeException;

public class Main {
    public static void main(String[] args) throws IllegalSizeException {
        AnagramChecker anagramChecker = new AnagramChecker();
        System.out.println(anagramChecker.check("abcdef", "bcdaef"));
        System.out.println(anagramChecker.check("abaacf", "abcacd"));
    }

}
