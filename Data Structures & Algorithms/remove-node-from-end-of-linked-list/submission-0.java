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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sizeOfList = 0;
        ListNode headRef = head;

        while (headRef != null) {
            sizeOfList++;
            headRef = headRef.next;
        }

        int k = sizeOfList-n;
        int count = 0;
        headRef = head;
        ListNode headRefRet = headRef;
        if (k == 0) {
            return head.next;
        }

        while (count < k-1) {
            headRef = headRef.next;
            count++;
        }

        headRef.next = headRef.next.next;
        return headRefRet;
    }
}
