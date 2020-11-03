package tree.bst;

import java.util.AbstractMap;

/**
 * 110. Balanced Binary Tree
 * Runtime: 1 ms, faster than 48.45% of Java online submissions for Balanced Binary Tree.
 * Memory Usage: 39.3 MB, less than 10.04% of Java online submissions for Balanced Binary Tree.
 */
public class BalancedBST {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root).getValue();
    }

    private AbstractMap.SimpleImmutableEntry<Integer, Boolean> getHeight(TreeNode node) {
        if (node == null) {
            return new AbstractMap.SimpleImmutableEntry<>(0, true);
        }
        var left = getHeight(node.left);
        if (!left.getValue()) {
            return new AbstractMap.SimpleImmutableEntry<>(-1, false);
        }
        var right = getHeight(node.right);
        if (!right.getValue()) {
            return new AbstractMap.SimpleImmutableEntry<>(-1, false);
        }
        if (Math.abs(left.getKey() - right.getKey()) > 1) {
            return new AbstractMap.SimpleImmutableEntry<>(-1, false);
        }
        return new AbstractMap.SimpleImmutableEntry<>(Math.max(left.getKey(), right.getKey()) + 1, true);
    }
}
