package com.leetcode.findmedian;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMediaFromDataStream {
    public static void main(String[] args) {
        test4();
    }

    private static void test1() {
        MedianFinder3 medianFinder = new MedianFinder3();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

    private static void test2() {
        MedianFinder3 medianFinder = new MedianFinder3();
        //["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
        //[[],[-1],[],[-2],[],[-3],[],[-4],[],[-5],[]]
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }

    private static void test3(){
        //["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
        //[[],[12],[],[10],[],[13],[],[11],[],[5],[],[15],[],[1],[],[11],[],[6],[],[17],[],[14],[],[8],[],[17],[],[6],[],[4],[],[16],[],[8],[],[10],[],[2],[],[12],[],[0],[]]
        MedianFinder3 medianFinder3 = new MedianFinder3();

        medianFinder3.addNum(12);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(10);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(13);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(11);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(5);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(15);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(1);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(11);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(6);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(17);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(14);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(8);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(17);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(6);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(4);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(16);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(8);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(10);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(2);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(12);
        System.out.println(medianFinder3.findMedian());
        medianFinder3.addNum(0);
        System.out.println(medianFinder3.findMedian());
    }

    private static void test4() {
        // ["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
        // [[],[40],[],[12],[],[16],[],[14],[],[35],[],[19],[],[34],[],[35],[],[28],[],[35],[],[26],[],[6],[],[8],[],[2],[],[14],[],[25],[],[25],[],[4],[],[33],[],[18],[],[10],[],[14],[],[27],[],[3],[],[35],[],[13],[],[24],[],[27],[],[14],[],[5],[],[0],[],[38],[],[19],[],[25],[],[11],[],[14],[],[31],[],[30],[],[11],[],[31],[],[0],[]]

        MedianFinder3 medianFinder3 = new MedianFinder3();
        medianFinder3.addNum(40);
        medianFinder3.addNum(12);
        medianFinder3.addNum(16);
        medianFinder3.addNum(1);
    }
}
