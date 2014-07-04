//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its bottom-up level order traversal as:
//[
//  [15,7],
//  [9,20],
//  [3]
//]
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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<ArrayList<Integer>>();
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();        
        ArrayList<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        
        while(!level.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
            for(int i = 0; i<level.size();i++){
                temp.add(level.get(i).val);
                if(level.get(i).left != null) curr.add(level.get(i).left);                
                if(level.get(i).right != null) curr.add(level.get(i).right);               
            }            
            result.add(temp);
            level = curr;
        }
        
        Collections.reverse(result);
        return result;
    }
}

