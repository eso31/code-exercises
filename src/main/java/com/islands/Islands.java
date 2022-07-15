package com.islands;

import static java.lang.Integer.MIN_VALUE;

class Islands {
    static int numberOfCellsInBiggestIsland(int[][] matrix) {

        int max = MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int size = getIslandSize(i, j, matrix);
                    if(size>max) {
                        max = size;
                    }
                }
            }
        }


        return max;
    }

    private static int getIslandSize(int i, int j, int[][] matrix) {
        if (i < 0 || j < 0 || i > matrix.length - 1 || j > matrix[0].length - 1 || matrix[i][j] == 0) {
            return 0;
        }

        if (matrix[i][j] == 1) {
            matrix[i][j] = 0;
            return 1 + getIslandSize(i + 1, j, matrix) +
                    getIslandSize(i, j + 1, matrix) +
                    getIslandSize(i - 1, j, matrix) +
                    getIslandSize(i, j - 1, matrix) +

                    getIslandSize(i - 1, j - 1, matrix) +
                    getIslandSize(i - 1, j + 1, matrix) +
                    getIslandSize(i + 1, j - 1, matrix) +
                    getIslandSize(i + 1, j + 1, matrix);
        }

        return 0;
    }
}