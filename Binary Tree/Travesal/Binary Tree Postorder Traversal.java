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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        TreeNode lastvisited = null;

        while(!stack.isEmpty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode peek = stack.peek();
                if(peek.right != null && lastvisited != peek.right){
                    curr = peek.right;
                }else{
                    result.add(peek.val);
                    lastvisited = stack.pop();
                }
            }
        }
        return result;
    }
}
