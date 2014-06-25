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
        for(int i = 1; i < m; i++)
            p = p.next;
        //p is the node before the mth node
        reverse(p.next, n - m + 1);
        return dummy.next; 
    }
    
    //reverse get the first node of the part should reversed
    //and the number in the part 
    private ListNode reverse(ListNode head, int n){
    	ListNode prev = null, tail = head.next;
        //in each iteration, add 1 node to reversed list
        for(int i = 0; i < n; i++){
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = prev;
            prev = temp;
        }
        tail.next = head.next;//link reversed list to rest of original list
        head.next = prev;
    }
}
