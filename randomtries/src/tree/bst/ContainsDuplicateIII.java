package tree.bst;

import java.util.TreeSet;
import java.util.function.BiPredicate;

/**
 * 220. Contains Duplicate III
 */
public class ContainsDuplicateIII {
    /**
     * Runtime: 24 ms, faster than 58.26% of Java online submissions for Contains Duplicate III.
     * Memory Usage: 40.2 MB, less than 6.82% of Java online submissions for Contains Duplicate III.
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        final int n = nums.length;
        if (n == 0 || k == 0) {
            return false;
        }
        TreeSet<Integer> tree = new TreeSet<>();
        BiPredicate<Integer, Integer> abs = (x, y) -> Math.abs(((long) (int) x) -  ((long) (int) y)) <= t;

        for (int i = 0; i < n && i < k; ++i) {
            if (!tree.add(nums[i])) {
                return true;
            }
        }
        var prev = tree.first();
        for (var num: tree) {
            if (prev != num && abs.test(num, prev)) {
                return true;
            }
            prev = num;
        }
        for (int i = 0, j = k; j < n; ++i, ++j) {
            var floor = tree.floor(nums[j]);
            if (floor != null && abs.test(floor, nums[j])) {
                return true;
            }
            var ceiling = tree.ceiling(nums[j]);
            if (ceiling != null && abs.test(ceiling, nums[j])) {
                return true;
            }
            tree.remove(nums[i]);
            tree.add(nums[j]);
        }
        return false;
    }

    public static void main(String[] args) {
        var solver = new ContainsDuplicateIII();
        System.out.println("1/ Expected: false Actual:" + solver.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
        System.out.println("2/ Expected: true Actual:" + solver.containsNearbyAlmostDuplicate(new int[]{1,5,9,1}, 3, 0));
    }
}
