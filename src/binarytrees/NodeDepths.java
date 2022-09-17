package binarytrees;

public class NodeDepths {

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return nodeDepths(root, 0);

    }

    public static int nodeDepths(BinaryTree root, int depth) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return depth;

        return depth + nodeDepths(root.left, depth + 1) + nodeDepths(root.right, depth + 1);

    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }


}
