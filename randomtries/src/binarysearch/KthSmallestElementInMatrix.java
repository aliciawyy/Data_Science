package binarysearch;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 378. Kth Smallest Element in a Sorted Matrix
 */
public class KthSmallestElementInMatrix {

    private int m;
    private int n;
    private int[][] mMatrix;

    /**
     * Binary Search implementation.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
     * Memory Usage: 44.7 MB, less than 6.46% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
     */
    public int kthSmallest(int[][] matrix, int k) {
        mMatrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        if (m == 1) {
            return matrix[0][k - 1];
        }
        if (n == 1) {
            return matrix[k - 1][0];
        }
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1], mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            int count = countLessThan(mid);
            if (count < k) {
                // Answer should be in the range (mid + 1, hi)
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }

    private int countLessThan(int target) {
        int count = 0;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (mMatrix[i][j] >= target) {
                --i;
            } else if (mMatrix[i][j] < target) {
                count += i + 1;
                ++j;
            }
        }
        return count;
    }

    /**
     * Implementation with Priority Queue.
     * Runtime: 37 ms, faster than 5.30% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
     * Memory Usage: 44.4 MB, less than 6.78% of Java online submissions for Kth Smallest Element in a Sorted Matrix.
     */
    public int kthSmallest1(int[][] matrix, int k) {
        final int m = matrix.length, n = matrix[0].length;
        final PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparing(x -> x.get(0)));
        pq.add(List.of(matrix[0][0], 0, 0));
        int count = 1;
        boolean[][] seen = new boolean[m][n];
        while (count < k) {
            var item = pq.poll();
            int i = item.get(1), j = item.get(2), iNext = i + 1, jNext = j + 1;
            if (iNext < m && !seen[iNext][j]) {
                seen[iNext][j] = true;
                pq.add(List.of(matrix[iNext][j], iNext, j));
            }
            if (jNext < n && !seen[i][jNext]) {
                seen[i][jNext] = true;
                pq.add(List.of(matrix[i][jNext], i, jNext));
            }
            ++count;
        }
        return pq.poll().get(0);
    }


}
