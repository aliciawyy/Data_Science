package tree.bst;

/**
 * 450. Delete Node in a BST
 */
public class BSTDeletion {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
     * Memory Usage: 39.4 MB, less than 7.65% of Java online submissions for Delete Node in a BST.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val == key) {
            var node = root.right;
            if (node == null) {
                return root.left;
             } else if (node.left == null) {
                // root's right node is the smallest above root
                node.left = root.left;
                return node;
            }
            TreeNode parent;
            do {
                // Find the parent of the smallest node.
                parent = node;
                node = node.left;
            } while (node.left != null);
            parent.left = node.right;
            node.left = root.left;
            node.right = root.right;
            return node;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
