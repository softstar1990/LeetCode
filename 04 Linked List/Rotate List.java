//Given a list, rotate the list to the right by k places, where k is non-negative.
//For example:
//Given 1->2->3->4->5->NULL and k = 2,
//return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return head;

        ListNode p = head;
        int len = 1;
        while(p.next != null){
        	len++;
        	p = p.next;
        }
        p.next = head; //make a circle

        n %= len; //notice that n maybe larger than len
        //move right len-n-1
        for(int i = 0; i < len-n-1; i++){
        	head = head.next;
        }

        ListNode temp = head.next;
        head.next = null;	//break the circle
        return temp;
    }
}