package stack;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.function.IntBinaryOperator;

/**
 * Leet Code. Evaluate Reverse Polish Notation
 */
public class ReversePolishNotation {
    private static final Map<String, IntBinaryOperator> OPERATORS = Map.of(
            "+", Integer::sum,
            "-", (a,b) -> a - b,
            "*", (a,b) -> a * b,
            "/", (a,b) -> a / b
    );

    /**
     * Runtime: 4 ms
     * Memory Usage: 38.9 MB
     */
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(tokens.length);
        for (String token : tokens) {
            var operator = OPERATORS.get(token);
            if (operator == null) {
                stack.addLast(Integer.parseInt(token));
            } else {
                int b = stack.pollLast(), a = stack.pollLast();
                stack.addLast(operator.applyAsInt(a, b));
            }
        }
        return stack.peekLast();
    }
}
