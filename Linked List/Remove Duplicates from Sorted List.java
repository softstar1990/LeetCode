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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        
        ListNode p = head;
        while(p.next != null){
            if(p.next.val == p.val){
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }
        return head;
    }
}