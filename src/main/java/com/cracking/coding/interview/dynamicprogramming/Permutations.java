package com.cracking.coding.interview.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        System.out.println(permute(input));
    }

    private static List<List<Integer>> permute(int[] input) {
        List<Integer> numbers = Arrays.stream(input).boxed().collect(Collectors.toList());
        return getPermutations(numbers);
    }

    private static List<List<Integer>> getPermutations(List<Integer> numbers) {
        if (numbers.size() == 1) {
            List<List<Integer>> permutations = new ArrayList<>();
            permutations.add(new ArrayList<>(numbers));
            return permutations;
        }

        List<List<Integer>> allPermutations = new ArrayList<>();
        for (int index = 0; index < numbers.size(); index++) {
            int pick = numbers.remove(index);
            List<List<Integer>> permutations = getPermutations(numbers);
            numbers.add(index, pick);

            for (List<Integer> permutation : permutations) {
                permutation.add(0, pick);
                allPermutations.add(permutation);
            }
        }

        return allPermutations;
    }
}
