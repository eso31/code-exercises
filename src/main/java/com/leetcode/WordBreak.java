package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * https://leetcode.com/problems/word-break/
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code"))); // true
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple","pen"))); // true
        System.out.println(wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); // false

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }

    private static boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> memo) {
        if(memo.containsKey(s)) {
            return memo.get(s);
        }

        if (s.isEmpty()) {
            return true;
        }

        for(String word : wordDict) {
            if(s.startsWith(word)) {
                String newWord = s.substring(word.length());
                boolean isWordFormed = wordBreak(newWord, wordDict, memo);
                memo.put(newWord, isWordFormed);
                if (isWordFormed) {
                    return true;
                }
            }
        }

        memo.put(s, false);
        return false;
    }
}
