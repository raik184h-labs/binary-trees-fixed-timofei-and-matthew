package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Describes binary search nodes.
 */
class BinarySearchNode {
    protected BinarySearchNode parent;
    protected BinarySearchNode leftChild;
    protected BinarySearchNode rightChild;
    protected Person person;

    /**
     * Constructor
     * @param person data for node.
     */
    BinarySearchNode(Person person) {
        this.person = person;
    }

    /**
     * Inserts data in a tree
     * @param data data to be inserted
     * @return if it got inserted.
     */
    boolean insert(Person data) {
        // If this data is already in tree then no insertion.
        if (data == this.person) {
            return false;
        }
        // Checks where to insert
        else if (Integer.compare(data.key, person.key) < 0) {
            // if there is no left child then insert as left child
            if (leftChild == null) {
                setLeftChild(new BinarySearchNode(data));
                return true;
            } // recursively call insert if there is a left child
            else {
                return leftChild.insert(data);
            }
        }
        // Checks where to insert
        else if (Integer.compare(data.key, person.key) > 0) {
            // if there is no right child then insert as right child
            if (rightChild == null) {
                setRightChild(new BinarySearchNode(data));
                return true;
            } // recursively call insert if there is a left child
            else {
                return rightChild.insert(data);
            }
        }
        return false;
    }

    /**
     * Searches for key
     * @param key key searched
     * @return if found
     */
    BinarySearchNode search(int key) {
        // recursively call if there is a left child
        if (leftChild != null && Integer.compare(key, person.key) < 0) {
            return leftChild.search(key);
        }
        // recursively call if there is a right child
        else if (rightChild != null && Integer.compare(key, person.key) > 0) {
            return rightChild.search(key);
        }
        // returns this node if it is the key
        else if (this.person.key == key) {
            return this;
        }
        // returns nothing if not found
        else {
            return null;
        }
    }

    /**
     * deletes key
     * @param key key to be deleted.
     * @return if deleted.
     */
    Person delete(int key) {
        // checks if there is a node with that key
        BinarySearchNode node = search(key);
        if (node == null)
            return null;
        Person deleted = node.person;

        // checks if the deleted node is a leaf.
        if (node.leftChild == null && node.rightChild == null) {
            if (node.parent.leftChild == node)
                node.parent.setLeftChild(null);
            else if (node.parent.rightChild == node)
                node.parent.setRightChild(null);
        }
        // checks if the deleted node has two childern
        else if (node.leftChild != null && node.rightChild != null) {
            BinarySearchNode min = node.rightChild.getNodeWithMinValue();
            node.person = min.person;
            int minKey = min.person.key;
            min.delete(minKey);
        }
        // checks if the node has left child
        else if (node.parent.leftChild == node) {
            BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setLeftChild(newLeftChild);
        }
        // checks if the node has right child
        else if (node.parent.rightChild == node) {
            BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setRightChild(newRightChild);
        }

        return deleted;
    }

    /**
     * gets node with min value
     * @return returns node with min value.
     */
    BinarySearchNode getNodeWithMinValue() {
        if (leftChild == null)
            return this;
        else
            return leftChild.getNodeWithMinValue();
    }

    /**
     * sets left child
     * @param child child to be set.
     */
    void setLeftChild(BinarySearchNode child) {
        this.leftChild = child;
        if (child != null)
            child.parent = this;
    }

    /**
     * sets right child
     * @param child child to be set.
     */
    void setRightChild(BinarySearchNode child) {
        this.rightChild = child;
        if (child != null)
            child.parent = this;
    }

    /**
     * It makes a string of the node. Uses in order traversal.
     */
    public String toString() {
        String toReturn = "";
        
        // Makes node data into string.
        toReturn += "  " + person.toString() + "\n";

        return toReturn;
    }

}