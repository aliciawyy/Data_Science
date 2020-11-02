package queue;

import java.util.ArrayDeque;

/**
 * Runtime: 0 ms
 * Memory Usage: 37.2 MB
 */
public class MyQueueUsingStack {
    private final ArrayDeque<Integer> mCurrent = new ArrayDeque<>();
    private final ArrayDeque<Integer> mOldQueue = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyQueueUsingStack() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        mCurrent.addLast(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (mOldQueue.isEmpty()) {
            while (!mCurrent.isEmpty()) {
                mOldQueue.addLast(mCurrent.pollLast());
            }
        }
        return mOldQueue.isEmpty() ? -1 : mOldQueue.pollLast();
    }

    /** Get the front element. */
    public int peek() {
        if (mOldQueue.isEmpty()) {
            while (!mCurrent.isEmpty()) {
                mOldQueue.addLast(mCurrent.pollLast());
            }
        }
        return mOldQueue.isEmpty() ? -1 : mOldQueue.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mCurrent.isEmpty() && mOldQueue.isEmpty();
    }
}
