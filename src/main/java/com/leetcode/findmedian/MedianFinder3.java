package com.leetcode.findmedian;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder3 {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder3() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int total = maxHeap.size() + minHeap.size();
        
        if (total == 0) {
            maxHeap.add(num);
        } else if (total == 1) {
            if (num > maxHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        } else if (minHeap.size() == maxHeap.size()) {
            if (num > maxHeap.peek() && num > minHeap.peek()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            } else if (num < maxHeap.peek() && num < minHeap.peek()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(num);
            }
        } else if (maxHeap.size() < minHeap.size()) {
            if (num > maxHeap.peek() && num > minHeap.peek()) {
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            } else if (num < maxHeap.peek() && num < minHeap.peek()) {
                maxHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (num > maxHeap.peek() && num > minHeap.peek()) {
                minHeap.add(num);
            } else if (num < maxHeap.peek() && num < minHeap.peek()) {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {
                minHeap.add(num);
            }
        }
    }

    public double findMedian() {
        int total = maxHeap.size() + minHeap.size();

        if (maxHeap.size() == minHeap.size()) {
            return ((double) (maxHeap.peek() + minHeap.peek()) / 2);
        } else if (maxHeap.size() > minHeap.size() || total == 1) {
            return maxHeap.peek();
        }

        return minHeap.peek();
    }
}
