package binarysearchtrees;

public class BasicOperations {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            if (this.value <= value) {
                if (right == null) {
                    BST newBST = new BST(value);
                    right = newBST;
                } else {
                    right.insert(value);
                }

                // insert on right side
            } else if (this.value > value) {
                // insert on left side
                if (left == null) {
                    BST bst = new BST(value);
                    left = bst;
                } else {
                    left.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            // Write your code here.
            if (value < this.value) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else if (value > this.value) {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }

            } else {
                return true;
            }

        }

        public BST remove(int value) {
            // Write your code here.
            // Do not edit the return statement of this method.
            remove(value, null);
            return this;
        }

        public void remove(int value, BST parent) {
            if (value < this.value) {
                if (left != null)
                    left.remove(value, this);
            } else if (value > this.value) {
                if (right != null) {
                    right.remove(value, this);
                }
            } else {
                // if both are non null
                if (left != null && right != null) {
                    this.value = right.getMinValue();
                    right.remove(this.value, this);
                } else if (parent == null) {
                    if (left != null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null) {
                        this.value = right.value;
                        ;
                        left = right.left;
                        right = right.right;
                    } else {
                        // This is a single node tree do nothing
                    }
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }
            }
        }

        private int getMinValue() {
            if (left == null)
                return this.value;
            else
                return left.getMinValue();
        }
    }
}
