package tree.bst;

/**
 * 98. Validate Binary Search Tree
 */
public class ValidBST {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 38.6 MB, less than 10.29% of Java online submissions for Validate Binary Search Tree.
     */
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    private boolean check(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }
}
