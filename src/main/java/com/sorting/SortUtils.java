package com.sorting;

public class SortUtils {
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printHeapPretty(int[] array) {
        int size = array.length;
        int nodeToPrint = 0;
        int maxLvl = (int) (Math.log(size + 1) / Math.log(2));
        while (nodeToPrint < size) {
            int lvl = (int) (Math.log(nodeToPrint + 1) / Math.log(2));
            int diffLvls = maxLvl - lvl + 1;
            for (int i = 0; i < diffLvls; i++) {
                System.out.print("\t\t");
            }
            System.out.print(array[nodeToPrint]);

            if (((int) (Math.log(nodeToPrint + 2) / Math.log(2))) > lvl) {
                System.out.println();
            }

            nodeToPrint++;
        }
        System.out.println();
    }
}
