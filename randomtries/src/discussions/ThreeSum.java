package discussions;

import java.util.*;

/**
 * LeetCode 15. 3sum
 */
public class ThreeSum {

    /**
     * Runtime: 116 ms, faster than 34.72% of Java online submissions for 3Sum.
     * Memory Usage: 42.3 MB, less than 5.06% of Java online submissions for 3Sum.
     */
    public List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // boolean flag shows whether the number exist 2+ times
        TreeMap<Integer, Boolean> keyExistsTwice = new TreeMap<>();
        for (int num: nums) {
            Boolean doesKeyExistsTwice = keyExistsTwice.get(num);
            if (doesKeyExistsTwice != null && doesKeyExistsTwice) {
                if (num == 0 && result.isEmpty()) {
                    result.add(List.of(0, 0, 0));
                }
            } else {
                keyExistsTwice.put(num, doesKeyExistsTwice != null);
            }
        }
        for (var entry: keyExistsTwice.entrySet()) {
            int key = entry.getKey();
            if (entry.getValue() && key != 0 && keyExistsTwice.containsKey(- key - key)) {
                result.add(List.of(key, key, - key - key));
            }
        }
        Integer[] keys = keyExistsTwice.keySet().toArray(Integer[]::new);
        for (int i = 0; i < keys.length; ++i) {
            for (int j = i + 1; j < keys.length; ++j) {
                int target = - keys[i] - keys[j];
                if (target <= keys[j]) {
                    break;
                }
                if (keyExistsTwice.containsKey(target)) {
                    result.add(List.of(keys[i], keys[j], target));
                }
            }
        }
        return result;
    }

    /**
     * Runtime: 153 ms, faster than 33.73% of Java online submissions for 3Sum.
     * Memory Usage: 43 MB, less than 5.06% of Java online submissions for 3Sum.
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // boolean flag shows whether the number exist 2+ times
        Set<Integer> existsOnce = new HashSet<>();
        Set<Integer> temp = new HashSet<>();
        int countZero = 0;
        for (int num: nums) {
            if (!existsOnce.contains(num)) {
               existsOnce.add(num);
            } else if (!temp.contains(num)) {
               temp.add(num);
            }
            if (num == 0) {
                ++countZero;
            }
        }
        if (countZero >= 3) {
            result.add(List.of(0, 0, 0));
        }
        temp.remove(0);
        for (var key: temp) {
            if (existsOnce.contains(- key - key)) {
                result.add(List.of(key, key, - key - key));
            }
        }
        // All unchecked keys
        temp = new HashSet<>(existsOnce);
        for (var key1: existsOnce) {
            temp.remove(key1);
            HashSet<Integer> inResult = new HashSet<>();
            for (var key2: temp) {
                int target = - key1 - key2;
                if (target != key2 && temp.contains(target) && !inResult.contains(target)) {
                    result.add(List.of(key1, key2, target));
                    inResult.add(key2);
                    inResult.add(target);
                }
            }
        }
        return result;
    }

    /**
     * Runtime: 34 ms, faster than 42.60% of Java online submissions for 3Sum.
     * Memory Usage: 42.7 MB, less than 5.06% of Java online submissions for 3Sum.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // boolean flag shows whether the number exist 2+ times
        Map<Integer, Boolean> keyExistsTwice = new HashMap<>();
        int countZero = 0;
        for (int num: nums) {
            Boolean doesKeyExistsTwice = keyExistsTwice.getOrDefault(num, null);
            if (doesKeyExistsTwice == null || !doesKeyExistsTwice) {
                keyExistsTwice.put(num, doesKeyExistsTwice != null);
            }
            if (num == 0) {
                ++countZero;
            }
        }
        if (countZero >= 3) {
            result.add(List.of(0, 0, 0));
        }
        keyExistsTwice.replace(0, true, false);
        for (var entry: keyExistsTwice.entrySet()) {
            int key = entry.getKey();
            if (entry.getValue() && keyExistsTwice.containsKey(- key - key)) {
                result.add(List.of(key, key, - key - key));
            }
        }
        Integer[] keys = keyExistsTwice.keySet().toArray(Integer[]::new);
        Arrays.sort(keys);
        for (int i = 0; i < keys.length; ++i) {
            for (int j = i + 1; j < keys.length; ++j) {
                int target = - keys[i] - keys[j];
                if (target <= keys[j]) {
                    break;
                }
                if (keyExistsTwice.containsKey(target)) {
                    result.add(List.of(keys[i], keys[j], target));
                }
            }
        }
        return result;
    }

    /**
     * Runtime: 35 ms, faster than 41.98% of Java online submissions for 3Sum.
     * Memory Usage: 42.7 MB, less than 5.06% of Java online submissions for 3Sum.
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // boolean flag shows whether the number exist 2+ times
        Map<Integer, Boolean> keyExistsTwice = new HashMap<>();
        for (int num: nums) {
            Boolean doesKeyExistsTwice = keyExistsTwice.get(num);
            if (doesKeyExistsTwice != null && doesKeyExistsTwice) {
                if (num == 0 && result.isEmpty()) {
                    result.add(List.of(0, 0, 0));
                }
            } else {
                keyExistsTwice.put(num, doesKeyExistsTwice != null);
            }
        }
        for (var entry: keyExistsTwice.entrySet()) {
            int key = entry.getKey();
            if (entry.getValue() && key != 0 && keyExistsTwice.containsKey(- key - key)) {
                result.add(List.of(key, key, - key - key));
            }
        }
        Integer[] keys = keyExistsTwice.keySet().toArray(Integer[]::new);
        Arrays.sort(keys);
        for (int i = 0; i < keys.length; ++i) {
            for (int j = i + 1; j < keys.length; ++j) {
                int target = - keys[i] - keys[j];
                if (target <= keys[j]) {
                    break;
                }
                if (keyExistsTwice.containsKey(target)) {
                    result.add(List.of(keys[i], keys[j], target));
                }
            }
        }
        return result;
    }

    /**
     * Runtime: 353 ms, faster than 21.10% of Java online submissions for 3Sum.
     * Memory Usage: 43.6 MB, less than 5.06% of Java online submissions for 3Sum.
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Set<Integer>> pairs = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int k = Arrays.binarySearch(nums,  j + 1, nums.length, - nums[i] - nums[j]);
                if (k >= 0) {
                    pairs.putIfAbsent(nums[i], new HashSet<>());
                    pairs.get(nums[i]).add(nums[j]);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (var entry: pairs.entrySet()) {
            int key = entry.getKey();
            for (var j : entry.getValue()) {
                result.add(List.of(key, j, - key - j));
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        // int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        /**
         * int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
         * [-2, 0, 2]
         * [-2, -2, 4]
         * [-4, 0, 4]
         * [-4, -2, 6]
         * [-4, 1, 3]
         * [-4, 2, 2]
         */
        var tS = new ThreeSum();
        System.out.println(tS.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(tS.threeSum(new int[]{3, -2, 1, 0}));
        System.out.println(tS.threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(tS.threeSum(new int[]{0, 0}));
        var result = tS.threeSum(nums);
        System.out.println(result);
    }
}
