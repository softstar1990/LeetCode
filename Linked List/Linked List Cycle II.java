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
//well this is not the best solution since it use extra space
//should use faster and slow pointer and calculate the solution
//but this got accepted on leetcode OJ
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> nodes = new HashSet<ListNode>();
        ListNode current = head;

        while(current != null){
            if(nodes.contains(current))
                return current;
            nodes.add(current);
            current = current.next;
        }

        return null;
        }
}