// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public static TreeNode sortedListToBST(ListNode head) {
        return rec(head, null);
    }
	
	public static TreeNode rec(ListNode start, ListNode end){
		if(start == end) return null;
				
		ListNode mid = start;			
		ListNode probe = start;//fast pointer			
		while(probe!=end && probe.next!=end){
			mid = mid.next;
			probe = probe.next.next;
		}
		
		TreeNode root = new TreeNode(mid.val);
		root.left = rec(start, mid);
		root.right = rec(mid.next, end);
		return root;
	}
}

