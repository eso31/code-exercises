package com.leetcode;

/**
 * https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1})); // 4
        System.out.println(rob(new int[]{2, 7, 9, 3, 1})); // 12
        System.out.println(rob(new int[]{2})); // 2


    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] memo = new int[nums.length];

        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        int max = Math.max(memo[0], memo[1]);

        for (int i = 2; i < nums.length; i++) {
            int option1 = memo[i - 1];
            int option2 = nums[i] + memo[i - 2];

            memo[i] = Math.max(option1, option2);
            max = Math.max(memo[i], max);
        }

        return max;
    }
}
