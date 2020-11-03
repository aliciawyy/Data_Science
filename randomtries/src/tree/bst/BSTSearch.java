package tree.bst;

/**
 * 700. Search in a Binary Search Tree
 * Runtime: 0 ms
 * Memory Usage: 39.2 MB
 */
public class BSTSearch {
    public TreeNode searchBST(TreeNode root, int val) {
        return (root == null || root.val == val) ?
                root :
                searchBST(root.val > val ? root.left : root.right, val);
    }
}
