package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        findPossibleSolutions(n, 0, result, new ArrayList<>());

        return result;
    }

    private static void findPossibleSolutions(int n, int row, List<List<String>> result, List<Integer> columnsOccupied) {
        if (row == n) {
            // All queens were already placed and are valid
            buildAnswer(n, columnsOccupied, result);
        } else {
            for (int column = 0; column < n; column++) {
                if (!columnsOccupied.contains(column)) {
                    if (isValid(n, row, column, columnsOccupied)) {
                        columnsOccupied.add(column);
                        findPossibleSolutions(n, row + 1, result, columnsOccupied);
                        columnsOccupied.remove(columnsOccupied.size() - 1);
                    }
                }
            }
        }
    }

    private static boolean isValid(int n, int row, int column, List<Integer> columnsOccupied) {
        int tmpRow = row - 1;
        int tmpColumn = column - 1;
        while (tmpRow >= 0 && tmpColumn >= 0) {
            for (int index = 0; index < columnsOccupied.size(); index++) {
                if (tmpRow == index && tmpColumn == columnsOccupied.get(index)) {
                    return false;
                }
            }
            tmpRow--;
            tmpColumn--;
        }

        tmpRow = row - 1;
        tmpColumn = column + 1;

        while (tmpRow >= 0 && tmpColumn < n) {
            for (int index = 0; index < columnsOccupied.size(); index++) {
                if (tmpRow == index && tmpColumn == columnsOccupied.get(index)) {
                    return false;
                }
            }
            tmpRow--;
            tmpColumn++;
        }

        return true;
    }

    private static void buildAnswer(int n, List<Integer> columnsOccupied, List<List<String>> result) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n - 1; i++) {
            sb.append(".");
        }
        String row = sb.toString();

        List<String> solution = new ArrayList<>();
        for (int column : columnsOccupied) {
            String rowWithQueen = row.substring(0, column) + "Q" + row.substring(column);
            solution.add(rowWithQueen);
        }

        result.add(solution);
    }
}
