package edu.unl.raikes.BinarySearchTreeLab;

import java.util.ArrayList;
import java.util.List;

//TODO: ADD JAVADOC COMMENT
public class BinarySearchTree {
    boolean verbose = true;
    private BinarySearchNode root = null;
    private int size = 0;

    // TODO: ADD JAVADOC COMMENT
    public void insert(Person data) {
        boolean inserted = false;
        // TODO: ADD COMMENT
        if (root == null) {
            root = new BinarySearchNode(data);
            inserted = true;
        } // TODO: ADD COMMENT
        else {
            inserted = root.insert(data);
        } // TODO: ADD COMMENT
        if (inserted) {
            size++;
        }
    }

    // TODO: ADD JAVADOC COMMENT
    public Person search(int key) {
        // TODO: ADD COMMENT
        if (root == null) {
            return null;
        }
        // TODO: ADD COMMENT
        BinarySearchNode found = root.search(key);
        // TODO: ADD COMMENT
        if (found != null) {
            return found.person;
        } else {
            return null;
        }

    }

    // TODO: ADD JAVADOC COMMENT
    public Person delete(int key) {
        Person deleted = null;

        // TODO: ADD COMMENT
        if (root == null) {
            return null;
        } // TODO: ADD COMMENT
        else {
            // TODO: ADD COMMENT
            if (root.person.key == key) {
                // add fake root in case the element to be removed is the root.
                // (simplifies pointer logic)
                BinarySearchNode auxRoot = new BinarySearchNode(null);
                auxRoot.setLeftChild(root);
                // TODO: ADD COMMENT
                deleted = root.delete(key);
                // retrieve the root from the fake root (in case it changed)
                root = auxRoot.leftChild;
                // TODO: ADD COMMENT
                if (root != null)
                    root.parent = null;
            } // TODO: ADD COMMENT
            else {
                deleted = root.delete(key);
            } // TODO: ADD COMMENT
            if (deleted != null)
                size--;
            return deleted;
        }
    }

    private List<BinarySearchNode> inOrderTraversal() {
        List<BinarySearchNode> nodes = new ArrayList<>();
        if (this.root != null) {
            this.inOrderTraversal(this.root, nodes);
        }
        return nodes;
    }

    private void inOrderTraversal(BinarySearchNode node, List<BinarySearchNode> nodes) {
        if (node.leftChild != null) {
            this.inOrderTraversal(node.leftChild, nodes);
        }

        nodes.add(node);

        if (node.rightChild != null) {
            this.inOrderTraversal(node.rightChild, nodes);
        }

        
    }



    // TODO: ADD JAVADOC COMMENT
    public String toString() {
        String toReturn = "Binary Search Tree of Size: " + size + "\n";
        List<BinarySearchNode> nodes = this.inOrderTraversal();
        // TODO: ADD COMMENT
        StringBuilder sb = new StringBuilder();
        sb.append(toReturn);
        for (BinarySearchNode node : nodes) {
            sb.append(node.toString());
        }
        return sb.toString();
    }

}
