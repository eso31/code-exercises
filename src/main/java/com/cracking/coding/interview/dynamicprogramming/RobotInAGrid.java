package com.cracking.coding.interview.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RobotInAGrid {
    public static void main(String[] args) {
        boolean[][] grid = new boolean[][]{
                {true, true, false},
                {true, true, true},
                {true, true, true}
        };

        System.out.println(countAllPaths(grid));
        System.out.println(countAllPathsIteratively(grid));
    }

    /*
     * Find first path
     *
     * */
    public static List<String> findPath(boolean[][] grid) {
        return getPath(0, 0, grid);
    }

    private static List<String> getPath(int row, int column, boolean[][] grid) {

        if (row >= grid.length || column >= grid[0].length || !grid[row][column]) {
            return null;
        }

        if (row == grid.length - 1 && column == grid[0].length - 1) {
            return new ArrayList<>();
        }

        List<String> solutionToTheRight = getPath(row, column + 1, grid);
        if (solutionToTheRight != null) {
            solutionToTheRight.add(0, "right");
            return solutionToTheRight;
        }

        List<String> solutionDown = getPath(row + 1, column, grid);
        if (solutionDown != null) {
            solutionDown.add(0, "down");
            return solutionDown;
        }

        return null;
    }

    /*
     * Finds all possible paths
     *
     * */
    public static List<List<String>> findAllPaths(boolean[][] grid) {
        return getAllPaths(0, 0, grid, new HashMap<>());
    }

    private static List<List<String>> getAllPaths(int row, int column, boolean[][] grid, Map<String, List<List<String>>> memo) {
        String key = row + "," + column;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (row >= grid.length || column >= grid[0].length || !grid[row][column]) {
            return new ArrayList<>();
        }

        if (row == grid.length - 1 && column == grid[0].length - 1) {
            List<List<String>> paths = new ArrayList<>();
            paths.add(new ArrayList<>());
            return paths;
        }

        List<List<String>> solutionToTheRight = getAllPaths(row, column + 1, grid, memo);
        List<List<String>> solutionDown = getAllPaths(row + 1, column, grid, memo);

        List<List<String>> solutions = new ArrayList<>();

        if (!solutionToTheRight.isEmpty()) {
            for (List<String> path : solutionToTheRight) {
                path.add(0, "right");
                solutions.add(path);
            }
        }

        if (!solutionDown.isEmpty()) {
            for (List<String> path : solutionDown) {
                path.add(0, "down");
                solutions.add(path);
            }
        }

        memo.put(key, solutions);
        return solutions;
    }

    /*
     * Counts all possible paths
     * */
    public static int countAllPaths(boolean[][] grid) {
        return countAllPaths(0, 0, grid, new HashMap<>());
    }

    private static int countAllPaths(int row, int column, boolean[][] grid, Map<String, Integer> memo) {
        String key = row + "," + column;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (row >= grid.length || column >= grid[0].length || !grid[row][column]) {
            return 0;
        }

        if (row == grid.length - 1 && column == grid[0].length - 1) {
            return 1;
        }

        int paths = countAllPaths(row, column + 1, grid, memo) + countAllPaths(row + 1, column, grid, memo);

        memo.put(key, paths);
        return paths;
    }

    /*
     * Gets all paths possible
     *
     * Dynamic programming iteratively
     *
     * */
    public static int countAllPathsIteratively(boolean[][] grid) {
        int[][] table = new int[grid.length][grid[0].length];

        table[0][0] = 1;

        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[row].length; column++) {
                int current = table[row][column];
                if (isValidCoordinate(row, column + 1, grid) && grid[row][column + 1]) {
                    table[row][column + 1] += current;
                }
                if (isValidCoordinate(row + 1, column, grid) && grid[row + 1][column]) {
                    table[row + 1][column] += current;
                }
            }
        }

        return table[table.length - 1][table[0].length - 1];
    }

    private static boolean isValidCoordinate(int row, int column, boolean[][] grid) {
        return row < grid.length && row >= 0 && column < grid[0].length && column >= 0;
    }
}
