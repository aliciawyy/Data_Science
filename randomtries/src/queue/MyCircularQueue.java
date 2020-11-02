package queue;

/**
 * 622. Design Circular Queue
 * Runtime: 4 ms
 * Memory Usage: 39.9 MB
 */
class MyCircularQueue {
    private final int[] mData;
    private final int mCapacity;
    private int mHead;
    private int mTail;
    private int mSize;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        mCapacity = k;
        mData = new int[mCapacity];
        mHead = 0;
        mTail = -1;
        mSize = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (mSize == mCapacity) {
            return false;
        }
        ++mTail;
        if (mTail == mCapacity) {
            mTail = 0;
        }
        mData[mTail] = value;
        ++mSize;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (mSize == 0) {
            return false;
        }
        ++mHead;
        if (mHead == mCapacity) {
            mHead = 0;
        }
        --mSize;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return mSize == 0 ? -1: mData[mHead];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return mSize == 0 ? -1: mData[mTail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return mSize == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return mSize == mCapacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
