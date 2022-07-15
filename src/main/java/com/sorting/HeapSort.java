package com.sorting;

import com.heap.HeapMin;

import static com.sorting.SortUtils.printArray;
import static com.sorting.SortUtils.printHeapPretty;

/***
 * Complexity: O(n*logn)
 * NOT stable algorithm
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] array = new int[]{4, 7, 2, 8, 2, 7, 8932, 2, 7, 13, 167, 16}; // 2 2 2 4 7 7 7 8 13 16 167 8932
//        heapSort(array);
//        printArray(array);

        // Sort in place in ascending order
        int[] array = new int[]{4, 7, 2, 8, 2, 7, 8932, 2, 7, 13, 167, 16}; // 2 2 2 4 7 7 7 8 13 16 167 8932
        buildMaxHeap(array);
        maxHeapifyAndReduceHeap(array);
        printArray(array);

        // Sort in place in descending order
        int[] array1 = new int[]{4, 7, 2, 8, 2, 7, 8932, 2, 7, 13, 167, 16}; // 2 2 2 4 7 7 7 8 13 16 167 8932
        buildMinHeap(array1);
        minHeapifyAndReduceHeap(array1);
        printArray(array1);
    }

    /***
     * Heap sort using space O(n)
     */
    public static void heapSort(int[] array) {
        HeapMin heapMin = new HeapMin();

        for (int num : array) {
            heapMin.insert(num);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = heapMin.getMin();
            heapMin.removeMin();
        }
    }

    /***
     * Build a max heap from array in place
     */
    private static void buildMaxHeap(int[] array) {
        int size = array.length;
        int lastNonLeafNode = (size / 2) - 1;

        for (int i = lastNonLeafNode; i >= 0; i--) {
            maxHeapify(array, size, i);
        }
    }

    private static void maxHeapify(int[] array, int size, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && array[l] > array[largest]) {
            largest = l;
        }

        if (r < size && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(array, largest, i);
            maxHeapify(array, size, largest);
        }
    }

    private static void maxHeapifyAndReduceHeap(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            maxHeapify(array, i, 0);
        }
    }

    /***
     * Build a min heap from array in place
     */
    public static void buildMinHeap(int[] array) {
        int size = array.length;
        int lastNodeNonLeaf = (size / 2) - 1;

        for (int i = lastNodeNonLeaf; i >= 0; i--) {
            minHeapify(array, size, i);
        }
    }

    private static void minHeapifyAndReduceHeap(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            minHeapify(array, i, 0);
        }
    }

    private static void minHeapify(int[] array, int size, int i) {
        int smallest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < size && array[l] < array[smallest]) {
            smallest = l;
        }

        if (r < size && array[r] < array[smallest]) {
            smallest = r;
        }

        if (smallest != i) {
            swap(array, i, smallest);
            minHeapify(array, size, smallest);
        }
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
}
