package com.leetcode;

/***
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {
    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) { // target = 2
        int start = 0;
        int end = nums.length - 1; // 9

        int middlePoint = (end - start) / 2; //4.5 -> 4


//        while (nums[middlePoint] != target)
        // [1,2,3,4,5,6,7,8,9,10]
        int currentNumber = nums[middlePoint];

        while(currentNumber != target && start != end) {
            if (nums[middlePoint] == target) {
                return target;
            } else if (currentNumber > target) {
                end = middlePoint - 1;
            } else if (currentNumber < target) {
                start = middlePoint + 1;
            }
            middlePoint = (end - start) / 2;
            currentNumber = nums[middlePoint];
        }


        return -1;
    }
}
