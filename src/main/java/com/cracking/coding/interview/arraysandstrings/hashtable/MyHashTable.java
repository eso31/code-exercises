package com.cracking.coding.interview.arraysandstrings.hashtable;

import java.util.LinkedList;
import java.util.List;

public class MyHashTable<K, V> {
    private final List<MyEntry<K, V>>[] hashTable;

    private final int initialCapacity = 10;

    public MyHashTable() {
        this.hashTable = new LinkedList[initialCapacity];
    }

    public void put(K key, V value) {
        int index = key.hashCode() % hashTable.length;

        MyEntry<K, V> entry = new MyEntry<>(key, value);

        List<MyEntry<K, V>> entries = this.hashTable[index];

        if (entries == null) {
            entries = new LinkedList<>();
            this.hashTable[index] = entries;
        }

        entries.add(entry);
    }

    public Object get(K key) {
        int index = key.hashCode() % hashTable.length;

        List<MyEntry<K, V>> entries = this.hashTable[index];

        if (entries == null) {
            return null;
        }

        for (MyEntry<K, V> e : entries) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }

        return null;
    }

    public void printStructure() {
        for (int index = 0; index < hashTable.length; index++) {
            List<MyEntry<K, V>> entries = this.hashTable[index];
            if (entries == null) {
                System.out.println(String.format("index %s is empty", index));
            } else {
                System.out.println("index: " + index);
                for (MyEntry<K, V> entry : entries) {
                    System.out.println(String.format("K: %s, V: %s", entry.getKey(), entry.getValue()));
                }
            }
        }
    }
}
