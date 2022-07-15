package com.cracking.coding.interview.stack;

import java.util.stream.IntStream;

public class StackMain {
    public static void main(String[] args) {
//        Stack stack = new Stack(1, 5, 2, 1, 4, 3, 1, 7, 2, 8, 9, 5);
//        Stack stack = new Stack(1,2,3, 1, 4, 1);


//        System.out.println(stack);

        Runnable thing = () -> {
            Stack stack = new Stack(IntStream.rangeClosed(1, 100000).toArray());
            stack.sort();
        };

        timeIt(thing, 1);
    }

    private static void timeIt(Runnable thing, int timesToRun) {
        long sum = 0;
        for (int i = 0; i < timesToRun; i++) {
            long startTime = System.nanoTime();
            thing.run();
            long endTime = System.nanoTime();

            long durationMs = (endTime - startTime) / 1000000;
//            System.out.println("Duration: " + durationMs + "ms");
            sum += durationMs;
        }
        System.out.println("Duration sum: " + sum + "ms");
        System.out.println("Average " + ((long) (sum / (long) timesToRun)) + "ms");
    }
    /*
     *  stack.sort()
     *  n     ->    n^2 time ms average
     * 10    ->  2.48
     * 100   ->  7ms
     * 1000  ->  50ms
     * 10000  ->  800ms
     * 100000  ->  72967ms
     *
     * */
}
