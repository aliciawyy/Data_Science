package graph;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.function.BiConsumer;

/**
 * LeetCode 752. Open the Lock
 */
public class OpenTheLock {

    /**
     * Runtime: 66 ms, faster than 84.31% of Java online submissions for Open the Lock.
     * Memory Usage: 39.6 MB, less than 6.61% of Java online submissions for Open the Lock.
     */
    public int openLock(String[] deadends, String target) {
        BitSet seen = new BitSet(10000);
        Arrays.stream(deadends).forEach(s -> seen.set(Integer.parseInt(s)));
        LinkedList<AbstractMap.SimpleImmutableEntry<String, Integer>> queue = new LinkedList<>();
        BiConsumer<String, Integer> enqueueFunc = (combination, count) -> {
            int combinationInt = Integer.parseInt(combination);
            if (!seen.get(combinationInt)) {
                seen.set(combinationInt);
                queue.add(new AbstractMap.SimpleImmutableEntry<>(combination, count));
            }
        };
        enqueueFunc.accept("0000", 0);
        while (!queue.isEmpty()) {
            var item = queue.pop();
            var current = item.getKey();
            var num = item.getValue();
            if (current.equals(target)) {
                return num;
            }
            ++num;
            char[] curChars = current.toCharArray();
            for (int i = 0; i < 4; ++i) {
                char orig = curChars[i];
                curChars[i] = orig == '9' ? '0' : (char) (orig + 1);
                enqueueFunc.accept(String.valueOf(curChars), num);
                curChars[i] = orig == '0' ? '9' : (char) (orig - 1);
                enqueueFunc.accept(String.valueOf(curChars), num);
                curChars[i] = orig;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var solver = new OpenTheLock();
        System.out.println("1/ Expected: 6 Actual: " + solver.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println("2/ Expected: -1 Actual: " + solver.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
        System.out.println("3/ Expected: -1 Actual: " + solver.openLock(new String[]{"0000","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    }
}
