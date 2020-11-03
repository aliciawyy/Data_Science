package queue;

/**
 * 707. Design Linked List
 * Runtime: 7 ms, faster than 95.83% of Java online submissions for Design Linked List.
 * Memory Usage: 39.9 MB, less than 9.19% of Java online submissions for Design Linked List.
 */
class MyLinkedList {

    static class Node {
        int val;
        Node prev;
        Node next;

        Node() {}
        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node mBeforeHead;
    private Node mAfterTail;
    private int mSize;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        mBeforeHead = new Node(-1, null, null);
        mAfterTail = new Node(-1, null, null);
        mBeforeHead.next = mAfterTail;
        mAfterTail.prev = mBeforeHead;
        mSize = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= mSize) {
            return -1;
        }
        Node node = mBeforeHead;
        for (int i = 0; i <= index; ++i) {
            node = node.next;
        }
        return node.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        var node = new Node(val, mBeforeHead, mBeforeHead.next);
        mBeforeHead.next.prev = node;
        mBeforeHead.next = node;
        ++mSize;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        var node = new Node(val, mAfterTail.prev, mAfterTail);
        mAfterTail.prev.next = node;
        mAfterTail.prev = node;
        ++mSize;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list,
     * the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == mSize) {
            addAtTail(val);
            return;
        }
        if (index > mSize) {
            return;
        }
        Node node = mBeforeHead;
        for (int i = 0; i <= index; ++i) {
            node = node.next;
        }
        Node newNode = new Node(val, node.prev, node);
        node.prev.next = newNode;
        node.prev = newNode;
        ++mSize;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= mSize) {
            return;
        }
        if (index == mSize - 1) {
            mAfterTail = mAfterTail.prev;
            mAfterTail.next = null;
        } else if (index == 0) {
            mBeforeHead.next = mBeforeHead.next.next;
            mBeforeHead.next.prev = mBeforeHead;
        } else {
            Node node = mBeforeHead;
            for (int i = 0; i < index; ++i) {
                node = node.next;
            }
            Node nodeToDelete = node.next;
            nodeToDelete.next.prev = node;
            node.next = nodeToDelete.next;
        }
        --mSize;
    }

    public static void main(String[] args) {
        var ll = new MyLinkedList();
        ll.addAtHead(1);
        ll.addAtTail(3);
        ll.addAtIndex(1, 2);
        ll.deleteAtIndex(1);
    }
}