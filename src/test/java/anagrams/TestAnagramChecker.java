package anagrams;

import anagrams.engine.AnagramChecker;
import anagrams.exceptions.IllegalSizeException;
import org.junit.Assert;
import org.junit.Test;


public class TestAnagramChecker {

    @Test
    public void checkStrings() throws IllegalSizeException {
        AnagramChecker anagramChecker = new AnagramChecker();
        String test1 = anagramChecker.check("abcdef", "bcdaef");
        String test2 = anagramChecker.check("abcdef", "abcdef");

        Assert.assertEquals("Strings are anagrams", test1);
        Assert.assertEquals("Strings are anagrams", test2);
    }
}
