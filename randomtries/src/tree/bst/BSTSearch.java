package tree.bst;

/**
 * Search in a Binary Search Tree
 * Runtime: 0 ms
 * Memory Usage: 39.2 MB
 */
public class BSTSearch {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        } else {
            return searchBST(root.val > val ? root.left : root.right, val);
        }
    }
}
