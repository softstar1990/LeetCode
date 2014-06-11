/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return rec(1,n);
    }
    private ArrayList<TreeNode> rec(int start,int end){
        ArrayList<TreeNode> result = new ArrayList<>();
        if(start>end){
            result.add(null);
            return result;
        }
        for(int i=start;i<=end;i++){
            ArrayList<TreeNode> lefts = rec(start,i-1);
            ArrayList<TreeNode> rights = rec(i+1,end);
            for(TreeNode left:lefts){
                for(TreeNode right:rights){
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }
        return result;
    }

}