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
            
        if(root.left != null) root.left.next = root.right;  

        if(root.right!=null && root.next!=null){  //we know the tree is 
            root.right.next = root.next.left;  
        }  
          
        connect(root.left);  
        connect(root.right);
    }
}
