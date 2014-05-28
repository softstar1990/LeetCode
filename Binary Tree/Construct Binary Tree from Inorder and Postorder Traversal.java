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
  
    public static TreeNode buildTree(int[] inorder, int[] postorder) {  
        if(inorder.length == 0){  
            return null;  
        }  
        return rec(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);  
    }  
      
    public static TreeNode rec(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd){  
        if(postEnd < 0 || postEnd>=postorder.length){  
            return null;  
        }  
        TreeNode root = new TreeNode(postorder[postEnd]);  
        int rootIndex;          // rootIndex in inorder[]  
        for(rootIndex=0; rootIndex<inorder.length; rootIndex++) {  
            if(inorder[rootIndex] == postorder[postEnd]){  
                break;  
            }  
        }  
          
        int leftSubTreeLen = rootIndex - inStart;       
        if(rootIndex > inStart){     
            root.left = rec(inorder, postorder, inStart, rootIndex-1, postStart, postStart+leftSubTreeLen-1);  
        }  
        if(rootIndex < inEnd){  
            root.right = rec(inorder, postorder, rootIndex+1, inEnd, postStart+leftSubTreeLen, postEnd-1);  
        }  
          
        return root;  
    }  
}
