package binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

public class RecOnstructFromPreOrder {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>();
        lst.add(10);
        lst.add(4);
        lst.add(2);
        lst.add(1);
        lst.add(5);
        lst.add(17);
        lst.add(19);
        lst.add(18);
        RecOnstructFromPreOrder rs = new RecOnstructFromPreOrder();
        rs.reconstructBst(lst);
    }
    public BST reconstructBst(List<Integer> preOrderTraversalValues) {
        // Write your code here.
        return res(preOrderTraversalValues);
    }

    BST res(List<Integer> preOrderTraversalValues){
        if(preOrderTraversalValues.size() ==0 )
            return null;
        if(preOrderTraversalValues.size() ==1 )
            return new BST(preOrderTraversalValues.get(0));

        BST node = new BST(preOrderTraversalValues.get(0));
        int i =1;
        while (i < preOrderTraversalValues.size() && preOrderTraversalValues.get(i) < node.value){
            i++;
        }
        node.left = res(preOrderTraversalValues.subList(1, i));
        node.right = res(preOrderTraversalValues.subList(i, preOrderTraversalValues.size()));
        return node;
    }
}

