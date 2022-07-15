package com.cracking.coding.interview.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PermutationsWithDups {
    public static void main(String[] args) {
        int[] input = {1, 1, 2};
        System.out.println(permute(input));
    }

    private static List<List<Integer>> permute(int[] input) {
        List<Integer> numbers = Arrays.stream(input).boxed().collect(Collectors.toList());
        Set<List<Integer>> permutations = getPermutations(numbers, new HashMap<>());
        return new ArrayList<>(permutations);
    }

    private static Set<List<Integer>> getPermutations(List<Integer> numbers, Map<String, Set<List<Integer>>> memo) {
        String key = numbers.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (numbers.size() == 1) {
            Set<List<Integer>> permutations = new HashSet<>();
            permutations.add(new ArrayList<>(numbers));
            return permutations;
        }

        Set<List<Integer>> allPermutations = new HashSet<>();
        for (int index = 0; index < numbers.size(); index++) {
            int pick = numbers.remove(index);
            Set<List<Integer>> permutations = getPermutations(numbers, memo);
            numbers.add(index, pick);

            for (List<Integer> permutation : permutations) {
                List<Integer> p = new ArrayList<>(permutation);
                p.add(0, pick);
                allPermutations.add(p);
            }
        }

        memo.put(key, allPermutations);
        return allPermutations;
    }
}
