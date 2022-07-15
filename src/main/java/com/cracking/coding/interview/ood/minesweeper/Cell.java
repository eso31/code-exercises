package com.cracking.coding.interview.ood.minesweeper;

public class Cell {
    private int bombsCounter;
    private boolean hasBomb;
    private boolean hasFlag;
    private boolean isExposed;

    public Cell() {
        this.bombsCounter = 0;
        this.hasBomb = false;
        this.hasFlag = false;
        this.isExposed = false;
    }

    public int getBombsCounter() {
        return bombsCounter;
    }

    public Cell bombsCounter(int bombsCounter) {
        this.bombsCounter = bombsCounter;
        return this;
    }

    public void increaseBombCounter() {
        this.bombsCounter++;
    }

    public boolean hasBomb() {
        return hasBomb;
    }

    public Cell setBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
        return this;
    }

    public boolean hasFlag() {
        return hasFlag;
    }

    public Cell setFlag(boolean hasFlag) {
        this.hasFlag = hasFlag;
        return this;
    }

    public boolean isExposed() {
        return isExposed;
    }

    public Cell setExpose(boolean exposed) {
        this.isExposed = exposed;
        return this;
    }
}
