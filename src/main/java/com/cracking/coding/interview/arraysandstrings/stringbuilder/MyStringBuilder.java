package com.cracking.coding.interview.arraysandstrings.stringbuilder;

import java.util.Arrays;

public class MyStringBuilder {
    private char[] value;
    private int count;

    public MyStringBuilder(String s) {
        value = new char[s.length() * 2];
        count = 0;

        int strLength = s.length();

        for (int i = 0; i < strLength; i++) {
            value[count] = s.charAt(i);
            count++;
        }
    }

    public MyStringBuilder append(String s) {
        ensureCapacity(s);
        for (int i = 0; i < s.length(); i++) {
            value[count] = s.charAt(i);
            count++;
        }

        return this;
    }

    private void ensureCapacity(String s) {
        if (count + s.length() > value.length) {
            int newSize = (value.length + s.length()) * 2;
            value = Arrays.copyOf(value, newSize);
            System.out.println("El length actual del array es " + value.length);
        }
    }

    public String toString() {
        System.out.println("El length actual del array es " + value.length);
        return new String(value, 0, count);
    }
}
