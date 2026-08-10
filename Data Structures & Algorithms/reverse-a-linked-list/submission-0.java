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
/*

*/
// x - 1 - 2 - 3 - 4 - x
// prev curr next
// 

    

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        /*
        1. Set next node to current's next node; store val
        2. Set curr.next to prev; re-link
        3. Set prev = curr; moving on
        2. Set curr = next; move to next node
        */

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
