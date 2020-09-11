import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * Runtime: 2 ms, faster than 75.69% of Java online submissions for Two Sum.
     * Memory Usage: 39.4 MB, less than 89.53% of Java online submissions for Two Sum.
     */
    public int[] twoSum_withSortedArray(int[] nums, int target) {
        int[] originalNums = nums.clone();
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int currentSum = nums[start] + nums[end];
            if (currentSum == target) {
                break;
            } else if (currentSum < target) {
                ++start;
            } else {
                --end;
            }
        }

        for (int i = 0; i < originalNums.length; ++i) {
            if (originalNums[i] == nums[start]) {
                start = i;
                break;
            }
        }
        for (int i = 0; i < originalNums.length; ++i) {
            if (originalNums[i] == nums[end] && i != start) {
                end = i;
                break;
            }
        }
        return new int[] {start, end};
    }

    /**
     * Runtime: 1 ms, faster than 99.96% of Java online submissions for Two Sum.
     * Memory Usage: 39.4 MB, less than 89.53% of Java online submissions for Two Sum.
     */
    public int[] twoSum_withHashMap(int[] nums, int target) {
        Map<Integer, Integer> indexes = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            Integer rest = target - nums[i];
            if (indexes.containsKey(rest)) {
                return new int[] {indexes.get(rest), i};
            } else {
                indexes.put(nums[i], i);
            }
        }
        return null;
    }

}