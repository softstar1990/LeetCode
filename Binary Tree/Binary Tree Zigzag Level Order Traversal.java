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
        
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        
        while(!curr.isEmpty()){
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            ArrayList<Integer> row = new ArrayList<Integer>();
            
            for(int i = 0; i < curr.size(); i++){
                if(curr.get(i).left != null) temp.add(curr.get(i).left);
                if(curr.get(i).right != null) temp.add(curr.get(i).right);
                row.add(curr.get(i).val);
            }
            
            result.add(row);
            curr = temp;
        }
        
        for(int i = 0; i < result.size(); i++){
            if(i%2 == 1){
                ArrayList<Integer> temp = result.get(i);
                Stack<Integer> stack = new Stack<Integer>();
                for(int j = 0; j < temp.size(); j++){
                    stack.push(temp.get(j));
                }
                temp = new ArrayList<Integer>();
                while(!stack.isEmpty()){
                    temp.add(stack.pop());
                }
                result.set(i,temp);
            }
        }
        return result;
    }
}
