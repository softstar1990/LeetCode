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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        
        return rec(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    
    public TreeNode rec(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart >= preorder.length || preEnd < 0) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex;
        for(rootIndex = inStart; rootIndex <= inEnd; rootIndex++ ){
            if(inorder[rootIndex] == preorder[preStart]) break;
        }
        
        int len = rootIndex - inStart; //length of left subtree
        if(rootIndex > inStart){ //have left subtree actually
            root.left = rec(preorder, inorder, preStart+1, preStart+len, inStart, rootIndex-1);
        }
        if(rootIndex < inEnd){ //have right subtree
            root.right = rec(preorder, inorder, preStart+len+1, preEnd, rootIndex+1, inEnd);
        }
        return root;
    }
}
