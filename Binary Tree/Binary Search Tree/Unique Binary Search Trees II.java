// Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
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