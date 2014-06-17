// Reverse a linked list from position m to n. Do it in-place and in one-pass.
// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,
// return 1->4->3->2->5->NULL.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        for(int i = 1; i < m; i++)
            p = p.next;
        //p is the node before the mth node
        p.next = reverse(p.next, n - m + 1);
        return dummy.next; 
    }
    
    //reverse get the first node of the part should reversed
    //and the number in the part 
    //reverse it and return the head
    private ListNode reverse(ListNode head, int n){
        ListNode node = head, prev = null, next = null;
        //in each iteration, add 1 node to reversed list
        for(int i = 0; i < n; i++){
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head.next = node; //link reversed list to rest of original list
        return prev; //head of reversed list
    }
}
