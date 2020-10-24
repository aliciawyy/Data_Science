class Solution {
    private static final Map<String, Integer> DOUBLE_DIGITS_MAP = new HashMap<String, Integer>(){{
        put("IV", 4);
        put("IX", 9);
        put("XL", 40);
        put("XC", 90);
        put("CD", 400);
        put("CM", 900);
    }};

    private static final Map<String, Integer> SINGLE_DIGIT_MAP = new HashMap<String, Integer>(){{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    // Runtime: 5 ms, faster than 69.25% of Java online submissions for Roman to Integer.
    // Memory Usage: 39.7 MB, less than 75.15% of Java online submissions for Roman to Integer.
    public int romanToInt(String s) {
        final int n = s.length() - 1;
        int i = 0, result = 0;
        while (i < n) {
            String doubleDigits = s.substring(i, i + 2);
            if (DOUBLE_DIGITS_MAP.containsKey(doubleDigits)) {
                result += DOUBLE_DIGITS_MAP.get(doubleDigits);
                i += 2;
            } else {
                result += SINGLE_DIGIT_MAP.get(s.substring(i, i + 1));
                ++i;
            }
        }
        if (i == n) {
            result += SINGLE_DIGIT_MAP.get(s.substring(n));
        }
        return result;
    }
}
