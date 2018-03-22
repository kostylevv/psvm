package psvm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by vkostylev on 25/07/2017.
 */
public class AppTest {

    @Test
    public void allUniqueChars() throws Exception {
        assertTrue(App.allUniqueChars("abcdefg"));
        assertFalse(App.allUniqueChars("abcc"));
        assertFalse(App.allUniqueChars("abbc"));
        assertFalse(App.allUniqueChars("aabc"));
        assertFalse(App.allUniqueChars(null));
        assertFalse(App.allUniqueChars(""));
        assertTrue(App.allUniqueChars("a"));
    }

    @Test
    public void reverseString() throws Exception {
        assertEquals("a", App.revString("a"));
        assertEquals(null, App.revString(null));
        assertEquals("", App.revString(""));
        assertEquals("edcba", App.revString("abcde"));
        assertEquals("dcba", App.revString("abcd"));
    }

    @Test
    public void removeDuplicates() throws Exception {
        assertEquals("abcdfg", App.rmDuplicateChars("abccdbfg"));
        assertEquals(null, App.rmDuplicateChars(null));
        assertEquals("a", App.rmDuplicateChars("a"));
        assertEquals("a", App.rmDuplicateChars("aaaaaaaaaaaaaaaaaa"));
        assertEquals("ac", App.rmDuplicateChars("aaaaaaaaaaaaaaaaaac"));
        assertEquals("ca", App.rmDuplicateChars("caaaaaaaaaaaaaaaaa"));
        assertEquals("ca", App.rmDuplicateChars("caaaaaaaaaaaaaaaaac"));
        assertEquals("ab", App.rmDuplicateChars("aaaaaaaaabaaaaaaaa"));
    }

    @Test
    public void anagram() throws Exception {
        assertFalse(App.isAnagram("",""));
        assertTrue(App.isAnagram("abch","hacb"));
        assertFalse(App.isAnagram("abcc","abcd"));
        assertFalse(App.isAnagram(null,null));
        assertFalse(App.isAnagram("abchf","hacb"));
        assertTrue(App.isAnagram("f","f"));
        assertFalse(App.isAnagram("g","b"));
    }

    @Test
    public void replaceCharWithString() throws Exception {
        assertEquals("ab!UNDERSCORE!cd!UNDERSCORE!g",
                App.replaceCharWithString("ab_cd_g",'_',"!UNDERSCORE!"));

    }

    @Test
    public void fizzBuzz() throws Exception {
        assertEquals("fizz", App.fizzBuzz(3));
        assertEquals("buzz", App.fizzBuzz(5));
        assertEquals("fizz", App.fizzBuzz(6));
        assertEquals("buzz", App.fizzBuzz(10));
        assertEquals("fizz", App.fizzBuzz(33));
        assertEquals("buzz", App.fizzBuzz(25));
        assertEquals("fizzbuzz", App.fizzBuzz(15));
        assertEquals("fizzbuzz", App.fizzBuzz(45));
        assertEquals(null, App.fizzBuzz(0));
        assertEquals("1", App.fizzBuzz(1));
    }

    @Test
    public void intToPhone() {
        assertEquals("(123) 456-7890", App.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }

    @Test
    public void fib() throws Exception {
        assertEquals(0, App.fib(0));
        assertEquals(1, App.fib(1));
        assertEquals(1, App.fib(2));
        assertEquals(2, App.fib(3));
        assertEquals(3, App.fib(4));
        assertEquals(5, App.fib(5));
        assertEquals(8, App.fib(6));
        assertEquals(13, App.fib(7));

    }


}