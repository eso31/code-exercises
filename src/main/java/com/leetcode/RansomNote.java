package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/ransom-note/
* */
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(ransomNote("a","b")); // false
        System.out.println(ransomNote("aa","aab")); // true
        System.out.println(ransomNote("aa","ab")); // false
    }

    public static boolean ransomNote(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();

        for (char letter : ransomNote.toCharArray()) {
            if (ransomNoteMap.containsKey(letter)) {
                Integer counter = ransomNoteMap.get(letter);
                ransomNoteMap.put(letter, counter+1);
            } else {
                ransomNoteMap.put(letter, 1);
            }
        }

        for (char letter : magazine.toCharArray()) {
            if (magazineMap.containsKey(letter)) {
                Integer counter = magazineMap.get(letter);
                magazineMap.put(letter, counter+1);
            } else {
                magazineMap.put(letter, 1);
            }
        }


        // check ransomnote letters exist in magazine, and also have less or equal than
        for (Map.Entry<Character, Integer> entry : ransomNoteMap.entrySet()) {
            if (!magazineMap.containsKey(entry.getKey()) || magazineMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }

        return true;
    }
}
