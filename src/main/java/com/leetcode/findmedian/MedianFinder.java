package com.leetcode.findmedian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianFinder {
    private List<Integer> array;

    public MedianFinder() {
        array = new ArrayList<>();
    }

    public void addNum(int num) {
        array.add(num);
    }

    public double findMedian() {

        Collections.sort(array);

        int mid = array.size() / 2;

        if (array.size() % 2 == 0) {
            return ((double) array.get(mid-1) + array.get(mid)) / 2;
        }
        return array.get(mid);
    }
}
