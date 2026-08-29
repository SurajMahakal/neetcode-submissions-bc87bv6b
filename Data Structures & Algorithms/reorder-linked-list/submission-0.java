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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode curr = list2;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        list2 = prev;
        ListNode dummy = new ListNode(0);
        curr = dummy;

        while (list1 != null && list2 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;

            curr.next = list2;
            list2 = list2.next;
            curr = curr.next; 
        }

        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }

    }
}
