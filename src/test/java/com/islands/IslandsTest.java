package com.islands;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandsTest {

    @Test
    public void numberOfCellsInBiggestIslandTest(){

        int[][] matrix;

        assertEquals(1, Islands.numberOfCellsInBiggestIsland(new int[][]{{1}}));

        matrix = new int[][]{
                {1,0,0,0},
                {0,0,0,0},
                {1,0,1,1}
        };
        assertEquals(2, Islands.numberOfCellsInBiggestIsland(matrix));

        matrix = new int[][]{
                {1,1,1},
                {0,0,0},
                {1,0,1}
        };
        assertEquals(3, Islands.numberOfCellsInBiggestIsland(matrix));

        matrix = new int[][]{
                {1,0,1},
                {0,1,0},
                {1,0,1}
        };
        assertEquals(5, Islands.numberOfCellsInBiggestIsland(matrix));

        matrix = new int[][]{
                {1,1,1,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,1,0,1,0,1,0},
                {0,0,1,0,1,0,0},
                {0,0,1,0,1,0,0},
                {1,0,1,0,1,0,1}
        };
        assertEquals(10, Islands.numberOfCellsInBiggestIsland(matrix));

        matrix = new int[][]{
                {1,1,1,1,1,1,0},
                {0,0,0,0,0,0,1},
                {1,1,0,1,0,1,0},
                {0,0,1,0,1,0,0}
        };
        assertEquals(13, Islands.numberOfCellsInBiggestIsland(matrix));

        matrix = new int[][]{
                {0, 1, 0, 0, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 1, 0, 1, 1},
                {0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 0, 1, 1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1, 1, 0, 0, 0}
        };
        assertEquals(29, Islands.numberOfCellsInBiggestIsland(matrix));

        matrix = new int[][]{
                {1,1,1,1,1,1,0,1,0,0,0,0,0,1,1},
                {0,0,0,0,0,1,1,0,1,0,0,0,0,0,0},
                {1,1,0,1,0,1,0,0,0,1,0,0,1,0,0},
                {0,0,0,1,0,0,0,0,0,1,1,0,0,1,0},
                {0,1,1,0,1,0,0,1,0,0,1,0,0,0,1},
                {1,0,1,1,1,0,0,1,0,0,0,1,0,1,0},
                {0,1,0,0,1,0,1,0,1,0,1,0,0,1,0},
                {1,0,1,1,0,0,1,0,1,0,1,0,1,0,1},
                {0,1,1,0,0,1,1,0,1,0,1,0,0,1,1},
                {1,0,1,0,1,1,1,0,0,1,0,0,0,1,0}
        };
        assertEquals(32, Islands.numberOfCellsInBiggestIsland(matrix));
    }

}