package com.sorting;

import java.util.Arrays;

import static com.sorting.SortUtils.printArray;

/***
 * Complexity: O(n*logn)
 * Stable algorithm
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 7, 2, 8, 2, 7, 8932, 2, 7, 13, 167, 16}; // 2 2 2 4 7 7 7 8 13 16 167 8932
        mergeSort(array);
        printArray(array);

        int[] array1 = new int[]{4, 7, 2, 8, 2, 7, 8932, 2, 7, 13, 167, 16}; // 2 2 2 4 7 7 7 8 13 16 167 8932
        mergeSortInPlace(array1);
        printArray(array1);
    }

    public static int[] mergeSort(int[] array) {
        // Manejar la base, de un solo elemento -> ya esta ordenado
        // dividir el array a la mitad y mandar a llamar a merge sort
        // iteras por los 2 arrays, los comparas y vas poniendo el mas pequeño
        // cuando acabe uno, falta que pases el resto del otro array

        if (array.length < 2) {
            return array;
        }

        int midPoint = array.length / 2;

        int[] firstHalf = Arrays.copyOfRange(array, 0, midPoint);
        int[] secondHalf = Arrays.copyOfRange(array, midPoint, array.length);

        int[] firstSortedHalf = mergeSort(firstHalf);
        int[] secondSortedHalf = mergeSort(secondHalf);

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < firstSortedHalf.length && j < secondSortedHalf.length) {
            int element1 = firstSortedHalf[i];
            int element2 = secondSortedHalf[j];

            if (element1 < element2) {
                array[k] = element1;
                i++;
            } else {
                array[k] = element2;
                j++;
            }

            k++;
        }

        while (i < firstSortedHalf.length) {
            array[k] = firstSortedHalf[i];
            i++;
            k++;
        }

        while (j < secondSortedHalf.length) {
            array[k] = secondSortedHalf[j];
            j++;
            k++;
        }

        return array;
    }

    /*
     * In place
     * */
    public static void mergeSortInPlace(int[] array) {
        mergeSort(array, 0, array.length - 1, new int[array.length]);
    }

    private static void mergeSort(int[] array, int start, int end, int[] temp) {
        if (end == start) {
            return;
        }

        int midPoint = ((end - start) / 2) + start;
        mergeSort(array, start, midPoint, temp);
        mergeSort(array, midPoint + 1, end, temp);

        int i = start;
        int j = midPoint + 1;
        int k = start;

        while (i <= midPoint && j <= end) {
            int firstElement = array[i];
            int secondElement = array[j];

            if (firstElement < secondElement) {
                temp[k] = firstElement;
                i++;
                k++;
            } else {
                temp[k] = secondElement;
                j++;
                k++;
            }
        }

        while (i <= midPoint) {
            temp[k] = array[i];
            i++;
            k++;
        }

        while (j <= end) {
            temp[k] = array[j];
            j++;
            k++;
        }

        for (int l = start; l <= end; l++) {
            array[l] = temp[l];
        }

    }
}
