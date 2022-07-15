package com.leetcode;

import com.heap.HeapMax;

/***
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)); // 4
        System.out.println(findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 2)); // 6
        System.out.println(findKthLargest(new int[]{7, 6, 5, 4, 3, 2, 1}, 5)); // 3
    }

    public static int findKthLargest(int[] nums, int k) {
        HeapMax heapMax = new HeapMax();

        for (int num : nums) {
            heapMax.insert(num);
        }

        for (int i = 0; i < k - 1; i++) {
            heapMax.remove(0);
        }

        return heapMax.getMax();
    }
}
