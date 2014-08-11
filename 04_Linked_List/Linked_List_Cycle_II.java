// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
// Follow up:
// Can you solve it without using extra space?
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * @author ZhuJiaqi
 * use slow and fast pointers. assume slow goes p step and fast goes 2p step and they meet each other
 * assume there are k step before loop and c step in the loop, we have:
 * p - k mod(c) = 2p - k mod(c), so p mod(c) = 0. so we know if we let fast point go another k step,
 * it should be at the beginning of the loop. we also know go k steps from head will be the beginning 
 * of the loop, so the meet point is what we want.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null) return null;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break; //slow and fast meet
        }
        if(fast == null || fast.next == null) return null; //no cycle!
        
        slow = head; //move slow back to the head
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}