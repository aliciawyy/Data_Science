class Solution {

  /**
   * Runtime: 23 ms, faster than 84.45% of Java online submissions for Longest Palindromic Substring.
   * Memory Usage: 37.8 MB, less than 86.38% of Java online submissions for Longest Palindromic Substring.
   */
  public String longestPalindrome(String s) {
          if (s.length() <= 1) { return s; }
          int start, end, maxStart = 0, maxLen = 1;
          // With virtual center, center is in fact the right element of the virtual center
          for (int i = 1; i < s.length(); ++i) {
              if (s.charAt(i)  != s.charAt(i - 1)) {
                 continue;
              }
              start = i - 2;
              end = i + 1;
              while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                 --start;
                 ++end;
              }
              ++start;
              if (end - start > maxLen) {
                 maxStart = start;
                 maxLen = end - maxStart;
              }
          }
          // With real center
          for (int i = 1; i < s.length(); ++i) {
              start = i - 1;
              end = i + 1;
              while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                 --start;
                 ++end;
              }
              ++start;
              if (end - start > maxLen) {
                 maxStart = start;
                 maxLen = end - maxStart;
              }
          }
          return s.substring(maxStart, maxStart + maxLen);
    }


    /**
     * Runtime: 113 ms, faster than 29.60% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 50.6 MB, less than 14.80% of Java online submissions for Longest Palindromic Substring.
     */
    public String longestPalindrome_FromTwoEnds(String s) {
        if (s.length() <= 1) { return s; }
        char[] arr = s.toCharArray();
        Boolean[][] palindrome = new Boolean[s.length()][s.length()];
        for (int i = 0; i < arr.length; ++i) {
            palindrome[i][i] = true;
        }
        int start = 0, maxLength = 1, end;
        for (int i = 1; i < arr.length; ++i) {
            end = i - maxLength;
            for (int j = 0; j <= end; ++j) {
                if (isPalindrome(arr, j, i, palindrome)) {
                    start = j;
                    maxLength = i - j + 1;
                    break;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    private boolean isPalindrome(char[] arr, int start, int end, Boolean[][] cache) {
        if (start > end) {
            return true;
        }
        if (cache[start][end] == null) {
            if (arr[start] != arr[end]) {
                cache[start][end] = false;
            } else {
                cache[start][end] = isPalindrome(arr, start + 1, end - 1, cache);
            }
        }
        return cache[start][end];
    }
}
