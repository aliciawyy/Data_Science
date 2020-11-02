package discussions;

import java.util.ArrayList;
import java.util.List;

/**
 * 279. Perfect Squares
 */
public class PerfectSquare {
    private int[] mCount;
    private List<Integer> mSquares;

    public int numSquares(int n) {
        if (n < 4) {
            return n;
        }
        mCount = new int[n + 1];
        mSquares = new ArrayList<>();
        int i = 1, sq = 1;
        while (sq < n) {
            mSquares.add(sq);
            mCount[sq] = 1;
            ++i;
            sq = i * i;
        }
        if (sq == n) {
            return 1;
        }
        return numSquaresInternal(n);
    }

    /**
     * Runtime: 14 ms, faster than 94.16% of Java online submissions for Perfect Squares.
     * Memory Usage: 37.9 MB, less than 5.62% of Java online submissions for Perfect Squares.
     */
    private int numSquaresInternal(int n) {
        if (mCount[n] != 0 || n == 0) {
            return mCount[n];
        }
        int min = n, current;
        for (int num: mSquares) {
            if (num < n) {
                current = numSquaresInternal(n % num) + n / num;
                if (current < min) {
                    min = current;
                }
            } else {
                break;
            }
        }
        mCount[n] = min;
        return min;
    }

    public static void main(String[] args) {
        var solver = new PerfectSquare();
        System.out.println("Actual: " + solver.numSquares(7168));
    }
}
