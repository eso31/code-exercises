package com.tree;

public class TreeHeight {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        node3.right = node20;
        node3.left = node9;
        node20.right = node7;
        node20.left = node15;

        System.out.println(maxDepth(node3));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
    }
}
