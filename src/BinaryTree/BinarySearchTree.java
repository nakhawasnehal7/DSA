package BinaryTree;

import static java.lang.Math.max;

public class BinarySearchTree {
    BinaryNodeInt root;

    BinarySearchTree() {
        root = null;
    }

    // Insert Method
    private BinaryNodeInt insert(BinaryNodeInt currentNode, int value) {
        if (currentNode == null) {
            BinaryNodeInt newNode = new BinaryNodeInt();
            newNode.value = value;
            // System.out.println("The value successfully inserted");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }


    public void preOrder(BinaryNodeInt node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }


    public static int getHeight(BinaryNodeInt node) {

        if (node == null) {
            return -1;
        }

        
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        System.out.println("Left "+left);
        System.out.println("right "+right);
        return 1 + max(left, right);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(7);
        tree.insert(8);
        tree.insert(6);
        tree.insert(6);
        tree.insert(6);
        tree.insert(6);
//        tree.insert(7);
        tree.preOrder(tree.root);
        System.out.println("Height "+getHeight(tree.root));
    }

}
