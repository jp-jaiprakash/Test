package binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public int findKthLargestValueInBst(BST tree, int k) {
        // Write your code here.
        List<Integer> lst = new ArrayList<>();
        lst = inOrderTravesal(tree, lst);

        return lst.get(lst.size() - k);
    }

    public List<Integer> inOrderTravesal(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }

        if (tree.left != null) {
            inOrderTravesal(tree.left, array);
        }
        array.add(tree.value);
        if (tree.right != null) {
            inOrderTravesal(tree.right, array);
        }
        return array;
    }

    public List<Integer> inOrderTravesalReverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }

        if (tree.right != null) {
            inOrderTravesal(tree.right, array);
        }
        array.add(tree.value);
        if (tree.left != null) {
            inOrderTravesal(tree.left, array);
        }
        return array;
    }
}
