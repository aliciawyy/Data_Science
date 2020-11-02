package stack;

import java.util.AbstractMap;
import java.util.ArrayDeque;

/**
 * 394. Decode String
 */
public class DecodeString {
    /**
     * Runtime: 2 ms, faster than 46.66% of Java online submissions for Decode String.
     * Memory Usage: 37.2 MB, less than 5.90% of Java online submissions for Decode String.
     */
    public String decodeString(String s) {
        ArrayDeque<AbstractMap.SimpleImmutableEntry<String, Boolean>> stack = new ArrayDeque<>();
        char[] chArray = s.toCharArray();
        int digitStart = -1, letterStart = -1;
        for (int i = 0; i < chArray.length; ++i) {
            if (Character.isDigit(chArray[i])) {
                if (letterStart != -1) {
                    stack.addLast(new AbstractMap.SimpleImmutableEntry<>(s.substring(letterStart, i), false));
                    letterStart = -1;
                }
                if (digitStart == -1) {
                    digitStart = i;
                }
            } else if (chArray[i] == '[') {
                stack.addLast(new AbstractMap.SimpleImmutableEntry<>(s.substring(digitStart, i), true));
                digitStart = -1;
            } else if (chArray[i] == ']') {
                String current = letterStart == -1 ? "" : s.substring(letterStart, i);
                letterStart = -1;
                while (!stack.peekLast().getValue()) {
                    current = stack.pollLast().getKey() + current;
                }
                int count = Integer.parseInt(stack.pollLast().getKey());
                stack.addLast(new AbstractMap.SimpleImmutableEntry<>(current.repeat(count), false));
            } else if (letterStart == -1) {
                letterStart = i;
            }
        }
        if (letterStart != -1) {
            stack.addLast(new AbstractMap.SimpleImmutableEntry<>(s.substring(letterStart), false));
        }
        return stack.stream().map(AbstractMap.SimpleImmutableEntry::getKey).reduce("", String::concat);
    }

    public static void main(String[] args) {
        var solver = new DecodeString();
        System.out.println("1/ \"2[abc]3[cd]ef\". Expected: \"abcabccdcdcdef\" Actual: " + solver.decodeString("2[abc]3[cd]ef"));
        System.out.println("2/ 3[a2[c]] Actual: " + solver.decodeString("3[a2[c]]"));
    }
}
