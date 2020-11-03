package tree.bst;

import java.util.ArrayDeque;

/**
 * Binary Search Tree Iterator
 * Runtime: 15 ms
 * Memory Usage: 44.2 MB
 */
class BSTIterator {

    private final ArrayDeque<TreeNode> mStack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        addLeftBranch(root);
    }

    /** @return the next smallest number */
    public int next() {
        var node = mStack.pollLast();
        if (node.right != null) {
            addLeftBranch(node.right);
        }
        return node.val;

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !mStack.isEmpty();
    }

    private void addLeftBranch(TreeNode node) {
        while (node != null) {
            mStack.addLast(node);
            node = node.left;
        }
    }
}
