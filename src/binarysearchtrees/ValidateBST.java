package binarysearchtrees;

public class ValidateBST {

    public static boolean validateBst(BST tree) {
        if(tree == null)
            return true;
        return validateBst(tree, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean validateBst(BST tree, Integer max, Integer min) {

        if(tree.value <= min || tree.value > max)
            return false;

        if(tree.left != null && !validateBst(tree.left, tree.value, min))
            return false;
        if(tree.right != null && !validateBst(tree.right, max, tree.value))
            return false;

        return true;


    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
