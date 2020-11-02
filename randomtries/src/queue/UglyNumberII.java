package queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 264. Ugly Number II
 */
public class UglyNumberII {

    private static final long[] FACTORS = new long[] {2, 3, 5};

    /**
     * Runtime: 56 ms, faster than 22.31% of Java online submissions for Ugly Number II.
     * Memory Usage: 38.8 MB, less than 8.52% of Java online submissions for Ugly Number II.
     */
    public int nthUglyNumber(int n) {
        if (n <= 6) {
            return n;
        }
        TreeSet<Long> tree = new TreeSet<>();
        tree.add(1L);
        for ( ;n > 1; --n) {
            var key = tree.first();
            tree.remove(key);
            tree.add(key * 2L);
            tree.add(key * 3L);
            tree.add(key * 5L);
        }
        return (int) (long) tree.first();
    }

    /**
     * Priority queue.
     * Runtime: 55 ms, faster than 22.66% of Java online submissions for Ugly Number II.
     * Memory Usage: 39 MB, less than 8.52% of Java online submissions for Ugly Number II.
     */
    public int nthUglyNumberWithPriorityQueue(int n) {
        if (n <= 6) {
            return n;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (var factor: FACTORS) {
            pq.add(factor);
        }
        HashSet<Long> seen = new HashSet<>(pq);
        --n;
        while (n > 1) {
            var key = pq.poll();
            seen.remove(key);
            for (var factor: FACTORS) {
                long value = key * factor;
                if (!seen.contains(value)) {
                    seen.add(value);
                    pq.add(value);
                }
            }
            --n;
        }
        return (int) (long) pq.poll();
    }

    public static void main(String[] args) {
        var solver = new UglyNumberII();

        System.out.println("2/ Expected: 36 Actual: " + solver.nthUglyNumber(20));
        System.out.println("1/ Expected: 12 Actual: " + solver.nthUglyNumber(10));
    }
}
