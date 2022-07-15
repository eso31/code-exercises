package com.cracking.coding.interview.tree;

import com.domain.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TreeMain {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node2_ = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node3_ = new BinaryTreeNode(3);
        BinaryTreeNode node1 = new BinaryTreeNode(1);

        root.left = node2;
        root.right = node2_;

        node2.left = node3;
        node2.right = node3_;

        node3_.right = node1;

        System.out.println(countPathsWithSum(5, root));
    }

    /*
     * Given a binary tree, create a linked list
     * of all nodes at each depth
     * */
    public static List<LinkedList<Integer>> listOfDepths(BinaryTreeNode root) {
        // DFS
        // have a map for k,v -> level,linkedlist
        // Send parentLevel and map
        // Recursive base: Null node: return; Get linkedlist from map.get(parentLevel+1) and insert ourself

        Map<Integer, LinkedList<Integer>> mapLevel = new HashMap<>();
        insertNodeInLinkedList(0, root, mapLevel);

        return new ArrayList<>(mapLevel.values());
    }

    private static void insertNodeInLinkedList(int parentLevel, BinaryTreeNode root, Map<Integer, LinkedList<Integer>> mapLevel) {
        if (root == null) return;

        int currentLevel = parentLevel + 1;
        insertNodeInLinkedList(currentLevel, root.left, mapLevel);
        List<Integer> currentLevelLinkedList = mapLevel.computeIfAbsent(currentLevel, k -> new LinkedList<>());
        currentLevelLinkedList.add(root.data);

        insertNodeInLinkedList(currentLevel, root.right, mapLevel);
    }

    /*
     * Find the First Common Ancestor between 2 nodes
     *
     * NOTE: It is not necessarily a binary search tree
     * */
    public static BinaryTreeNode getFCA(BinaryTreeNode root, int node1, int node2) {
        if (root == null) return null;

        BinaryTreeNode nodeFound1 = getFCA(root.left, node1, node2);
        BinaryTreeNode nodeFound2 = getFCA(root.right, node1, node2);
        // node1 + myself=anyNode -> myself
        // node2 + myself=anyNode -> myself
        // node1 + node2 -> myself
        // node1 -> node1
        // node2 -> node2
        // node1=null + node2=null -> null

        boolean iAmOneOfTheNodes = root.data == node1 || root.data == node2;

        if (iAmOneOfTheNodes) {
            return root;
        }

        if (nodeFound1 != null && nodeFound2 != null) {
            return root;
        }

        if (nodeFound1 != null) {
            return nodeFound1;
        }

        if (nodeFound2 != null) {
            return nodeFound2;
        }

        return null;
    }

    /*
     * Paths with Sum: You are given a binary tree in which each node contains an integer value (positive or negative)
     *
     * Count the number of paths that sum to a given value
     *
     * The path does not need to start/end at the root/leaf, but it MUST go downwards (travel from parent node to child nodes)
     * */
    public static int countPathsWithSum(int sumTarget, BinaryTreeNode root) {
        AtomicInteger counter = new AtomicInteger(0);

        countPathsWithSum(sumTarget, counter, root);

        return counter.get();
    }

    private static List<Integer> countPathsWithSum(int sumTarget, AtomicInteger counter, BinaryTreeNode node) {
        if (node == null) return Collections.emptyList();

        List<Integer> leftList = countPathsWithSum(sumTarget, counter, node.left);
        List<Integer> rightList = countPathsWithSum(sumTarget, counter, node.right);

        List<Integer> currentList = new ArrayList<>();

        for (int value : leftList) {
            int newValue = node.data + value;
            if (newValue == sumTarget) {
                counter.incrementAndGet();
            }
            currentList.add(newValue);
        }

        for (int value : rightList) {
            int newValue = node.data + value;
            if (newValue == sumTarget) {
                counter.incrementAndGet();
            }
            currentList.add(newValue);
        }

        if (node.data == sumTarget) {
            counter.incrementAndGet();
        }

        currentList.add(node.data);

        return currentList;
    }
}
