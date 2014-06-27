//Given a linked list, remove the nth node from the end of list and return its head.
//For example,
//   Given linked list: 1->2->3->4->5, and n = 2.
//   After removing the second node from the end, the linked list becomes 1->2->3->5.
//Note:
//Given n will always be valid.
//Try to do this in one pass.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode newHead = dummy;
        for(int i = 0; i < n; i++){
            tail = tail.next;
        }
        while(tail.next != null){
            tail = tail.next;
            dummy = dummy.next;
        }
        
        dummy.next = dummy.next.next;
        return newHead.next;
    }
}