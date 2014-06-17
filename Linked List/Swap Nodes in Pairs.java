// Given a linked list, swap every two adjacent nodes and return its head.
// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.
// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p0 = dummy;
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        //always swap p1 and p2
        while(p2 != null){ //p0 have more than two element after it
            p1.next = p2.next;
            p0.next = p2;
            p2.next = p1;
            p0 = p1;
            if(p0.next == null){ //if p0 is at the end of the list
                break;
            }else{
                p1 = p0.next;
                p2 = p0.next.next;
            }
        }
        return dummy.next;
    }
}