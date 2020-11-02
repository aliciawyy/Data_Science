package segmenttree;

/**
 * 307. Range Sum Query - Mutable
 */
public class RangeSumQueryMutable {

    /**
     * Segment tree implementation.
     * Runtime: 10 ms, faster than 82.74% of Java online submissions for Range Sum Query - Mutable.
     * Memory Usage: 45.1 MB, less than 10.58% of Java online submissions for Range Sum Query - Mutable.
     */
    class NumArray {
        private int n;
        private int[] mSegmentTree;

        public NumArray(int[] nums) {
            n = nums.length;
            if (n == 0) {
                return;
            }
            mSegmentTree = new int[n * 2];
            for (int i = n, j = 0; j < n; ++i, ++j) {
                mSegmentTree[i] = nums[j];
            }
            for (int i = n - 1; i > 0; --i) {
                // Root is the 1st element, the 0th element is not used.
                mSegmentTree[i] = mSegmentTree[i * 2] + mSegmentTree[i * 2 + 1];
            }
        }

        public void update(int i, int val) {
            int k = n + i;
            int diff = val - mSegmentTree[k];
            while (k != 0) {
                // Update all the tree nodes impacted by the kth element
                mSegmentTree[k] += diff;
                k /= 2;
            }
            mSegmentTree[0] += diff;
        }

        public int sumRange(int i, int j) {
            // The index of left node should be 2 * k and right node should be 2 * k + 1
            int sum = 0;
            i += n;
            j += n;
            while (i <= j && i != 0) {
                if (i % 2 == 1) {
                    // if index is odd, move it forward since
                    // if the left node contains range [L_1, R_1] and right node contains [L_2, R_2]
                    // then R_1 < L_2 inside one while loop
                    sum += mSegmentTree[i];
                    ++i;
                }
                if (j % 2 == 0) {
                    sum += mSegmentTree[j];
                    --j;
                }
                i /= 2;
                j /= 2;
            }
            return sum;
        }
    }

    /**
     * Runtime: 137 ms, faster than 18.28% of Java online submissions for Range Sum Query - Mutable.
     * Memory Usage: 45.2 MB, less than 10.58% of Java online submissions for Range Sum Query - Mutable.
     */
    class NumArrayBruteForce {
        private int[] mNums;
        private int[] mRunningSum;

        public NumArrayBruteForce(int[] nums) {
            mNums = nums;
            mRunningSum = new int[nums.length];
            int runningSum = 0;
            for (int i = 0; i < nums.length; ++i) {
                runningSum += nums[i];
                mRunningSum[i] = runningSum;
            }
        }

        public void update(int i, int val) {
            int diff = val - mNums[i];
            mNums[i] = val;
            if (diff != 0) {
                for (int j = i; j < mRunningSum.length; ++j) {
                    mRunningSum[j] += diff;
                }
            }
        }

        public int sumRange(int i, int j) {
            return mRunningSum[j] - (i > 0? mRunningSum[i - 1]: 0);
        }
    }
}
