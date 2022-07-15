package com.cracking.coding.interview.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripleStep {
    public static void main(String[] args) {
        List<Integer> steps = Arrays.asList(1, 2, 3);
        int n = 75;
        System.out.println(countPossibleWays(n, steps));
        System.out.println(countPossibleWaysIteratively(n, steps));
    }

    /*
     * Recursion + memoization
     * */
    public static int countPossibleWays(int n, List<Integer> steps) {
        return countPossibleWays(n, steps, new HashMap<>());
    }

    private static int countPossibleWays(int n, List<Integer> steps, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0) return 1;
        if (n < 1) return 0;

        int counter = 0;

        for (int step : steps) {
            counter += countPossibleWays(n - step, steps, memo);
        }

        memo.put(n, counter);
        return counter;
    }

    /*
     * Iterative
     * */
    public static int countPossibleWaysIteratively(int n, List<Integer> steps) {
        int[] table = new int[n + 1];
        table[0] = 1;

        for (int i = 0; i <= n; i++) {
            if (table[i] == 0) {
                continue;
            }

            for (int step : steps) {
                int index = i + step;
                if (index <= n) {
                    table[index] += table[i];
                }
            }
        }

        return table[n];
    }

}
