// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
        if(num.length == 0) return null;
        return rec(num, 0, num.length);
    }
    
    public TreeNode rec(int[] num, int low, int high){
        if(low == high) return null;
        
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = rec(num, low, mid);       
        root.right = rec(num, mid+1, high);

        return root;
    }
}
