package tree.bst;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
 * Memory Usage: 38.7 MB, less than 9.14% of Java online submissions for Convert Sorted Array to Binary Search Tree.
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        return new TreeNode(nums[mid], toBST(nums, start, mid - 1), toBST(nums, mid + 1, end));
    }
}
