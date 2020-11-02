package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/**
 * Leet Code. 739. Daily Temperatures.
 */
public class DailyTemperature {
    /**
     * Runtime: 16 ms, faster than 57.64% of Java online submissions for Daily Temperatures.
     * Memory Usage: 45.3 MB, less than 5.02% of Java online submissions for Daily Temperatures.
     */
    public int[] dailyTemperatures(int[] temperatures) {
        final int n = temperatures.length;
        int[] days = new int[n];
        ArrayDeque<List<Integer>> max = new ArrayDeque<>(n);
        for (int i = n - 1; i >= 0; --i) {
            if (max.isEmpty() || temperatures[i] >= max.getLast().get(0)) {
                max.clear();
                max.addFirst(List.of(temperatures[i], 1));
                continue;
            }
            int count = 1;
            while (temperatures[i] >= max.getFirst().get(0)) {
                var item = max.pollFirst();
                count += item.get(1);
            }
            days[i] = count;
            max.addFirst(List.of(temperatures[i], count));
        }
        return days;
    }

    public static void main(String[] args) {
        var solver = new DailyTemperature();
        System.out.println("1/ Expected: [1, 1, 4, 2, 1, 1, 0, 0]");
        System.out.println("1/ Actual: " + Arrays.toString(solver.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
