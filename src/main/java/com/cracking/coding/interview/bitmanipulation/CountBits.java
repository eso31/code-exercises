package com.cracking.coding.interview.bitmanipulation;

import static java.lang.Integer.toBinaryString;

public class CountBits {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(toBinaryString(n));
        System.out.println(countBits(n));
    }

    public static int countBits(int input) {
        int counter = 0;
        for (int i=0; i<32; i++) {
            int mask = 1 << i;
            int bit = mask & input;
            if (bit != 0) {
                counter++;
            }
        }
        return counter;
    }
}
