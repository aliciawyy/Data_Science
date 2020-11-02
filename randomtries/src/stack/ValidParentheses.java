package stack;

import java.util.ArrayDeque;

public class ValidParentheses {

    /**
     * Runtime: 1 ms
     * Memory Usage: 37 MB
     */
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char last;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.addLast(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else if (ch == ')') {
                last = stack.pollLast();
                if (last != '(') {
                    return false;
                }
            } else if (ch == ']') {
                last = stack.pollLast();
                if (last != '[') {
                    return false;
                }
            } else if (ch == '}') {
                last = stack.pollLast();
                if (last != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        var solver = new ValidParentheses();
        System.out.println("1/ Expected: true Actual: " + solver.isValid("()[]{}"));
    }
}
