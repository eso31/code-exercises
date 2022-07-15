package com.heap;

public class Main {
    public static void main(String[] args) {
        HeapMin heapMin = new HeapMin();
        heapMin.insert(1);
        heapMin.insert(2);
        heapMin.insert(3);
        heapMin.insert(4);
        heapMin.insert(5);
        heapMin.insert(6);
        heapMin.insert(7);
        heapMin.insert(8);
        heapMin.removeMin();

        heapMin.printPretty();
    }

    public static void testHeapMax() {
        HeapMax heapMax = new HeapMax();
        heapMax.insert(5);
        heapMax.insert(3);
        heapMax.insert(24);
        heapMax.insert(15);
        heapMax.insert(2);
        heapMax.insert(25);
        heapMax.insert(67);
        heapMax.insert(89);
        heapMax.insert(7);


        heapMax.remove(0);

        System.out.println();
        heapMax.printPretty();
    }
}
