package com.leetcode.trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Trie {
    private Map<Character, TrieNode> nodes;
    private TrieNode endNode = new TrieNode('*');

    public Trie() {
        this.nodes = new HashMap<>();
    }

    public void insert(String word) {
        Map<Character, TrieNode> currentNodes = nodes;
        TrieNode currentNode = null;

        while (!word.isEmpty()) {
            char letter = word.charAt(0);
            word = word.substring(1);

            currentNode = currentNodes.get(letter);
            if (currentNode == null) {
                TrieNode node = new TrieNode(letter);
                currentNodes.put(letter, node);
                currentNode = currentNodes.get(letter);
            }

            currentNodes = currentNode.getChildren();
        }

        currentNodes.put(endNode.getValue(), endNode);
    }

    public boolean search(String word) {
        return search(nodes, word);
    }

    private boolean search(Map<Character, TrieNode> currentNodes, String word) {
        if (word.isEmpty()) {
            return currentNodes.containsKey(endNode.getValue());
        }

        char letter = word.charAt(0);
        word = word.substring(1);

        if (currentNodes.containsKey(letter)) {
            Map<Character, TrieNode> nextNodes = currentNodes.get(letter).getChildren();
            return search(nextNodes, word);
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        return startsWith(nodes, prefix);
    }

    private boolean startsWith(Map<Character, TrieNode> currentNodes, String word) {
        if (word.isEmpty()) {
            return true;
        }

        char letter = word.charAt(0);
        word = word.substring(1);

        if (currentNodes.containsKey(letter)) {
            Map<Character, TrieNode> nextNodes = currentNodes.get(letter).getChildren();
            return startsWith(nextNodes, word);
        }

        return false;
    }

    public class TrieNode {
        private Character value;
        private Map<Character, TrieNode> childNodes;

        public TrieNode(Character value) {
            this.value = value;
            this.childNodes = new HashMap<>();
        }

        public Map<Character, TrieNode> getChildren() {
            return childNodes;
        }

        public Character getValue() {
            return value;
        }

        public void addChild(TrieNode node) {
            childNodes.put(node.getValue(), node);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TrieNode trieNode = (TrieNode) o;
            return Objects.equals(value, trieNode.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
