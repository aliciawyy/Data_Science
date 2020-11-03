package tree.bst;

/**
 * 701. Insert into a Binary Search Tree
 */
public class BSTInsertion {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
     * Memory Usage: 40.1 MB, less than 79.55% of Java online submissions for Insert into a Binary Search Tree.
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val, null, null);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
