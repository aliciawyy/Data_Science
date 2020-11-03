package tree.bst;

import java.util.ArrayDeque;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 */
public class LowestCommonAncestor {

    /**
     * Runtime: 4 ms, faster than 53.40% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     * Memory Usage: 39.8 MB, less than 11.37% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
     *
     * Constraints:
     *
     * The number of nodes in the tree is in the range [2, 105].
     * -109 <= Node.val <= 109
     * All Node.val are unique.
     * p != q
     * p and q will exist in the BST
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> pParents = getParents(root, p);
        ArrayDeque<TreeNode> qParents = getParents(root, q);
        while (pParents.size() > qParents.size()) {
            pParents.pollLast();
        }
        while (qParents.size() > pParents.size()) {
            qParents.pollLast();
        }
        while (pParents.size() > 0) {
            TreeNode lastP = pParents.pollLast(), lastQ = qParents.pollLast();
            if (lastP == lastQ) {
                return lastP;
            }
        }
        return root;
    }

    private ArrayDeque<TreeNode> getParents(TreeNode root, TreeNode node) {
        ArrayDeque<TreeNode> parents = new ArrayDeque<>();
        TreeNode current = root;
        do {
            parents.addLast(current);
            if (current.val == node.val) {
                break;
            } else if (current.val < node.val) {
                current = current.right;
            } else {
                current = current.left;
            }
        } while (current != null);
        return parents;
    }
}
