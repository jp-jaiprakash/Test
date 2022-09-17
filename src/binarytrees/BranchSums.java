package binarytrees;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> temp = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        branchSums(root, temp, answer);
        return answer;
    }

    static void branchSums(BinaryTree root,List<Integer> temp,List<Integer> answer ){
        temp.add(root.value);

        if(root.left == null && root.right == null){
            int sum = temp.stream().reduce(0, Integer::sum);
            answer.add(sum);
            temp.remove(temp.size()-1);
            return;
        }
        if(root.left != null){
            branchSums(root.left, temp, answer);
        }
        if(root.right != null){
            branchSums(root.right, temp, answer);
        }
        temp.remove(temp.size()-1);
    }

    public List<Integer> branchSumsII(BinaryTree root){
        List<Integer> sums = new ArrayList<>();
        calculateBranchSums(root, 0, sums);
        return sums;
    }

    private void calculateBranchSums(BinaryTree root, int runningSum, List<Integer> sums) {
        if(root== null)
            return;

        int newRunningSum = runningSum + root.value;
        if(root.left != null && root.right != null){
            sums.add(newRunningSum);
            return;
        }

        calculateBranchSums(root.left, newRunningSum, sums);
        calculateBranchSums(root.right, newRunningSum, sums);

    }
}

