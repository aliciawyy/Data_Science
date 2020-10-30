package discussions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 36.8 MB, less than 5.01% of Java online submissions for Longest Increasing Subsequence.
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] increasingArr = new int[nums.length];
        int n = 0;
        for (int num: nums) {
            int k = Arrays.binarySearch(increasingArr, 0, n, num);
            if (k >= 0) {
                continue;
            }
            k = - (k + 1);
            increasingArr[k] = num;
            if (k == n) {
                ++n;
            }
        }
        return n;
    }

    /**
     * Runtime: 9 ms, faster than 71.87% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 36.8 MB, less than 5.01% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 36.8 MB, less than 5.01% of Java online submissions for Longest Increasing Subsequence.
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] lengthOfLongestIncludeK = new int[nums.length];
        lengthOfLongestIncludeK[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; ++i) {
            int currentMax = 0;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] < nums[i] && lengthOfLongestIncludeK[j] > currentMax) {
                    currentMax = lengthOfLongestIncludeK[j];
                }
            }
            lengthOfLongestIncludeK[i] = currentMax + 1;
            if (lengthOfLongestIncludeK[i] > max) {
                max = lengthOfLongestIncludeK[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var LIS = new LongestIncreasingSubsequence();
        System.out.println("1/ Expected: 6 Actual: " + LIS.lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
        System.out.println("2/ Expected: 4 Actual: " + LIS.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }

}
