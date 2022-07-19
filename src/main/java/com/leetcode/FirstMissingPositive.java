package com.leetcode;

/***
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0})); // 3
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1})); // 2
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12})); // 1
        System.out.println(firstMissingPositive(new int[]{1})); // 1
    }

    public static int firstMissingPositive(int[] nums) {
        boolean[] array = new boolean[nums.length];

        for (int i : nums) {
            if (i <= nums.length && i > 0) {
                array[i - 1] = true;
            }
        }

        for (int i = 0; i < array.length; i++) {
            boolean included = array[i];
            if (!included) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
