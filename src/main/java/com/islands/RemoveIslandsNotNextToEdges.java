package com.islands;

public class RemoveIslandsNotNextToEdges {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 0, 0}
        };

        removeIslands(grid);
        printGrid(grid);
    }

    public static void removeIslands(int[][] grid) {
//        for (int row = 0; row < grid.length; row++) {
//            for (int column = 0; column < grid[0].length; column++) {
//                if (grid[row][column] == 1 &&
//                        (row == 0 || column == 0 || row == grid.length - 1 || column == grid[0].length - 1)) {
//                    removeIslands(grid, row, column);
//                }
//            }
//        }

        // limpiar con rows = 0
        for (int column = 0; column < grid[0].length; column++) {
            identifyEdgeIslands(grid, 0, column);
        }

        // limpiar con ultimo row
        for (int column = 0; column < grid[0].length; column++) {
            identifyEdgeIslands(grid, grid.length - 1, column);
        }

        //limpiar con column = 0
        for (int row = 0; row < grid.length; row++) {
            identifyEdgeIslands(grid, row, 0);
        }

        //limpiar con ultimo column
        for (int row = 0; row < grid.length; row++) {
            identifyEdgeIslands(grid, row, grid[0].length - 1);
        }


        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == -1) {
                    grid[row][column] = 1;
                } else if (grid[row][column] == 1) {
                    grid[row][column] = 0;
                }
            }
        }


    }

    private static void identifyEdgeIslands(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) {
            return;
        }

        if (grid[row][column] == 1) {
            grid[row][column] = -1;

            identifyEdgeIslands(grid, row + 1, column);
            identifyEdgeIslands(grid, row, column + 1);
            identifyEdgeIslands(grid, row, column - 1);
            identifyEdgeIslands(grid, row - 1, column);
        }
    }


    private static void printGrid(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                System.out.print(grid[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
