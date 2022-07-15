package com.leetcode;

/***
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumSorted {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(result[0] + " " + result[1]); // [1,2]

        result = twoSum(new int[]{2, 3, 4}, 6);
        System.out.println(result[0] + " " + result[1]); // [1,3]

        result = twoSum(new int[]{-1, 0}, -1);
        System.out.println(result[0] + " " + result[1]); // [1,2]
    }

    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int sum = nums[start] + nums[end];

            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return null;
    }
}
