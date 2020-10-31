package binarysearch;

/**
 * 374. Guess Number Higher or Lower
 */
public class GuessNumberHigherOrLower {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
     * Memory Usage: 37.7 MB, less than 7.55% of Java online submissions for Guess Number Higher or Lower.
     */
    public int guessNumber(int n) {
        long lo = 1, hi = n;
        do {
            int mid = (int) ((lo + hi) / 2);
            int answer = guess(mid);
            if (answer == 0) {
                return mid;
            }
            if (answer == 1) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        } while (lo <= hi);
        return 0;
    }

    private int guess(int n) {
        return 0;
    }
}
