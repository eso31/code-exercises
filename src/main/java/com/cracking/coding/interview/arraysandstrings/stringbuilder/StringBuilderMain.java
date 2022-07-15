package com.cracking.coding.interview.arraysandstrings.stringbuilder;

public class StringBuilderMain {
    public static void main(String[] args) {
        MyStringBuilder stringBuilder = new MyStringBuilder("hola ");

        String s = stringBuilder.append("como ")
                .append("alskdjalsjdlasjdljasldjlasfkjslbsdkjnkjsfnvkbsfhblafhlahjsbfglhjadfblvjhnljhfdanljvbdfljhbdaf")
                .append("alskdjalsjdlasjdljasldjlasfkjslbsdkjnkjsfnvkbsfhblafhlahjsbfglhjadfblvjhnljhfdanljvbdfljhbdaf")
                .toString();

        System.out.println(s);
    }
}
