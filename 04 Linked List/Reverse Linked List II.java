//Reverse a linked list from position m to n. Do it in-place and in one-pass.
//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,
//return 1->4->3->2->5->NULL.
//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.
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
        for(int i = 0; i < m-1; i++){
            p = p.next;
        }
        reverse(p, n-m+1);
        return dummy.next;
    }
    
    private void reverse(ListNode head, int n){
        ListNode prev = null, tail = head.next;
        for(int i = 0; i < n; i++){
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = prev;
            prev = temp;
        }
        tail.next = head.next;//link the new end to rest of original list
        head.next = prev;//link the new head to rest of original list
    }
}