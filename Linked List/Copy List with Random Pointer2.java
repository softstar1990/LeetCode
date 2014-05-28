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
        if(head == null) return null;
        
        RandomListNode newhead = new RandomListNode(head.label);
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        map.put(head, newhead);
        
        RandomListNode p = head;
        while(p.next != null){
                RandomListNode temp = new RandomListNode(p.next.label);
                map.put(p.next, temp);
                map.get(p).next = map.get(p.next);
                p = p.next;
        }
        
        p = head;
        while (p != null) {
    		if (p.random != null){
    			map.get(p).random = map.get(p.random);
    		}else{
    			map.get(p).random = null;
    		}
    		p = p.next;
    	}
        
        return newhead;
    }
}
