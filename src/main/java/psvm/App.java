package psvm;

import java.lang.annotation.Documented;
import java.util.Arrays;

/**
 * Created by vkostylev on 25/07/2017.
 */
public class App {

    public static void main(String[] args) {

        System.out.println(fib(3));


    }

    /**  CCI 1.1
     Implement an algorithm to determine if a string has all unique characters.
     What if you can not use additional data structures?

     Solution below assume that charset is ASCII
     **/
    public static boolean allUniqueChars(String str) {
        if (str == null || str.length() == 0) return false;
        if (str.length() == 1) return true;

        boolean[] match = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (match[val] == true) return false;
            match[val] = true;
        }
        return true;
    }

    /**  CCI 1.2
     Write code to reverse a C-Style String.
     (C-String means that “abcd” is represented as
     five characters, including the null character.)
     **/
    public static String revString(String s) {
        if (s == null) return null;
        if (s.length() <= 1) return s;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length-i-1];
            chars[chars.length-i-1] = tmp;
        }

        return new String(chars);
    }

    /** CCI 1.3
     Design an algorithm and write code to remove the duplicate characters
     in a string without using any additional bu er.
     NOTE: One or two additional variables are ok.
     An extra copy of the array is not.
     **/
    public static String rmDuplicateChars(String str) {
        if (str == null) return null;
        if (str.length() <= 1) return str;

        char[] s = str.toCharArray();
        int len = s.length;
        int tail = 1; //tail of already found characters part of the string


        for (int i = 1; i < len; ++i) { //loop through all characters
            int j;
            for (j = 0; j < tail; ++j) {  //compare current character with
                // all found characters
                if (s[i] == s[j]) break; // if it was already found - skip it
            }
            if (j == tail) { //if we are hear, this char wasn't found previously
                // so we add it to the appropriate part of the string
                // and adjust tail accordingly
                s[tail] = s[i];
                ++tail;
            }


        }
        return new String(Arrays.copyOf(s, tail));
    }


    /**
     * CCI 1.4
     *
     * Write a method to decide if two strings are anagrams or not.
     *
     * @param a
     * @param b
     * @return
     */

    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() == 0 || b.length() == 0) return false;
        if (a.length() != b.length()) return false;

        int[] chars = new int[256];
        int numUniqueChars = 0;
        int uniqueCharsInB = 0;

        char[] compChars = a.toCharArray();

        for (char c : compChars) {

            if (chars[c] == 0) {
                numUniqueChars++;
            }
            chars[c]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int t = b.charAt(i);

            if (chars[t] == 0) {
                return false;
            }

            chars[t]--;

            if (chars[t] == 0) {
                uniqueCharsInB++;

                if (numUniqueChars == uniqueCharsInB) {
                    return (i == b.length()-1);
                }

            }

        }

        return false;
    }

    /**
     * CCI 1.5 Write a method to replace all spaces in a string with ‘%20’.
     */

    public static String replaceCharWithString(String str, char c, String replacement) {

        int numOfCharsToReplace = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) numOfCharsToReplace++;
        }

        char[] repl = replacement.toCharArray();
        int resize = str.length() - numOfCharsToReplace + (numOfCharsToReplace*repl.length);

        char[] result = new char[resize];

        for (int i = 0, j = 0; i < str.length(); i++, j++) {
            char curChar = str.charAt(i);
            if (curChar == c) {
                for (int k = 0; k < repl.length; k++) {
                    result[j] = repl[k];
                    if (k + 1 < repl.length) j++;
                }
            } else {
                result[j] = curChar;
            }

        }

        return new String(result);
    }

    /**
     * FizzBuzz
     */

    public static String fizzBuzz(int n) {
        if (n == 0) return null;

        StringBuilder sb = new StringBuilder();

        if (n % 3 == 0) sb.append("fizz");
        if (n % 5 == 0) sb.append("buzz");
        if (sb.length() == 0) sb.append(n);

        return sb.toString();

    }

    /**
     * int -> phone
     */

    public static String createPhoneNumber(int[] numbers) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case 0:
                    sb.append("(");
                    sb.append(numbers[i]);
                    break;
                case 2:
                    sb.append(numbers[i]);
                    sb.append(") ");
                    break;
                case 5:
                    sb.append(numbers[i]);
                    sb.append("-");
                    break;
                default:
                    sb.append(numbers[i]);
                    break;
            }
        }
        return sb.toString();

    }

    public static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int prev = 0;
        int fib = 1;
        int i = 1;
        while (i < n) {
            int tmp = fib;
            fib += prev;
            prev = tmp;
            i++;
        }

        return fib;
    }



}

