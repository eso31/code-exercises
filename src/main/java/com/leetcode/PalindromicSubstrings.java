package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings2("abc")); // 3
        System.out.println(countSubstrings2("aaa")); // 6
        System.out.println(countSubstrings2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")); // 500500
    }

    /*
    * O(n^3)
    * */
    public static int countSubstrings(String s) {
        return countSubstring(s, new HashMap<>());
    }

    public static int countSubstring(String s, Map<String, Integer> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring)) {
                    counter++;
                }
            }
        }

        memo.put(s, counter);
        return counter;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(stack.pop());
        }

        return sb.toString().equals(s);
    }


    /*
     * O(n^2)
     * */
    public static int countSubstrings2(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd strings
            counter += countSubstrings2(s, i, i);

            // even strings
            int j = i + 1;
            if (j < s.length()) {
                counter += countSubstrings2(s, i, j);
            }
        }

        return counter;
    }

    public static int countSubstrings2(String s, int i, int j) {
        if (i < 0 || j >= s.length()) {
            return 0;
        }

        if (s.charAt(i) == s.charAt(j)) {
            return countSubstrings2(s, i - 1, j + 1) + 1;
        }

        return 0;
    }
}
