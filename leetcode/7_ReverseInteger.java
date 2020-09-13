class Solution {

  // Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
  // Memory Usage: 36.7 MB, less than 75.44% of Java online submissions for Reverse Integer.
  public int reverse(int x) {
      long result = 0;
      while (x != 0) {
          result = result * 10 + x % 10;
          x /= 10;
      }
      return result > ((1 << 31) - 1) || result < -(1 << 31) ? 0 : (int) result;
  }
}
