// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        pathSum(root, sum, result, new ArrayList<Integer>());
        return result;
    }
    
    private void pathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list){
        if(root == null) return;

        list.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0){ //root-to-leaf paths
            result.add(new ArrayList<Integer>(list));
        }else{
            pathSum(root.left, sum, result, list);
            pathSum(root.right, sum, result, list);
        }
        list.remove(list.size() - 1);
    }
}