package com.cracking.coding.interview.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Parens {
    public static void main(String[] args) {
        int input = 4;
        Set<String> result = getCombinations(input);
        System.out.println(result);
    }

    public static Set<String> getCombinations(int n) {
        Map<Integer, Set<String>> map = new HashMap<>();
        map.put(1, new HashSet<>(Collections.singletonList("()")));

        for (int i = 2; i <= n; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < i; j++) {
                stringBuilder.append("()");
            }
            Set<String> combinations = new HashSet<>();
            combinations.add(stringBuilder.toString());

            for (int level = i - 1; level > 0; level--) {
                int complement = i - level;
                Set<String> complementCombinations = map.get(complement);
                Set<String> newCombinations = buildCombinations(complementCombinations, level);
                combinations.addAll(newCombinations);
                Set<String> combinationsByConcatenation = getCombinationsByConcatenation(map, level, complement);
                combinations.addAll(combinationsByConcatenation);
            }
            map.put(i, combinations);
        }

        return map.get(n);
    }

    private static Set<String> getCombinationsByConcatenation(Map<Integer, Set<String>> map, int level, int complement) {
        Set<String> complementCombinations = map.get(complement);
        Set<String> levelCombinations = map.get(level);

        Set<String> combinations = new HashSet<>();

        for (String complementCombination : complementCombinations) {
            for (String levelCombination : levelCombinations) {
                combinations.add(complementCombination + levelCombination);
                combinations.add(levelCombination + complementCombination);
            }
        }

        return combinations;
    }

    private static Set<String> buildCombinations(Set<String> complementCombinations, int currentLevel) {
        Set<String> combinations = new HashSet<>();
        for (String complementCombination : complementCombinations) {
            for (int i = 0; i < currentLevel; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < currentLevel; j++) {
                    if (i == j) {
                        stringBuilder.append("(")
                                .append(complementCombination)
                                .append(")");
                    } else {
                        stringBuilder.append("()");
                    }
                }
                combinations.add(stringBuilder.toString());
            }
        }

        return combinations;
    }

    public static Set<String> getCombinationsTry2(int n) {
        Map<Integer, Set<String>> map = new HashMap<>();
        map.put(1, new HashSet<>(Collections.singletonList("()")));

        for (int i = 2; i <= n; i++) {
            Set<String> prevCombinations = map.get(i - 1);
            Set<String> newCombinations = new HashSet<>();
            for (String combination : prevCombinations) {
                newCombinations.add("()" + combination);
                newCombinations.add(combination + "()");
                newCombinations.add("(" + combination + ")");
            }

            map.put(i, newCombinations);
        }

        return map.get(n);
    }

    public static List<String> generateParens(int count) {
        char[] str = new char[count * 2];
        List<String> list = new ArrayList<>();

        addParen(list, count, count, str, 0);
        return list;
    }

    public static void addParen(List<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return;

        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';
            addParen(list, leftRem - 1, rightRem, str, index + 1);

            str[index] = ')';
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
}
