package discussions;

import java.util.*;
import java.util.function.IntBinaryOperator;

public class KthSmallestPairDistance {

    /**
     * Heap.
     * Time Limit Exceeded.
     */
    public int smallestDistancePair(int[] nums, int k) {
        final int n = nums.length;
        IntBinaryOperator distFun = (p, q) -> nums[p] > nums[q] ? nums[p] - nums[q] : nums[q] - nums[p];
        Arrays.sort(nums);
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(x -> x.get(0)));
        for (int i = 0; i < n - 1; ++i) {
            pq.add(List.of(distFun.applyAsInt(i, i + 1), i, i + 1));
        }
        int count = 1;
        while (count < k) {
            var item = pq.poll();
            int i = item.get(1), j = item.get(2), nextJ = j + 1;
            if (nextJ < n) {
                pq.add(List.of(distFun.applyAsInt(i, nextJ), i, nextJ));
            }
            ++count;
        }
        return pq.poll().get(0);
    }

    public static void main(String[] args) {
        var solver = new KthSmallestPairDistance();
        System.out.println("1/ Expected: 0 Actual: " + solver.smallestDistancePair(new int[]{1,3,1}, 1));
    }
}
