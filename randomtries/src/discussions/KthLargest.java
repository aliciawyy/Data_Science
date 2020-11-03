package discussions;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * Runtime: 16 ms, faster than 69.94% of Java online submissions for Kth Largest Element in a Stream.
 * Memory Usage: 44.4 MB, less than 9.20% of Java online submissions for Kth Largest Element in a Stream.
 */
public class KthLargest {
    private final PriorityQueue<Integer> mPQ;
    private final int mCapacity;

    public KthLargest(int k, int[] nums) {
        mCapacity = k;
        mPQ = new PriorityQueue<>(k + 1);
        for (int i = 0; i < k && i < nums.length; ++i) {
            mPQ.add(nums[i]);
        }
        for (int i = k; i < nums.length; ++i) {
            mPQ.add(nums[i]);
            mPQ.poll();
        }

    }

    public int add(int val) {
        mPQ.add(val);
        if (mPQ.size() > mCapacity) {
            mPQ.poll();
        }
        return mPQ.peek();
    }
}
