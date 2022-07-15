package com.intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        Set<Integer> list1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        Set<Integer> list2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        list1.removeAll(list2);

        System.out.println(list1);
    }
}
