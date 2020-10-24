class Solution {
  // Runtime: 1 ms, faster than 62.49% of Java online submissions for Longest Common Prefix.
  // Memory Usage: 37.3 MB, less than 90.43% of Java online submissions for Longest Common Prefix.
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        final String prefix = strs[0];
        int end = prefix.length();
        for (int i = 1; i < strs.length; ++i) {
            if (end == 0) {
                return "";
            }
            int j = 0;
            while (j < end && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                ++j;
            }
            end = j;
        }
        return prefix.substring(0, end);
    }
}