package discussions;

import java.util.*;

/**
 * 315. Count of Smaller Numbers After Self
 */
public class CountSmallerNumberAfterSelf {
    /**
     * Time Limit Exceeded
     */
    public List<Integer> countSmaller(int[] nums) {
        // treeMap stores the number of elements <= key till now
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        List<Integer> result = new ArrayList<>();
        Integer value;
        for (int i = nums.length - 1; i >= 0; --i) {
            var lowerKey = treeMap.lowerKey(nums[i]);
            int lowerNum = lowerKey == null ? 0: treeMap.get(lowerKey);
            result.add(lowerNum);
            if ((value = treeMap.get(nums[i])) != null) {
                treeMap.replace(nums[i], value + 1);
            } else {
                treeMap.put(nums[i], lowerNum + 1);
            }
            var entry = treeMap.higherEntry(nums[i]);
            while (entry != null) {
                treeMap.replace(entry.getKey(), entry.getValue() + 1);
                entry = treeMap.higherEntry(entry.getKey());
            }
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * Time Limit Exceeded
     */
    public List<Integer> countSmaller1(int[] nums) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            result.add(treeMap.headMap(nums[i]).values().stream().reduce(0, (a,b) -> a + b));
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        Collections.reverse(result);
        return result;
    }

    /**
     * Runtime: 25 ms, faster than 25.45% of Java online submissions for Count of Smaller Numbers After Self.
     * Memory Usage: 40.9 MB, less than 6.79% of Java online submissions for Count of Smaller Numbers After Self.
     */
    public List<Integer> countSmaller2(int[] nums) {
        int[] increasingArrFromEnd = new int[nums.length];
        List<Integer> result = new ArrayList<>();
        int n = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            int k = binarySearchFirstEqualOrBig(increasingArrFromEnd, n, nums[i]);
            if (k < n) {
                System.arraycopy(increasingArrFromEnd, k, increasingArrFromEnd, k + 1, n - k);
            }
            increasingArrFromEnd[k] = nums[i];
            ++n;
            result.add(k);
        }
        Collections.reverse(result);
        return result;
    }

    private int binarySearchFirstEqualOrBig(int[] arr, int len, int target) {
        int fromIndex = 0, toIndex = len - 1;
        while (fromIndex <= toIndex) {
            int midIndex = (fromIndex + toIndex) / 2;
            if (arr[midIndex] < target) {
                fromIndex = midIndex + 1;
            } else {
                toIndex = midIndex - 1;
            }
        }
        return fromIndex;
    }

    public static void main(String[] args) {
        var problem = new CountSmallerNumberAfterSelf();
        System.out.println("3/ Problem[52,22,51,28,13,51]. Expected: [5,1,2,1,0,0] Actual: " + problem.countSmaller(new int[]{52,22,51,28,13,51}));
        System.out.println("2/ Problem[5,2,6,1]. Expected: [2,1,1,0] Actual: " + problem.countSmaller(new int[]{5,2,6,1}));
        System.out.println("1/ Expected: [0,0,0,0,0] Actual: " + problem.countSmaller(new int[]{2,2,2,2,2}));
    }
}
