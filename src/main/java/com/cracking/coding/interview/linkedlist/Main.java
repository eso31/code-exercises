package com.cracking.coding.interview.linkedlist;

public class Main {
    public static void main(String[] args) {
        SinglyList singlyList = new SinglyList(1, 2, 8, 4, 5, 9);

        singlyList.printList();
        System.out.println("============");
        System.out.println(singlyList.getKthToLast(3));
    }
}
