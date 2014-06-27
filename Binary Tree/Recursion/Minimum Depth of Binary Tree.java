// Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left != null && root.right == null){
            return minDepth(root.left)+1;
        }else if(root.left == null && root.right != null){
            return minDepth(root.right)+1;
        }else{
            return Math.min(minDepth(root.left)+1, minDepth(root.right)+1);
        }
    }
}
