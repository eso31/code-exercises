package com.leetcode;

/***
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /***
     * n^2 / 2 => O(n^2)
     */
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int indexDiff = Math.abs(i - j);
                int minValue = Math.min(height[i], height[j]);

                int result = indexDiff * minValue;

                max = Math.max(result, max);
            }
        }

        return max;
    }

    public static int maxArea2(int[] height) {
        int max = 0;

        int pointer1 = 0;
        int pointer2 = height.length - 1;

        while (pointer1 < pointer2) {
            int indexDiff = Math.abs(pointer2 - pointer1);
            int minValue = Math.min(height[pointer1], height[pointer2]);

            int result = indexDiff * minValue;
            max = Math.max(result, max);

            if (height[pointer1] < height[pointer2]) {
                pointer1++;
            } else {
                pointer2--;
            }
        }

        return max;
    }
}
