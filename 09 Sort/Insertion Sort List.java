// Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        
        while(head.next != null){
            if(head.next.val >= head.val){ //the order is right
                head = head.next;
            }else{ //the order is wrong
                // pull the node out from the list
                ListNode temp = head.next;
                head.next = temp.next;
                temp.next = null;
                // inset the node back to the right place
                ListNode ptr = dummy;
                while(ptr.next.val < temp.val){
                    ptr = ptr.next;
                }
                temp.next = ptr.next;
                ptr.next = temp;
            }
        }
        return dummy.next;
    }
}