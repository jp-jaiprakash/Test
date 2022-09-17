package binarysearchtrees;

import java.util.List;

public class MinHeight {
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return constructMinHeightBST(array, 0, array.size() - 1);

    }

    private static BST constructMinHeightBST(List<Integer> array, int startIdx, int endIdx) {
        if (endIdx < startIdx)
            return null;
        int midIdx = (startIdx + endIdx) / 2;
        BST root = new BST(array.get(midIdx));
        root.left = constructMinHeightBST(array, startIdx, midIdx - 1);
        root.right = constructMinHeightBST(array, midIdx + 1, endIdx);
        return root;
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}


