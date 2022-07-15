package com.leetcode;

/***
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);


        node4.left = node2;
        node4.right = node7;

        node2.left = node1;
        node2.right = node3;

        node7.left = node6;
        node7.right = node9;

        printTree(node4, 0);

        System.out.println(invertBinaryTree(node4));

        printTree(node4, 0);
    }

    public static TreeNode invertBinaryTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        invertBinaryTree(node.left);
        invertBinaryTree(node.right);

        return node;
    }

    private static void printTree(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }

        System.out.println(sb.toString() + node.val);
        printTree(node.left, level + 1);
        printTree(node.right, level + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
