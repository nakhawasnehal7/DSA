package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {

    public static BinaryNode root;

    BinaryTreeLL(BinaryNode root) {
        this.root = null;
    }


    public void insert(String value) {
        BinaryNode node = new BinaryNode();
        node.value = value;
        if (root == null) {
            root = node;
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.remove();
            if (current.left == null) {
                current.left = node;
                break;
            } else if (current.right == null) {
                current.right = node;
                break;
            } else {
                queue.add(current.left);
                queue.add(current.right);
            }

        }
    }

    // Post Order Traversal
    void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }


    public static BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        System.out.println("Get DeepestNode" + presentNode.value);
        return presentNode;
    }


    public void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();

        }

    }

    public static void main(String[] args) {

        BinaryTreeLL binaryTreeLL = new BinaryTreeLL(null);
        binaryTreeLL.insert("A");
        binaryTreeLL.insert("B");
        binaryTreeLL.insert("C");
        binaryTreeLL.insert("D");
        binaryTreeLL.postOrder(binaryTreeLL.root);
        binaryTreeLL.getDeepestNode();


    }
}
