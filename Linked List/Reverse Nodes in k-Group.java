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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        if(k<=1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p1 = dummy;
        ListNode p2 = head;
        int count = 0;

        while(p2 != null){
        	count++;
        	ListNode next = p2.next;	//remenber the postion of head of next group, p2 will point to other position in reverse
        	if(count == k){
        		p1 = reverse(p1, next);
        		count = 0;
        	}
        	p2 = next;
        }

        return dummy.next;
    }

    //reverse take the node before the group and the node after the group
    //reverse the node in the group and return the last node in it
    public ListNode reverse(ListNode head, ListNode tail){
    	ListNode prev = tail;
    	ListNode curr = head.next;
    	ListNode result = head.next;
    	while(curr.next != tail){
    		ListNode next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	curr.next = prev;
    	head.next = curr;
    	return result;
    }
}