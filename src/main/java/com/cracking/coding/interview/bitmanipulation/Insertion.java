package com.cracking.coding.interview.bitmanipulation;

import static java.lang.Integer.toBinaryString;

public class Insertion {
    public static void main(String[] args) {
        int n = 1024;
        int m = 19;
        System.out.println("N = " + toBinaryString(n));
        System.out.println("M = " + toBinaryString(m));
        System.out.println("------------------------");

        insertion(n, m, 2, 6);
    }

    public static int insertion(int n, int m, int i, int j) {
        int clearMSBj = (1 << (j + 1)) - 1;
//        System.out.println(toBinaryString(clearMSBj));

        int cleari0 = -1 << i;
//        System.out.println(toBinaryString(cleari0));

        int mask = ~(clearMSBj & cleari0);
        System.out.println("Mask => " + toBinaryString(mask));

        int mWithBitsCleared = (mask & n);
        System.out.println("M with bits cleared => " + toBinaryString(mWithBitsCleared));

        int toInsert = m << i;
        System.out.println("Thing to insert => " + toBinaryString(toInsert));

        int result = mWithBitsCleared | toInsert;
        System.out.println("Result: " + toBinaryString(result));
        return result;
    }
}
