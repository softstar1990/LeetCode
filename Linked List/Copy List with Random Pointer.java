// A linked list is given such that each node contains an additional random pointer 
// which could point to any node in the list or null.
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
        //create a map between original nodes and copied nodes
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        map.put(head, newhead);
        //deal with next pointer
        RandomListNode p = head;
        while(p.next != null){
            RandomListNode temp = new RandomListNode(p.next.label);
            map.put(p.next, temp);
            map.get(p).next = map.get(p.next);
            p = p.next;
        }
        //deal with random pointer
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
