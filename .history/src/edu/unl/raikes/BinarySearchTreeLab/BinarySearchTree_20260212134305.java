package edu.unl.raikes.BinarySearchTreeLab;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for binary search tree.
 */
public class BinarySearchTree {
    boolean verbose = true;
    private BinarySearchNode root = null;
    private int size = 0;

    /**
     * Inserts data into tree.
     * @param data data to be inserted.
     */
    public void insert(Person data) {
        boolean inserted = false;
        // Creates new tree if there wasn't one.
        if (root == null) {
            root = new BinarySearchNode(data);
            inserted = true;
        } // Inserts data if there is a tree
        else {
            inserted = root.insert(data);
        } // Increments size if there is a insert.
        if (inserted) {
            size++;
        } else {
            System.out.println("Already exists, no insert.");
        }
    }

    /**
     * Finds the key's value.
     * @param key key of value we're searching for.
     * @return value of key we're searching
     */
    public Person search(int key) {
        // Checks if there is a tree
        if (root == null) {
            return null;
        }
        // Stores the found key
        BinarySearchNode found = root.search(key);
        // Gets the keys value if its found
        if (found != null) {
            return found.person;
        } else {
            System.out.println("Node was not found.");
            return null;
        }

    }

    /**
     * Deletes the key if its in the tree
     * @param key key being deleted
     * @return the deleted key
     */
    public Person delete(int key) {
        Person deleted = null;

        // Checks if theres a tree.
        if (root == null) {
            return null;
        } //Starts the deletion process.
        else {
            // Checks if the current key is the key we're looking for.
            if (root.person.key == key) {
                // add fake root in case the element to be removed is the root.
                // (simplifies pointer logic)
                BinarySearchNode auxRoot = new BinarySearchNode(null);
                auxRoot.setLeftChild(root);
                // Keeps track of the deleted key.
                deleted = root.delete(key);
                // retrieve the root from the fake root (in case it changed)
                root = auxRoot.leftChild;
                // If the root is not null, set the parent to null.
                if (root != null)
                    root.parent = null;
            } // Deletes the fake key if the key is not the one we're looking for.
            else {
                deleted = root.delete(key);
            } // Decrements the size of the tree if the key is deleted.
            if (deleted != null) {
                size--;
            } else {
                System.out.println("Key was not found in the tree (No deletion).");
            }

            return deleted;
        }
    }

    /**
     * Performs an in order traversal and returns the list of nodes.
     * @return the list of nodes in order.
     */
    private List<BinarySearchNode> inOrderTraversal() {
        List<BinarySearchNode> nodes = new ArrayList<>();
        if (this.root != null) {
            this.inOrderTraversal(this.root, nodes);
        }
        return nodes;
    }

    /**
     * Performs an in order traversal recursively and adds the nodes to the list.
     * @param node the current node being visited.
     * @param nodes the list of nodes to add to.
     */
    private void inOrderTraversal(BinarySearchNode node, List<BinarySearchNode> nodes) {
        if (node.leftChild != null) {
            this.inOrderTraversal(node.leftChild, nodes);
        }

        nodes.add(node);

        if (node.rightChild != null) {
            this.inOrderTraversal(node.rightChild, nodes);
        }

        
    }



    /**
     * Returns a string representation of this binary search tree.
     * @return a string representation of this binary search tree.
     */
    public String toString() {
        String toReturn = "Binary Search Tree of Size: " + size + "\n";
        List<BinarySearchNode> nodes = this.inOrderTraversal();
        // Made a string builder that combines all of the nodes in the tree in order.
        StringBuilder sb = new StringBuilder();
        sb.append(toReturn);
        for (BinarySearchNode node : nodes) {
            sb.append(node.toString());
        }
        return sb.toString();
    }

}
