package com.cracking.coding.interview.bitmanipulation;

import static java.lang.Double.doubleToRawLongBits;

public class BinaryToString {
    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(doubleToRawLongBits(.75)));
    }
}
