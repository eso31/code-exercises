package com.heap;

import java.util.Arrays;

public class HeapMax {
    private int capacity = 10;
    private int size = 0;
    private int[] array = new int[capacity];

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private int getParent(int index) {
        return array[getParentIndex(index)];
    }

    private int getLeftChild(int index) {
        return array[getLeftChildIndex(index)];
    }

    private int getRightChild(int index) {
        return array[getRightChildIndex(index)];
    }

    private void ensureCapacity() {
        if (size >= array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
    }

    private boolean hasParent(int index) {
        return index > 0;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    public void insert(int number) {
        ensureCapacity();

        array[size] = number;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) < array[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void swap(int index, int parentIndex) {
        int temp = array[index];
        array[index] = array[parentIndex];
        array[parentIndex] = temp;
    }

    public void remove(int index) {
        swap(index, size - 1);
        size--;
        heapifyDown();
    }

    private void heapifyDown() {
        int index = 0;
        while (index < size - 1) {
            if (hasLeftChild(index)) {
                int biggestChild = getLeftChild(index);
                int biggestChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && getRightChild(index) > biggestChild) {
                    biggestChild = getRightChild(index);
                    biggestChildIndex = getRightChildIndex(index);
                }

                if (biggestChild > array[index]) {
                    swap(index, biggestChildIndex);
                    index = biggestChildIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    public int getMax() {
        return array[0];
    }

    public int getHeapSize() {
        return size;
    }

    public void printPretty() {
        int nodeToPrint = 0;
        int maxLvl = (int) (Math.log(size + 1) / Math.log(2));
        while (nodeToPrint < size) {
            int lvl = (int) (Math.log(nodeToPrint + 1) / Math.log(2));
            int diffLvls = maxLvl - lvl + 1;
            for (int i = 0; i < diffLvls; i++) {
                System.out.print("\t\t");
            }
            System.out.print(array[nodeToPrint]);

            if (((int) (Math.log(nodeToPrint + 2) / Math.log(2))) > lvl) {
                System.out.println();
            }

            nodeToPrint++;
        }
    }
}
