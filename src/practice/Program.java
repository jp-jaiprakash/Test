package practice;

public class Program {
  public static int findClosestValueInBst(BST tree, int target) {

    if(tree == null)
      return Integer.parseInt(null);

    if(tree.left == null && tree.right == null){
      return tree.value;
    }
    // Write your code here.
    int closestLeft = findClosestValueInBst(tree.left, target);

    int closestRight = findClosestValueInBst(tree.right, target);
    int ans = -1;
    if( (target - closestLeft) < (target - closestRight))
      ans = closestLeft;
    else
      ans = closestRight;

    if( (target - tree.value) <  (target - ans))
      return tree.value;
    
    return ans;
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