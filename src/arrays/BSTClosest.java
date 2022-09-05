package arrays;

public class BSTClosest {
    
    public static int findClosestValueInBst(BST tree, int target){
        return findClosestValueInBst(tree, target,tree.value);
    }

    private static int findClosestValueInBst(BST tree, int target, int closest) {
        if(Math.abs(target-closest) > Math.abs(target - tree.value))
            return tree.value;

        if (target < tree.value && tree.left !=null)
            return findClosestValueInBst(tree.left, target, closest);
        else if (target > tree.value && tree.right != null)
            return findClosestValueInBst(tree.right, target, closest);
        else
            return closest;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;
        
        public BST(int value){
            this.value = value;
        }
    }
}

