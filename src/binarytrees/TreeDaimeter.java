package binarytrees;

public class TreeDaimeter {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        int height;
        int daimeter;

        public TreeInfo(int height, int daimeter) {
            this.daimeter = daimeter;
            this.height = height;
        }

    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null)
            return new TreeInfo(0, 0);

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo rightTreeInfo = getTreeInfo(tree.right);

        // Now calculate the longest path through this tree node which is being passed
        // calculate the maximum diameter, current height
        int longestPathThroughRoot = leftTreeInfo.height + rightTreeInfo.height;

        int maxDiameterSoFar = Math.max(leftTreeInfo.daimeter, rightTreeInfo.daimeter);

        int currentDiameter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

        return new TreeInfo(currentHeight, currentDiameter);


    }

    public int binaryTreeDiameter(BinaryTree tree) {
        // Write your code here.
        return getTreeInfo(tree).daimeter;
    }
}
