// Two elements of a binary search tree (BST) are swapped by mistake.
// Recover the tree without changing its structure
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
    TreeNode p,q;  
    TreeNode pre;  
    public void recoverTree(TreeNode root) {  
        if (root == null) return;  
        getWrong(root);  
        int tmp = p.val;  
        p.val = q.val;  
        q.val = tmp;  
    }  
    public void getWrong(TreeNode root) {  
        if (root == null) return;  
        getWrong(root.left);  
        if (pre != null && root.val < pre.val) {  
            if (p == null) {  
                p = pre;  
                q = root;  
            }  
            else   
                q = root;  
        }  
        pre = root;  
        getWrong(root.right);  
    }  
}  