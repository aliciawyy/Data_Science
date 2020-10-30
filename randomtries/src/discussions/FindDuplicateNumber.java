package discussions;

import java.util.BitSet;

/**
 * 287. Find the Duplicate Number
 */
public class FindDuplicateNumber {
    /**
     * Runtime: 1 ms, faster than 66.31% of Java online submissions for Find the Duplicate Number.
     * Memory Usage: 39 MB, less than 10.06% of Java online submissions for Find the Duplicate Number.
     */
    public int findDuplicate1(int[] nums) {
        var seen = new BitSet(nums.length);
        for (int num: nums) {
            if (seen.get(num)) {
                return num;
            }
            seen.set(num);
        }
        return -1;
    }

    /**
     * Detects the intersection point by cycle.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
     * Memory Usage: 38.9 MB, less than 10.06% of Java online submissions for Find the Duplicate Number.
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        var FDN = new FindDuplicateNumber();
        System.out.println("Expected: 2 Actual: " + FDN.findDuplicate(new int[]{2,2,2,2,2}));
        System.out.println("Expected: 2 Actual: " + FDN.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
