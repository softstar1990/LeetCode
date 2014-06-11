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
    public TreeNode sortedArrayToBST(int[] num) {
        int low = 0;
        int high = num.length - 1;
        
        if(num.length == 0) return null;
        return rec(num, low, high);
    }
    
    public TreeNode rec(int[] num, int low, int high){
        if(low == high) return new TreeNode(num[low]);
        
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(num[mid]);
        
        if(mid > low) root.left = rec(num, low, mid-1);       
        if(mid < high) root.right = rec(num, mid+1, high);

        return root;
    }
}
