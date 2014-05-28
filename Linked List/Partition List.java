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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode lt = new ListNode(0);
        ListNode geq = new ListNode(0);
        ListNode lthead = lt;
        ListNode geqhead = geq;
        
        ListNode curr = head;
        while(curr != null){
            if(curr.val < x){
                ListNode temp = curr;
                curr = temp.next;
                temp.next = null;
                lt.next = temp;
                lt = lt.next;
            }else{
                ListNode temp = curr;
                curr = temp.next;
                temp.next = null;
                geq.next = temp;
                geq = geq.next;
            }
        }
        
        lt.next = geqhead.next;
        
        return lthead.next;
    }
}
