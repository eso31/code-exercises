package com.leetcode;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * */
public class CharacterReplacement {
    public static void main(String[] args) {
        System.out.println(getMaxLength2("AABCCBB", 2)); // 5
        System.out.println(getMaxLength2("ABBCB", 1)); // 4
        System.out.println(getMaxLength2("ABCCDE", 1)); // 3
        System.out.println(getMaxLength2("ABBB", 2)); // 4
    }

    /*
     * O(s*s) I think
     *
     * */
    public static int getMaxLength(String s, int k) {
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            int maxFreq = 0;
            int sizeFreq = 0;
            int j = i;
            int maxFoundInWindow = 0;
            int[] freqMap = new int[26];
            boolean keepGoing = true;

            if (max > s.length() - i) {
                break;
            }

            while (keepGoing && j < s.length()) {
                char letter = s.charAt(j);
                int letterIndex = letter - (int) 'A';
                freqMap[letterIndex]++;
                sizeFreq++;

                if (freqMap[letterIndex] > maxFreq) {
                    maxFreq = freqMap[letterIndex];
                }

                if (sizeFreq - maxFreq > k) {
                    keepGoing = false;
                } else {
                    maxFoundInWindow++;
                }

                j++;
            }

            if (maxFoundInWindow > max)
                max = maxFoundInWindow;
        }

        return max;
    }

    /*
     * Sliding window, O(n)
     * */
    public static int getMaxLength2(String s, int k) {

        int max = 0;
        int freqSize = 0;
        int freqMax = 0;

        int windowStart = 0;
        int[] freqMap = new int[26];
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char letter = s.charAt(windowEnd);
            int letterIndex = letter - (int) 'A';
            freqMap[letterIndex]++;
            freqSize++;
            freqMax = Math.max(freqMax, freqMap[letterIndex]);

            while (freqSize - freqMax > k) {
                freqSize--;

                // remove from map
                char letterToRemove = s.charAt(windowStart);
                int letterIndexToRemove = letterToRemove - (int) 'A';
                freqMap[letterIndexToRemove]--;
                freqMax = getMaxFrequent(freqMap);

                // prepare for next iteration
                windowStart++;
            }

            max = Math.max(max, freqSize);
        }
        return max;
    }

    private static int getMaxFrequent(int[] freqMap) {
        return Collections.max(IntStream.of(freqMap).boxed().collect(Collectors.toList()));
    }
}
