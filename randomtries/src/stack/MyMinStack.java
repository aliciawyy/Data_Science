package stack;

import java.util.ArrayDeque;

public class MyMinStack {

    /**
     * Runtime: 5 ms
     * Memory Usage: 40.8 MB
     */
    class MinStack {

        private ArrayDeque<Integer> mData = new ArrayDeque<>();
        private ArrayDeque<Integer> mMin = new ArrayDeque<>();

        /** initialize your data structure here. */
        public MinStack() {
            mMin.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            mData.addLast(x);
            var currentMin = mMin.peekLast();
            mMin.addLast(currentMin < x ? currentMin : x);
        }

        public void pop() {
            mData.removeLast();
            mMin.removeLast();
        }

        public int top() {
            return mData.getLast();
        }

        public int getMin() {
            return mMin.getLast();
        }
    }
}
