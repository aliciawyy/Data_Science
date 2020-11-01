package discussions;

import java.util.*;

/**
 * 373. Find K Pairs with Smallest Sums
 */
public class FindKParisWithSmallestSum {

    /**
     * Priority queue implementation
     * Runtime: 5 ms, faster than 64.97% of Java online submissions for Find K Pairs with Smallest Sums.
     * Memory Usage: 39.8 MB, less than 5.15% of Java online submissions for Find K Pairs with Smallest Sums.
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(a -> a.get(0)));
        int m = nums1.length, n = nums2.length;
        if (m == 0 || n == 0) {
            return result;
        }
        boolean[][] seen = new boolean[m][n];
        pq.add(List.of(nums1[0] + nums2[0], 0, 0));
        while (!pq.isEmpty() && result.size() < k) {
            var entry = pq.poll();
            int i = entry.get(1), j = entry.get(2);
            result.add(List.of(nums1[i], nums2[j]));
            int iNext = i + 1, jNext = j + 1;
            if (iNext < m && !seen[iNext][j]) {
                seen[iNext][j] = true;
                pq.add(List.of(nums1[iNext] + nums2[j], iNext, j));
            }
            if (jNext < n && !seen[i][jNext]) {
                seen[i][jNext] = true;
                pq.add(List.of(nums1[i] + nums2[jNext], i, jNext));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var problem = new FindKParisWithSmallestSum();
        System.out.println("4/ Expected: [[34,801],[34,933],[34,1093],[34,1498],[774,801],[774,933],[774,1093],[774,1498],[34,2384],[1640,801]]");
        System.out.println("4/ Actual: " + problem.kSmallestPairs(new int[]{34,774,1640,1814,2364}, new int[] {801,933,1093,1498,2384,2665}, 10));
        System.out.println("1/ Expected: [[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]");
        System.out.println("1/ Actual: " + problem.kSmallestPairs(new int[]{1,1,2}, new int[] {1,2,3}, 10));
        System.out.println("2/ Expected: [] Actual: " + problem.kSmallestPairs(new int[]{}, new int[] {1,2,3,5}, 10));
        System.out.println("3/ Expected: [[1,3],[2,3],[1,5]] Actual: " + problem.kSmallestPairs(new int[]{1,2,4,5,6}, new int[] {3,5,7,9}, 3));
    }
}
