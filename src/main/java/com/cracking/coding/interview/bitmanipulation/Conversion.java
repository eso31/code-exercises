package com.cracking.coding.interview.bitmanipulation;

public class Conversion {
    public static void main(String[] args) {
        System.out.println(conversion(29, 15));
    }

    /*
     * Write a function to determine the number of bits
     * you would need to flip to convert integer A to integer B
     *
     * */
    public static int conversion(int a, int b) {
        //hacer xor between A and B
        // if equal -> 0s
        // Else you get 1s and 0s
        // Convert to string
        // Count 1s


        int diff = a ^ b;
        String diffString = Integer.toBinaryString(diff);

//        int counter = 0;
//
//        for(int i = 0; i < diffString.length(); i++) {
//            char bit = diffString.charAt(i);
//
//            if(bit == '1') {
//                counter++;
//            }
//        }

        return diffString.codePoints()
                .mapToObj(c -> String.valueOf((char) c))
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
