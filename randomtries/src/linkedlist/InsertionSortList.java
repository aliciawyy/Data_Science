package linkedlist;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        var root = new ListNode(-1, head);
        var end = head;
        while (end.next != null) {
            var target = end.next;
            var prevInsert = root;
            while (prevInsert != end) {
                if (prevInsert.next.val < target.val) {
                    prevInsert = prevInsert.next;
                } else {
                    break;
                }
            }
            if (prevInsert != end) {
                end.next = target.next;
                var insert = prevInsert.next;
                prevInsert.next = target;
                target.next = insert;
            } else {
                end = end.next;
            }
        }
        return root.next;
    }
}
