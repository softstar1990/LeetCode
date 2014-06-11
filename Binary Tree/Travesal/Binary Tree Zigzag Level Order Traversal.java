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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        
        ArrayList<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        
        while(!level.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
            
            for(int i = 0; i < level.size(); i++){
                if(level.get(i).left != null) curr.add(level.get(i).left);
                if(level.get(i).right != null) curr.add(level.get(i).right);
                temp.add(level.get(i).val);
            }
            
            result.add(temp);
            level = curr;
        }
        
        for(int i = 0; i < result.size(); i++){
            if(i%2 == 1){
                ArrayList<Integer> curr = result.get(i);
                Stack<Integer> stack = new Stack<Integer>();
                for(int j = 0; j < curr.size(); j++){
                    stack.push(curr.get(j));
                }
                curr = new ArrayList<Integer>();
                while(!stack.isEmpty()){
                    curr.add(stack.pop());
                }
                result.set(i,curr);
            }
        }
        return result;
    }
}
