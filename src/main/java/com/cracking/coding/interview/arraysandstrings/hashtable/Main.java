package com.cracking.coding.interview.arraysandstrings.hashtable;

public class Main {
    public static void main(String[] args) {
        MyHashTable<String, String> table = new MyHashTable<>();
        table.put("key1", "value1");
        table.put("key2", "value2");
        table.put("key3", "value3");
        table.put("key4", "value4");
        table.put("key43", "value43");
        table.put("key77", "value77");

        table.printStructure();
    }
}
