package binarytrees;

public class ValidateBST {

    public static boolean validateBst(BST tree) {
        // Write your code here.
        if(tree == null || (tree.left == null && tree.right == null))
            return true;

        if( tree.value <= tree.left.value || tree.value > tree.right.value )
            return false;

        boolean leftBool, rightBool;
        if(tree.left != null){
            if(tree.value <= tree.left.value)
                return false;
            leftBool = validateBst(tree.left);
        }else{
            leftBool = true;
        }

        if(tree.right != null){
            if(tree.value > tree.right.value)
                return false;
            rightBool = validateBst(tree.right);
        }else{
            rightBool = true;
        }


        return leftBool && rightBool;
    }

    public static boolean validateBstII(BST tree) {
        // Write your code here.
        if(tree == null || (tree.left == null && tree.right==null)){
            return true;
        }
        boolean leftTest =false, rightTest = false;
        if(tree.left != null ){
            leftTest= tree.left.value < tree.value && validateBst(tree.left);
        }else{
            leftTest = true;
        }
        if(tree.right != null ){
            rightTest= tree.right.value >= tree.value && validateBst(tree.right);
        }else{
            rightTest = true;
        }
        return rightTest && leftTest;
    }
    public static int getMaximum(BST root){
        if(root.right == null)
            return root.value;
        else
            return getMaximum(root.right);
    }
    public static int getMinimum(BST root){
        if(root.left == null)
            return root.value;
        else
           return getMinimum(root.left);
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
