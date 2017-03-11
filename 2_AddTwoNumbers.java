/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int carry = 0, val = 0;
        ListNode newHead = new ListNode(0);
        ListNode t = newHead;
        while (l1 != null || l2 != null || carry != 0) {
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                val = l1.val + carry;
                l1 = l1.next;
            } else if (l2 != null) {
                val = l2.val + carry;
                l2 = l2.next;
            } else if (carry != 0) {
                val = carry;
            }
            ListNode cur = new ListNode(val % 10);
            t.next = cur;
            carry = val / 10;
            t = t.next;
        }
        return newHead.next;
    }
}