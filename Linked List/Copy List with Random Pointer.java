// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
     
    	if (head == null)
    		return null;
     
    	RandomListNode p = head;
     
    	// copy every node and insert to list
    	while (p != null) {
    		RandomListNode copy = new RandomListNode(p.label);
    		copy.next = p.next;
    		p.next = copy;
    		p = copy.next;
    	}
     
    	// copy random pointer for each new node
    	p = head;
    	while (p != null) {
    		if (p.random != null)
    			p.next.random = p.random.next;
    		p = p.next.next;
    	}
     
    	// break list to two
    	p = head;
    	RandomListNode newHead = head.next;
    	while (p != null) {
    		RandomListNode temp = p.next;
    		p.next = temp.next;
    		if (temp.next != null)
    			temp.next = temp.next.next;
    		p = p.next;
    	}
     
    	return newHead;
    }
}