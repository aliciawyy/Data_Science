package tree;

import java.util.*;

public class BinaryTreeInorder {
    /**
     * Runtime: 1 ms
     * Memory Usage: 37.4 MB
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayDeque<AbstractMap.SimpleImmutableEntry<TreeNode, Boolean>> stack = new ArrayDeque<>();
        stack.addLast(new AbstractMap.SimpleImmutableEntry<>(root, false));
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            var row = stack.pollLast();
            TreeNode node = row.getKey();
            if (node == null) {
                continue;
            }
            if (row.getValue()) {
                result.add(node.val);
                continue;
            }
            stack.add(new AbstractMap.SimpleImmutableEntry<>(node.right, false));
            stack.add(new AbstractMap.SimpleImmutableEntry<>(node, true));
            stack.add(new AbstractMap.SimpleImmutableEntry<>(node.left, false));
        }
        return result;
    }
}
