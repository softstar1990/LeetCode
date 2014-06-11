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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer> ();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if(root == null) return result;
        
        TreeNode curr = root;
        while(!stack.empty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode t = stack.pop();
                result.add(t.val);
                curr = t.right;
            }
        }
 
        return result;            
    }
}
