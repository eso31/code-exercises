package com.cracking.coding.interview.bitmanipulation;

import static java.lang.Integer.toBinaryString;

public class PairwiseSwap {
    public static void main(String[] args) {
        int number = 165;
        System.out.println(String.format("N = %o (%s)", number, toBinaryString(number)));

        System.out.println(Integer.toBinaryString(swapBits(number)));
    }

    public static int swapBits(int n) {

        int mask1010 = 0xaaaaaaaa;
        int mask0101 = mask1010 >> 1;


        int even = (n & mask0101) << 1;
        System.out.println(toBinaryString(even));
        int odd = (n & mask1010) >> 1;
        System.out.println(toBinaryString(odd));

        return even | odd;
    }
}
