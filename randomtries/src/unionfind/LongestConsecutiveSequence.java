package unionfind;

import java.util.HashMap;

/**
 * 128. Longest Consecutive Sequence
 */
public class LongestConsecutiveSequence {
    /**
     * Runtime: 6 ms, faster than 32.16% of Java online submissions for Longest Consecutive Sequence.
     * Memory Usage: 39.9 MB, less than 8.15% of Java online submissions for Longest Consecutive Sequence.
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        HashMap<Integer, Integer[]> prevAndNext = new HashMap<>();
        for (int num: nums) {
            if (prevAndNext.containsKey(num)) {
                continue;
            }
            Integer[] currentPrevAndNext = {num, num};
            Integer numNext = num + 1, numPrev = num - 1;
            if (prevAndNext.containsKey(numNext)) {
                prevAndNext.get(numNext)[0] = num;
                currentPrevAndNext[1] = numNext;
            }
            if (prevAndNext.containsKey(numPrev)) {
                prevAndNext.get(numPrev)[1] = num;
                currentPrevAndNext[0] = numPrev;
            }
            prevAndNext.put(num, currentPrevAndNext);
        }

        int maxCount = 1;
        for (var key: prevAndNext.keySet()) {
            if (prevAndNext.get(key)[0] == null) {
                continue;
            }
            int currentCount = 1;
            Integer cursor = key, temp;
            while (!prevAndNext.get(cursor)[0].equals(cursor)) {
                temp = prevAndNext.get(cursor)[0];
                prevAndNext.get(cursor)[0] = null;
                cursor = temp;
                ++currentCount;
            }
            prevAndNext.get(cursor)[0] = null;
            cursor = key;
            while (!prevAndNext.get(cursor)[1].equals(cursor)) {
                prevAndNext.get(cursor)[0] = null;
                cursor = prevAndNext.get(cursor)[1];
                ++currentCount;
            }
            prevAndNext.get(cursor)[0] = null;
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        var LCS = new LongestConsecutiveSequence();
        System.out.println("Expected: 9, Actual: " + LCS.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println("Expected: 4, Actual: " + LCS.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
