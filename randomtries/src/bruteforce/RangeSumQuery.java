package bruteforce;

/**
 * 303. Range Sum Query - Immutable
 */
public class RangeSumQuery {

    /**
     * Runtime: 6 ms, faster than 100.00% of Java online submissions for Range Sum Query - Immutable.
     * Memory Usage: 42.1 MB, less than 5.28% of Java online submissions for Range Sum Query - Immutable.
     */
    class NumArray {

        private int[] mRunningSum;

        public NumArray(int[] nums) {
            if (nums.length == 0) {
                return;
            }
            mRunningSum = new int[nums.length];
            int runningSum = 0;
            for (int i = 0; i < nums.length; ++i) {
                runningSum += nums[i];
                mRunningSum[i] = runningSum;
            }
        }

        public int sumRange(int i, int j) {
            int sum = mRunningSum[j];
            if (i > 0) {
                sum -= mRunningSum[i - 1];
            }
            return sum;
        }
    }

    /**
     * Runtime: 63 ms, faster than 16.90% of Java online submissions for Range Sum Query - Immutable.
     * Memory Usage: 43.7 MB, less than 5.28% of Java online submissions for Range Sum Query - Immutable.
     */
    class NumArrayBruteForce {

        private int[] mNums;

        public NumArrayBruteForce(int[] nums) {
            mNums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; ++k) {
                sum += mNums[k];
            }
            return sum;
        }
    }
}
