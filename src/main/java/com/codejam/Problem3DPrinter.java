package com.codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem3DPrinter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCases; i++) {
            System.out.println("Test Case #" + i + ":");

            String[] printer1 = br.readLine().split(" ");
            String[] printer2 = br.readLine().split(" ");
            String[] printer3 = br.readLine().split(" ");

            List<Integer> minColorValues = new ArrayList();

            for (int color = 0; color < 4; color++) {
                List<Integer> colorCartridge = Arrays.asList(
                        Integer.parseInt(printer1[color]),
                        Integer.parseInt(printer2[color]),
                        Integer.parseInt(printer3[color]));
                minColorValues.add(Collections.min(colorCartridge));
            }

            List<Integer> combination = getCombination(minColorValues);

            if (combination.stream().reduce(0, Integer::sum) == 1000000) {
                String result = combination
                        .stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "));
                System.out.println(result);
            } else {
                System.out.println("IMPOSSIBLE");
            }
            System.out.println();
        }
    }

    private static List<Integer> getCombination(List<Integer> values) {
        List<Integer> result = new ArrayList<>();

        int left = 1000000;
        for (int value : values) {
            if (value <= left) {
                result.add(value);
                left -= value;
            } else {
                if (left > 0) {
                    result.add(left);
                    left -= value;
                } else {
                    result.add(0);
                }
            }
        }

        return result;
    }
}
