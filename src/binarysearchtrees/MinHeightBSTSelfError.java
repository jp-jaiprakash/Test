package binarysearchtrees;

import java.util.List;

public class MinHeightBSTSelfError {
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.

        if (array.size() == 1) {
            return new BST(array.get(0));
        }
        int idx = array.size() / 2;
        List<Integer> leftarray = array.subList(0, idx);
        List<Integer> rightArray = array.subList(idx + 1, array.size());

        BST root = new BST(array.get(idx));
        root.left = minHeightBst(root, leftarray);
        root.right = minHeightBst(root, rightArray);
        return root;
    }

    public static BST minHeightBst(BST root, List<Integer> array) {
        if (array.size() == 1) {
            root.insert(array.get(0));
            return root;
        }
        int idx = array.size() / 2;
        List<Integer> leftarray = array.subList(0, idx);
        List<Integer> rightArray = array.subList(idx + 1, array.size());

        BST node = new BST(array.get(idx));
        minHeightBst(node, leftarray);
        minHeightBst(node, rightArray);
        return node;
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

