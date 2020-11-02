package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Leet Code. 225. Implement Stack using Queues
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement Stack using Queues.
 * Memory Usage: 36.9 MB, less than 8.86% of Java online submissions for Implement Stack using Queues.
 */
public class MyStack {
    private Deque<Integer> mQueue = new LinkedList<>();
    private int mTop = -1;

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        mTop = x;
        mQueue.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Deque<Integer> queue = new LinkedList<>();
        while (mQueue.size() > 2) {
            queue.addLast(mQueue.pollFirst());
        }
        if (mQueue.size() == 2) {
            mTop = mQueue.pollFirst();
            queue.addLast(mTop);
        }
        int result = mQueue.pollFirst();
        mQueue = queue;
        return result;
    }

    /** Get the top element. */
    public int top() {
        return mTop;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return mQueue.isEmpty();
    }
}
