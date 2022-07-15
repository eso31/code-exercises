package com.heap;

import java.util.Arrays;

public class HeapMin {
    private int[] array;
    private int size;

    public HeapMin() {
        this.array = new int[10];
        this.size = 0;
    }

    public void insert(int value) {
        ensureCapacity();

        array[size] = value;
        size++;

        heapifyUp();
    }

    public void removeMin() {
        swap(0, size - 1);
        size--;

        heapifyDown();
    }

    private void heapifyDown() {
        if (size == 1) {
            return;
        }

        int index = 0;

        while (index < size - 1) {
            int leftChildIndex = getLeftChildIndex(index);
            if (leftChildIndex <= size - 1) {
                int smallestChild = array[leftChildIndex];
                int smallestChildIndex = leftChildIndex;

                int rightChildIndex = getRightChildIndex(index);
                if (rightChildIndex < size) {
                    int rightChildValue = array[rightChildIndex];

                    if (rightChildValue < smallestChild) {
                        smallestChild = rightChildValue;
                        smallestChildIndex = rightChildIndex;
                    }

                }

                if (smallestChild < array[index]) {
                    swap(index, smallestChildIndex);
                    index = smallestChildIndex;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }


    private void ensureCapacity() {
        if (array.length == size) {
            array = Arrays.copyOf(array, size * 2);
        }
    }

    public int getMin() {
        return array[0];
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private boolean hasParent(int index) {
        return index > 0;
    }

    private void swap(int index1, int index2) {
        int value1 = array[index1];
        int value2 = array[index2];
        array[index1] = value2;
        array[index2] = value1;
    }

    private void heapifyUp() {
        if (size == 1) {
            return;
        }

        int valueIndex = size - 1;
        int value = array[valueIndex];
        int parentIndex = getParentIndex(valueIndex);
        int parentValue = array[parentIndex];

        while (value < parentValue && hasParent(valueIndex)) {
            swap(valueIndex, parentIndex);
            valueIndex = parentIndex;

            if (hasParent(valueIndex)) {
                parentIndex = getParentIndex(valueIndex);
                parentValue = array[parentIndex];
            }
        }
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
