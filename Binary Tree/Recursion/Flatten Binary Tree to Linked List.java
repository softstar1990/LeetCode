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
    public void flatten(TreeNode root) {
        rec(root, null);
    }
    
    public TreeNode rec(TreeNode root, TreeNode tail){
        if(root == null) return tail;
        
        TreeNode right = rec(root.right, tail);
        root.right = rec(root.left, right);
        root.left = null;
        return root;
    }    
}