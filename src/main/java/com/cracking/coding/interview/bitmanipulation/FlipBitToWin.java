package com.cracking.coding.interview.bitmanipulation;

public class FlipBitToWin {
    public static void main(String[] args) {
        System.out.println(longestSequence(1775));
    }

    /*
    * You have an integer and you can flip
    * exactly one bit from a 0 to 1.
    *
    * Write code to find the length of the
    * longest sequence of 1s you could create
    *
    * */
    public static int longestSequence(int number) {
        String bits = Integer.toBinaryString(number);
        System.out.println(bits);
        int max = 0;
        int i = 0;
        boolean oneZeroSeen = false;
        int lastZeroIndex = -1;
        int counter = 0;

        while (i < bits.length()) {
            String bit = String.valueOf(bits.charAt(i));
            if (bit.equals("0")) {
                if (oneZeroSeen) {
                    if (counter > max) {
                        max = counter;
                    }
                    counter = 0;
                    oneZeroSeen = false;
                    i = lastZeroIndex + 1;
                } else {
                    oneZeroSeen = true;
                    lastZeroIndex = i;
                    counter++;
                    i++;
                }
            }

            if (bit.equals("1")) {
                counter++;
                i++;
            }
        }

        if (counter > max)
            max = counter;

        return max;
    }
}
