package com.sorting;

import static com.sorting.SortUtils.printArray;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 2, 8, 2, 7, 8932, 2, 7, 13, 167, 16}; // 2 2 2 4 7 7 7 8 13 16 167 8932
        quickSort(array, 0, array.length - 1);
        printArray(array);

        int[] array1 = new int[]{6, 3, 10, 1, 11, 8}; // 1 3 6 8 10 11
        quickSort(array1, 0, array1.length - 1);
        printArray(array1);

        int[] array2 = new int[]{2, 2, 2}; // 2 2 2
        quickSort(array2, 0, array2.length - 1);
        printArray(array2);

        int[] array3 = new int[]{3,3,3,3}; // 3 3 3 3
        quickSort(array3, 0, array3.length - 1);
        printArray(array3);
    }

    public static void quickSort(int[] array, int start, int end) {
        // manejar caso base = cuando start y end son iguales
        // seleccionar un pivote en start
        // buscar con left elemento mas grande que pivote
        // buscar con right elemento mas pequeño que pivote
        // si left < right, hacemos swap
        // al final cambiar pivote con right
        // llamar recursivamente los 2 lados del sorted item

        if (start < end) {
            int p = partition(array, start, end);
//            System.out.println("Partition on index: " + p);
//            System.out.println("Partition 1:");
//            printPartition(array, start, p);
//            System.out.println("Partition 2:");
//            printPartition(array, p + 1, end);

            quickSort(array, start, p);
            quickSort(array, p + 1, end);
        }
//        System.out.println("--------------");
    }

    private static void printPartition(int[] array, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static int partition(int[] array, int start, int end) {
        int left = start;
        int right = end + 1;

        int pivot = array[start];

        while (left < right) {
            do {
                left++;
            }
            while (left <= end && array[left] <= pivot);

            do {
                right--;
            }
            while (right > start && array[right] >= pivot);

            if (left < right) {
                swap(array, left, right);
            }
        }
        swap(array, start, right);

        return right;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
