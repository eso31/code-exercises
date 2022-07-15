package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapsPriorityQueue {
    public static void main(String[] args) {
        heapMinExample();
        System.out.println("===========");
        heapMaxExample();
    }

    public static void heapMinExample() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(5);
        queue.add(9);
        queue.add(4);

        System.out.println(queue.peek()); // 1
        queue.poll();
        System.out.println(queue.peek()); // 4
        queue.poll();
        System.out.println(queue.peek()); // 5
        queue.poll();
        System.out.println(queue.peek()); // 9
    }

    public static void heapMaxExample() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.add(1);
        queue.add(5);
        queue.add(9);
        queue.add(4);

        System.out.println(queue.peek()); // 9
        queue.poll();
        System.out.println(queue.peek()); // 5
        queue.poll();
        System.out.println(queue.peek()); // 4
        queue.poll();
        System.out.println(queue.peek()); // 1
    }
}
