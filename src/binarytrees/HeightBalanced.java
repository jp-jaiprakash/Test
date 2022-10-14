package binarytrees;


public class HeightBalanced {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        private int height;
        private boolean isBalanced;

        public TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public TreeInfo getTreeInfo(BinaryTree node) {
        if (node == null)
            return new TreeInfo(-1, true);

        TreeInfo leftSubTree = getTreeInfo(node.left);
        TreeInfo rightSubTree = getTreeInfo(node.right);

        boolean isBalanced = leftSubTree.isBalanced && rightSubTree.isBalanced &&
                (Math.abs(leftSubTree.height - rightSubTree.height) <= 1);

        int height = Math.max(leftSubTree.height, rightSubTree.height) + 1;
        return new TreeInfo(height, isBalanced);
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        return getTreeInfo(tree).isBalanced;
    }
}
