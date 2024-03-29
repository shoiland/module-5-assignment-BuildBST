import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null){
            throw new IllegalArgumentException();
        }
        root = recursionAdd(root, data);

    }

    private BSTNode<T> recursionAdd(BSTNode<T> current, T data){
        if (current == null) {
            this.size++;
            return new BSTNode<>(data);
        } else if (current.getData().compareTo(data) > 0){
            current.setLeft(recursionAdd(current.getLeft(), data));
        } else if (current.getData().compareTo(data) < 0){
            current.setRight(recursionAdd(current.getRight(), data));
        }
        return current;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)
        if (data == null){
            throw new IllegalArgumentException();
        }
        BSTNode<T> dummy = new BSTNode<>(data);
        root = recursionRemove(root, data, dummy);
        if (dummy.getData() == null){
            throw new NoSuchElementException();
        }
        return dummy.getData();
    }

    private BSTNode<T> recursionRemove(BSTNode<T> current, T data, BSTNode<T> dummy){
        if (current == null){
            dummy.setData(null);
            return null;
        } else if (current.getData().compareTo(data) > 0){
            current.setLeft(recursionRemove(current.getLeft(), data, dummy));
        } else if (current.getData().compareTo(data) < 0){
            current.setRight(recursionRemove(current.getRight(), data, dummy));
        } else {
            dummy.setData(current.getData());
            size--;
            if (current.getRight() == null && current.getLeft() == null){
                return null;
            } else if (current.getLeft() != null && current.getRight() == null){
                return current.getLeft();
            } else if (current.getRight() != null && current.getLeft() == null){
                return current.getRight();
            } else {
                BSTNode<T> dummy2 = new BSTNode<>(data);
                current.setRight(removeSuccessor(current.getRight(), dummy2));
                current.setData(dummy2.getData());
            }
        }
        return current;
    }

    private BSTNode<T> removeSuccessor(BSTNode<T> curr, BSTNode<T> dummy){
        if (curr.getLeft() != null){
            curr.setLeft(removeSuccessor(curr.getLeft(), dummy));
        } else {
            dummy.setData(curr.getData());
            return curr.getRight();
        }
        return curr;
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

}