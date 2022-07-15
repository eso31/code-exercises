package com.leetcode.findmedian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MedianFinder2 {
    private PriorityQueue<Integer> heap;

    public MedianFinder2() {
        heap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        heap.add(num);
    }

    public double findMedian() {
        List<Integer> array = new ArrayList<>();
        while (!heap.isEmpty()) {
            array.add(heap.poll());
        }

        heap.addAll(array);

        int mid = array.size() / 2;

        if (array.size() % 2 == 0) {
            int element1 = array.get(mid - 1);
            int element2 = array.get(mid);
            return ((double) element1 + element2) / 2;
        }
        return array.get(mid);
    }
}
