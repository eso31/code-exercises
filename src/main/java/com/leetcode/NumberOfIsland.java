package com.leetcode;

/***
 * https://leetcode.com/problems/number-of-islands/
 */
public class NumberOfIsland {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '0', '0'},
                {'0', '1', '1'},
                {'1', '0', '1'}
        };

        System.out.println(numIslands(grid));


        char[][] grid2 = new char[][]{
                {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
                {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '0', '1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '0', '0', '0', '0', '1'},
                {'1', '0', '1', '0', '1', '0', '0', '1', '0', '1'},
                {'1', '0', '0', '1', '1', '1', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '0', '1', '1', '1', '1', '0'},
                {'1', '0', '1', '1', '1', '0', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'}
        };

        printGrid(grid2);

        System.out.println(numIslands(grid2));

    }

    public static int numIslands(char[][] grid) {
        int sum = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                int island = numIslands(grid, row, column);
                sum += island;
                if (island == 1)
                    printGrid(grid);
            }
        }

        return sum;
    }

    private static void printGrid(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                System.out.print(grid[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    private static int numIslands(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == '0') {
            return 0;
        }

        grid[row][column] = '0';

        numIslands(grid, row + 1, column);
        numIslands(grid, row, column + 1);
        numIslands(grid, row, column - 1);
        numIslands(grid, row - 1, column);

        return 1;
    }


    /***
     * [['1','1','1','1','1','0','1','1','1','1'],
     * ['1','0','1','0','1','1','1','1','1','1'],
     * ['0','1','1','1','0','1','1','1','1','1'],
     * ['1','1','0','1','1','0','0','0','0','1'],
     * ['1','0','1','0','1','0','0','1','0','1'],
     * ['1','0','0','1','1','1','0','1','0','0'],
     * ['0','0','1','0','0','1','1','1','1','0'],
     * ['1','0','1','1','1','0','0','1','1','1'],
     * ['1','1','1','1','1','1','1','1','0','1'],
     * ['1','0','1','1','1','1','1','1','1','0']]
     */

}
