import com.domain.BinaryTreeNode;

class ToDLL {
    public static BinaryTreeNode convert_to_linked_list(BinaryTreeNode root) {
        return convert_to_linked_list_with_parents(root, null);
    }

    public static BinaryTreeNode convert_to_linked_list_with_parents(BinaryTreeNode root, BinaryTreeNode parent) {
        if (root.left == null && root.right == null && parent != null) {
            if (parent.data > root.data) {
                root.right = parent;
            } else if (parent.data < root.data) {
                root.left = parent;
            }
            return root;
        }

        if (root.left == null && root.right != null && parent != null) {
            root.right = convert_to_linked_list_with_parents(root.right, root);
            if (parent.data > root.data) {
                root.left = null;
                BinaryTreeNode greatestChild = getGreatest(root.right);
                greatestChild.right = parent;
                return greatestChild;
            } else if (parent.data < root.data) {
                root.left = parent;
                return root;
            }
        }

        if (root.left != null && root.right == null && parent != null) {
            root.left = convert_to_linked_list_with_parents(root.left, root);
            if (parent.data > root.data) {
                root.right = parent;
                root.left.right = root;
                return root;
            } else if (parent.data < root.data) {
                return getSmallest(root.left);
            }
        }

        if (root.left != null && root.right != null) {
            root.left = convert_to_linked_list_with_parents(root.left, root);
            root.left.right = root;
            root.right = convert_to_linked_list_with_parents(root.right, root);
            root.right.left = root;
        }

        if (parent != null) {
            if (parent.data > root.data) {
                return getGreatest(root);
            } else if (parent.data < root.data) {
                return getSmallest(root);
            }
        }

        return getSmallest(root);
    }

    public static BinaryTreeNode getSmallest(BinaryTreeNode node) {
        if (node.left == null) {
            return node;
        }

        return getSmallest(node.left);
    }

    public static BinaryTreeNode getGreatest(BinaryTreeNode node) {
        if (node.right == null) {
            return node;
        }

        return getGreatest(node.right);
    }
}  