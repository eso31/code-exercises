package com.cracking.coding.interview.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7)); // 28
        System.out.println(uniquePaths(20, 10)); // 6906900
        System.out.println(uniquePaths(20, 12)); // 54627300
        System.out.println(uniquePaths(20, 15)); // 818809200
    }

    public static int uniquePaths(int m, int n) {
        return uniquePaths(m, n, new HashMap<>());
    }

    private static int uniquePaths(int m, int n, Map<String, Integer> memo) {
        String key = m + "," + n;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (m < 1 || n < 1) {
            return 0;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        int uniquePaths = uniquePaths(m - 1, n, memo) + uniquePaths(m, n - 1, memo);
        memo.put(key, uniquePaths);

        return uniquePaths;
    }
}
