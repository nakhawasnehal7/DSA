import java.util.Random;
import java.util.Stack;

/**
 * Treap class
 * Implementation of Treap (BST augmented with heap priorities)
 * Node is private static inner class with public
 * rotateRight and rotateLeft are implemented top return new subtree
 * add(E key, int priority) inserts like a BTS (iteratively)
 * delete(E key) finds the node,rotate until leaf and delete it.
 * find() finds the given element
 *
 * @param <E> {E} element
 */
public class Treap<E extends Comparable<E>> {
    /**
     * Private static inner Node class for treap nodes
     *
     * @param <E> {E} the element type store in Node
     */
    private static class Node<E> {
        public E data;
        public int priority;
        public Node<E> left;
        public Node<E> right;

        /***
         * Construct new node with given data and priority.
         * if data is null throw exception
         * @param data {E}
         * @param priority {int} the priority of the element
         */
        public Node(E data, int priority) {
            if (data == null) {
                throw new IllegalArgumentException("The data value is empty.");
            }
            this.data = data;
            this.priority = priority;
            left = right = null;
        }

        /**
         * Performs right rotation on this node
         * (this node is root of subtree)
         * The method updates child pointers and returns the new root
         *
         * @return the new root of the rotated subtree
         */
        public Node<E> rotateRight() {
            Node<E> newRoot = this.left;
            this.left = newRoot.right;
            newRoot.right = this;
            return newRoot;
        }

        /**
         * Performs left rotation on this node
         * (this node is root of subtree)
         * The method updates child pointers and returns the new root
         *
         * @return the new root of the rotated subtree
         */
        public Node<E> rotateLeft() {
            Node<E> newRoot = this.right;
            this.right = newRoot.left;
            newRoot.left = this;
            return newRoot;
        }

        /**
         * Node string representation of the form
         *
         * @return string representation of the node
         */
        @Override
        public String toString() {
            return "[" + data + ", " + priority + "]";
        }
    }


    private Random priorityGenerator;
    private Node<E> root;

    /**
     * Create an empty treap with a default Random
     * priority generator
     */
    public Treap() {
        priorityGenerator = new Random();
        root = null;
    }

    /**
     * Create an empty treap with a Random priority generator
     * initialized using provided seed.
     *
     * @param seed {long}
     */
    public Treap(long seed) {
        priorityGenerator = new Random(seed);
        root = null;
    }

    /**
     * Inserts the given key into the treap, assigning a random priority.
     * If the key is already present, the treap is not modified and method returm false.
     * The method generates random priority and delegates to add(key, priority)
     *
     * @param key {E}
     * @return true if the key is inserted, false if key already exists
     */

    boolean add(E key) {
        int priority = priorityGenerator.nextInt(Integer.MAX_VALUE);
        return add(key, priority);
    }

    /**
     * Inserts the given key into the treap, assigning a random priority.
     * Insert like in a BTS (iteratively).
     * If node with same key exist than return false.
     * After insertion restore the heap invarient by bubbling the new node.
     * until have parents the higher priority .
     * Return boolean value
     *
     * @param key      element {E}
     * @param priority {int}
     * @return {boolean}
     */
    boolean add(E key, int priority) {
        if (key == null) {
            throw new IllegalArgumentException("Data cannot be empty!");
        }
        if (root == null) {
            root = new Node<>(key, priority);
            return true;
        }

        Stack<Node<E>> stack = new Stack<>();
        Node<E> current = root;

        while (true) {
            stack.push(current);
            int cmp = key.compareTo(current.data);

            /**
             * If same priority is added again
             * it return false
             */
            if (cmp == 0) {
                throw new RuntimeException("Duplicate priority added!");
            }

            if (cmp < 0) {
                if (current.left == null) {
                    current.left = new Node<>(key, priority);
                    current = current.left;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node<>(key, priority);
                    current = current.right;
                    break;
                }
                current = current.right;
            }
        }
        reheap(stack, current);
        return true;
    }

