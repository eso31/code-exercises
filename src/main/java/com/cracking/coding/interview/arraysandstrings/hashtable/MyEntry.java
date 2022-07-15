package com.cracking.coding.interview.arraysandstrings.hashtable;

public class MyEntry<K, V> {
    private final K key;
    private final V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }
}
