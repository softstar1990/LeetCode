// Given a binary tree, find the maximum path sum.
// The path may start and end at any node in the tree.
// For example:
// Given the below binary tree,
//        1
//       / \
//      2   3
// Return 6.
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
	public int maxPathSum(TreeNode root) {
		int max[] = new int[1]; 
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}
 
	public int calculateSum(TreeNode root, int[] max) {
		//this funtion return maxSum we can get from a path(from this root to leaf, but may not end with leaf)
		//max[0] is used as global var, store the maxSum we ever get for the problem
		if (root == null) return 0;
 
		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
 
		int current = Math.max(0, Math.max(left, right)) + root.val;
 
		max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
 
		return current;
	}
}