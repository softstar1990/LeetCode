// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
// You should preserve the original relative order of the nodes in each of the two partitions.
// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.
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
                ListNode temp = curr;
                curr = temp.next;
                temp.next = null;
            if(temp.val < x){
                lt.next = temp;
                lt = lt.next;
            }else{
                geq.next = temp;
                geq = geq.next;
            }
        }
        
        lt.next = geqhead.next;//merge two lists back        
        return lthead.next;
    }
}
