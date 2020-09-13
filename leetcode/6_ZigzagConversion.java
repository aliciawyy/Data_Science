class Solution {
  // Runtime: 6 ms, faster than 65.67% of Java online submissions for ZigZag Conversion.
  // Memory Usage: 40.1 MB, less than 56.27% of Java online submissions for ZigZag Conversion.
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> arr = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; ++i) {
            arr.add(new StringBuilder());
        }
        int currentRow = 0, direction = 1;
        for (char ch: s.toCharArray()) {
            arr.get(currentRow).append(ch);
            currentRow += direction;
            if (currentRow == 0 || currentRow == numRows - 1) {
                direction *= -1;
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder: arr) {
            result.append(builder.toString());
        }
        return result.toString();
    }
}
