/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /**
     * Runtime: 2 ms, faster than 68.47% of Java online submissions for Add Two Numbers.
     * Memory Usage: 39.5 MB, less than 81.99% of Java online submissions for Add Two Numbers.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode preHead = new ListNode();
        ListNode cursor = preHead;
        while (l1 != null || l2 != null) {
            int currentResult = carry;
            if (l1 != null) {
                currentResult += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                currentResult += l2.val;
                l2 = l2.next;
            }
            if (currentResult >= 10) {
                carry = 1;
                currentResult -= 10;
            } else {
                carry = 0;
            }
            cursor.next = new ListNode(currentResult);
            cursor = cursor.next;
        }
        if (carry > 0) {
            cursor.next = new ListNode(carry);
        }
        return preHead.next;
    }
}