package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * LeetCode. 494. Target Sum
 */
public class TargetSum {
    private int[] mNums;
    private int n;
    private HashMap<Integer, Integer>[] mCache;

    /**
     * Simple Recursion.
     * Runtime: 494 ms, faster than 19.95% of Java online submissions for Target Sum.
     * Memory Usage: 36.3 MB, less than 5.32% of Java online submissions for Target Sum.
     *
     * Recursion with Cache.
     * Runtime: 31 ms, faster than 59.08% of Java online submissions for Target Sum.
     * Memory Usage: 39.6 MB, less than 5.32% of Java online submissions for Target Sum.
     */
    public int findTargetSumWays(int[] nums, int S) {
        mNums = nums;
        n = nums.length;
        mCache = new HashMap[n];
        for (int i = 0; i < n; ++i) {
            mCache[i] = new HashMap<Integer, Integer>();
        }
        return search(0, S);
    }

    private int search(int k, int target) {
        if (k == n) {
            return target == 0 ? 1 : 0;
        }
        var res = mCache[k].get(target);
        if (res == null) {
            res = search(k + 1, target + mNums[k]) + search(k + 1, target - mNums[k]);
            mCache[k].put(target, res);
        }
        return res;
    }

    public static void main(String[] args) {
        var solver = new TargetSum();
        System.out.println("1/ Expected 5, Actual " + solver.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }
}
