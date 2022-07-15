package com.cracking.coding.interview.bitmanipulation;

import java.util.stream.IntStream;

import static java.lang.Integer.toBinaryString;

public class Debugger {
    public static void main(String[] args) {
        IntStream.range(-10000, 10000).forEach(i -> {
            String nBits = toBinaryString(i);
            String nMinusOneBits = toBinaryString(i - 1);
            boolean result = whatDoesThisDo(i);
            if (result) {
                System.out.printf("%s : (%s) (%s)%n", i, nBits, nMinusOneBits);
            }

        });
    }

    public static boolean whatDoesThisDo(int n) {
        return (n & (n - 1)) == 0;
    }
}
