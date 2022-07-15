package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] test = {2, 7, 11, 15};
        int[] result = twoSumDiff(test, 9);
        System.out.println(result[0] + " " + result[1]); // [0,1]

        result = twoSumDiff(new int[]{3, 2, 4}, 6);
        System.out.println(result[0] + " " + result[1]); // [1,2]

        result = twoSumDiff(new int[]{3, 3}, 6);
        System.out.println(result[0] + " " + result[1]); // [0,1]
    }

    // O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int sum = nums[i] + nums[j];
                    if (sum == target)
                        return new int[]{i, j};
                }
            }
        }

        return null;
    }


    // O(n)
    public static int[] twoSumDiff(int[] nums, int target) {
        Map<Integer, Integer> diffMap= new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (diffMap.containsKey(diff)) {
                return new int[]{diffMap.get(diff), i};
            }

            diffMap.put(nums[i], i);
        }

        return null;
    }
}
