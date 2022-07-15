package com.cracking.coding.interview.ood.minesweeper;

public class MineSweeper {
    private final int n;
    private final int bombsNumber;
    private int exposedCells;
    private Cell[][] cells;

    public MineSweeper(int n, int bombsNumber) {
        if (bombsNumber > n * n) {
            throw new IllegalStateException("Number of bombs cannot be greater than the number of cells");
        }

        this.n = n;
        this.bombsNumber = bombsNumber;
        this.exposedCells = 0;
        init(n, bombsNumber);
    }

    public void prettyPrint() {
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[0].length; column++) {
                Cell cell = cells[row][column];
                String thingToPrint = cell.hasBomb() ? "*" : String.valueOf(cell.getBombsCounter());
                System.out.print(thingToPrint + " ");
            }
            System.out.println();
        }
    }

    public void prettyPrintHidden() {
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[0].length; column++) {
                Cell cell = cells[row][column];
                System.out.print(getThingToPrint(cell) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private String getThingToPrint(Cell cell) {
        String thingToPrint = "?";
        if (cell.isExposed()) {
            if (cell.hasFlag()) return "F";
            thingToPrint = cell.hasBomb() ? "*" : String.valueOf(cell.getBombsCounter());
        }

        return thingToPrint;
    }

    public void exposeCell(int row, int column) throws Exception {
        if (!isPositionValid(row, column)) {
            return;
        }

        Cell cell = cells[row][column];

        if (cell.hasFlag() || cell.isExposed()) {
            return;
        }

        if (cell.hasBomb()) {
            System.out.println("You lost!");
            prettyPrint();
            System.exit(0);
        }

        exposeRecursively(row, column);
        prettyPrintHidden();
        areAllBombsFound();
    }

    private void areAllBombsFound() {
        if (n * n - bombsNumber == exposedCells) {
            System.out.println("You won!");
            prettyPrint();
            System.exit(0);
        }
    }

    public void markCellWithFlag(int row, int column) {
        if (isPositionValid(row, column)) {
            cells[row][column].setFlag(true);
        }
        prettyPrintHidden();
    }

    public void removeFlagFromCell(int row, int column) {
        if (isPositionValid(row, column)) {
            cells[row][column].setFlag(false);
        }
        prettyPrintHidden();
    }

    private void exposeRecursively(int row, int column) {
        if (!isPositionValid(row, column)) {
            return;
        }

        Cell cell = cells[row][column];

        if (cell.isExposed()) {
            return;
        }

        if (cell.getBombsCounter() > 0) {
            cell.setExpose(true);
        } else {
            cell.setExpose(true);
            exposeCellSurrounding(row, column);
        }

        exposedCells++;
    }

    private void exposeCellSurrounding(int row, int column) {
        exposeRecursively(row - 1, column - 1);
        exposeRecursively(row - 1, column);
        exposeRecursively(row - 1, column + 1);

        exposeRecursively(row, column - 1);
        exposeRecursively(row, column + 1);

        exposeRecursively(row + 1, column - 1);
        exposeRecursively(row + 1, column);
        exposeRecursively(row + 1, column + 1);
    }

    private void init(int n, int bombsNumber) {
        cells = new Cell[n][n];

        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[0].length; column++) {
                cells[row][column] = new Cell();
            }
        }

        int bombsAdded = 0;

        while (bombsAdded < bombsNumber) {
            int randomI = (int) (Math.random() * n);
            int randomJ = (int) (Math.random() * n);

            Cell cell = cells[randomI][randomJ];
            if (!cell.hasBomb()) {
                cell.setBomb(true);
                bombsAdded++;
                increaseCounterInSurroundingCells(randomI, randomJ);
            }
        }
    }

    /*
     * 1 1 1
     * 1 * 1
     * 1 1 1
     * */
    private void increaseCounterInSurroundingCells(int row, int column) {
        increaseCounterSafely(row - 1, column - 1);
        increaseCounterSafely(row - 1, column);
        increaseCounterSafely(row - 1, column + 1);

        increaseCounterSafely(row, column - 1);
        increaseCounterSafely(row, column + 1);

        increaseCounterSafely(row + 1, column - 1);
        increaseCounterSafely(row + 1, column);
        increaseCounterSafely(row + 1, column + 1);
    }

    private void increaseCounterSafely(int row, int column) {
        if (isPositionValid(row, column)) {
            cells[row][column].increaseBombCounter();
        }
    }

    private boolean isPositionValid(int row, int column) {
        return row >= 0 && row < cells.length && column >= 0 && column < cells[0].length;
    }
}
