package com.leetcode;

/**
 * TODO: Finish the problem
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
//        int[] test = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(lengthOfLIS(test));
        int[] test2 = new int[]{0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS(test2));
    }

    public static int lengthOfLIS(int[] nums) {
        // iterar todo
        // si hay uno menor (pedimos recursivamente empezando de ese indice)
        // si es mayor (hacemos 2 posibilidades, lo incluimos o no lo incluimos)
        return lengthOfLIS(nums, 0, 0, Integer.MIN_VALUE);
    }

    public static int lengthOfLIS(int[] nums, int startingIndex, int max, int lastIncluded) {
        //base case: out of bounds
        if (startingIndex == nums.length - 1) {
            if (nums[startingIndex] > lastIncluded) {
                return max + 1;
            } else {
                return max;
            }
        }

        int current = nums[startingIndex];

        if (current > lastIncluded) {
            int maxExcludingCurrent = lengthOfLIS(nums, startingIndex + 1, max, lastIncluded); // Contemplar que NO se incluye el número
            int maxIncludingCurrent = lengthOfLIS(nums, startingIndex + 1, max + 1, current); // Contemplar que SI se incluye el número
            int greatestScenario = Math.max(maxExcludingCurrent, maxIncludingCurrent);

            max = Math.max(max, greatestScenario);
        } else {
            int maxExcludingCurrent = lengthOfLIS(nums, startingIndex + 1, max, lastIncluded); // Contemplar que NO se incluye el número
            max = Math.max(max, maxExcludingCurrent);
        }


        return max;
    }
}
