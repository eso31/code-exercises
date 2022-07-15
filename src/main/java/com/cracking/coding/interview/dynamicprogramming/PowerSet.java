package com.cracking.coding.interview.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * 8.4 Power Set: Write a method to return all subsets of a set.
 * */
public class PowerSet {
    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3};
        System.out.println(subsets(test1));
    }

    public static Set<List<Integer>> getAllSubsets(List<Integer> numbers, Map<List<Integer>, Set<List<Integer>>> memo) {
        if (memo.containsKey(numbers)) {
            return memo.get(numbers);
        }
        Set<List<Integer>> subsets = new HashSet<>();
        subsets.add(numbers);

        if (numbers.size() == 0) {
            return subsets;
        }

        List<Integer> subset1 = numbers.subList(1, numbers.size());
        List<Integer> subset2 = numbers.subList(0, numbers.size() - 1);

        subsets.addAll(getAllSubsets(subset1, memo));
        subsets.addAll(getAllSubsets(subset2, memo));

        memo.put(numbers, subsets);
        return subsets;
    }

    /*
     * Only contiguous subsets
     * */
    public static List<List<Integer>> subsetsContiguous(int[] nums) {
        List<Integer> numbers = IntStream.of(nums).boxed().collect(Collectors.toList());
        return new ArrayList<>(getAllSubsets(numbers, new HashMap<>()));
    }

    /*
    * All subsets
    * */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : subsets) {
                List<Integer> newSubset = new ArrayList<>(subset);
                subset.add(nums[i]);
                newSubsets.add(newSubset);
            }
            subsets.addAll(newSubsets);
        }

        return subsets;
    }

}
