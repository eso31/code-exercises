package com.cracking.coding.interview.ood.callcenter;

public class Util {
    public static int getRandomNumber(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }

    public static void wait(int min, int max) {
        int time = getRandomNumber(min, max);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
