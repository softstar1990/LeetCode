/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        TreeLinkNode dummy = new TreeLinkNode(-1);        
        for(TreeLinkNode curr = root, prev = dummy; curr != null; curr = curr.next){
            if(curr.left != null){
                prev.next = curr.left;
                prev = prev.next;
            }
            if(curr.right != null){
                prev.next = curr.right;
                prev = prev.next;
            }
        }
        connect(dummy.next);
    }
}