    /**
     * Bubble up newNode to restore heap property
     *
     * @param stack   {Stack.Stack<Node<E>>}
     * @param current {Node<E>}
     */
    private void reheap(Stack<Node<E>> stack, Node<E> current) {
        while (!stack.isEmpty()) {
            Node<E> parent = stack.pop();
            if (current.priority > parent.priority) {
                if (parent.left == current) {
                    current = parent.rotateRight();
                } else {
                    current = parent.rotateLeft();

                }
                if (stack.isEmpty()) {
                    root = current;
                } else {
                    Node<E> grand = stack.peek();
                    if (grand.left == parent) {
                        grand.left = current;
                    } else {
                        grand.right = current;
                    }
                }
            } else {
                break;
            }
        }
    }


    /**
     * Remove the Node with the given key from the treap.
     * If key is not found, return false
     * Repeatedly rotate the node to delete with its higher-priority child.
     * to move it down the tree until it become a leaf
     * Finally remove the leaf by setting the appropriate child pointer of its parent.
     *
     * @param key <E> key to be removed
     * @return {boolean} if node is found return true, else false.
     */
    boolean delete(E key) {
        Stack<Node<E>> stack = new Stack<>();
        Node<E> curr = root;
        while (curr != null) {
            int cmp = key.compareTo(curr.data);
            if (cmp == 0) {
                break;
            }
            stack.push(curr);
            curr = (cmp < 0) ? curr.left : curr.right;
        }
        if (curr == null) {
            return false;
        }

        //Rotate
        while (curr.left != null || curr.right != null) {
            Node<E> newSubRoot;
            if (curr.left == null) {
                newSubRoot = curr.rotateLeft();
            } else if (curr.right == null) {
                newSubRoot = curr.rotateRight();
            } else {
                if (curr.left.priority > curr.right.priority) {
                    newSubRoot = curr.rotateRight();
                } else {
                    newSubRoot = curr.rotateLeft();
                }
            }

            if (stack.isEmpty()) {
                root = newSubRoot;
            } else {
                Node<E> parent = stack.peek();
                if (parent.left == curr) {
                    parent.left = newSubRoot;
                } else {
                    parent.right = newSubRoot;
                }
            }
            stack.push(newSubRoot);
        }
        if (stack.isEmpty()) {
            root = null;
        } else {
            Node<E> parent = stack.peek();
            if (parent.left == curr) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        return true;
    }


    /**
     * Find the given key in treap.
     *
     * @param key {E} element to be search
     * @return {boolean} true if value is found.
     */
    boolean find(E key) {
        return find(root, key);
    }


    /**
     * Find Whether a key exist in the treap
     * rooted at the provided node.
     *
     * @param root {Node<E>} the subtree root to start the search
     * @param key  {E} element to be searched
     * @return {boolean} if the key is present in the subTree, false otherwise.
     */
    private boolean find(Node<E> root, E key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (root == null) {
            return false;
        }
        int cmp = key.compareTo(root.data);

        if (cmp == 0) {
            return true;

        } else if (cmp < 0) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }

    /**
     * toString method
     *
     * @return {String} Node of the treap.
     */
    @Override
    public String toString() {
        return toString(root);
    }

    /**
     * helper for toString method
     *
     * @return {String} Node of the treap.
     */
    private String toString(Node<E> node) {
        if (node == null) {
            return null;
        }
        return node.toString() + "(" + toString(node.left) + ") (" + toString(node.right) + ")";
    }

    public static void main(String[] args) {
        /**
         * Add the element into BTS
         */
        Treap<String> treap = new Treap<>(222);
        treap.add("h", 9);
        treap.add("a", 2);
        treap.add("e", 0);
        treap.add("c", 4);
        treap.add("i", 7);
        System.out.println(treap.toString());

        Treap<Integer> treap1 = new Treap<>();
        treap1.add(4, 19);
        treap1.add(2, 31);
        treap1.add(6, 70);
        treap1.add(1, 84);
        treap1.add(3, 12);
        treap1.add(5, 83);
        treap1.add(7, 26);

        System.out.println(treap1.toString());

        /**
         * Delete from Treap
         */

        System.out.println("Deleted the element '4' in teap- " + treap1.delete(4));

        /**
         * Find the element in the Treap
         */
        System.out.println("Found the element 'C' in treap- " + treap.find("c"));


        /**
         * Handle null values
         */
        try {
            System.out.println("Find null value" + treap1.find(null));
        } catch (final Exception ex) {
            ex.getMessage();
        }
        /**
         * Handle null values
         */
        try {
            treap1.add(null, 8);
        } catch (final Exception ex) {
            ex.getMessage();
        }


    }
}
