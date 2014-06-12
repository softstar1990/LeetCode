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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;  
        return isSym(root.left, root.right);  
    }
    
    public boolean isSym(TreeNode leftN, TreeNode rightN) {  
      if(leftN == null) return rightN == null;  
      if(rightN == null) return leftN == null;  
      if(leftN.val != rightN.val) return false;  
        
      return isSym(leftN.left, rightN.right) && isSym(leftN.right, rightN.left);  
    }      
}