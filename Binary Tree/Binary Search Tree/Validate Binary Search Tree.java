// Given a binary tree, determine if it is a valid binary search tree (BST).
// Assume a BST is defined as follows:
// 	• The left subtree of a node contains only nodes with keys less than the node's key.
// 	• The right subtree of a node contains only nodes with keys greater than the node's key.
// 	• Both the left and right subtrees must also be binary search trees.
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
	public static boolean isValidBST(TreeNode root) {
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
 
	public static boolean validate(TreeNode root, int min, int max) {
		if (root == null) return true;

		// not in range
		if (root.val <= min || root.val >= max) return false;
		 
		// left subtree must be < root.val && right subtree must be > root.val
		return validate(root.left, min, root.val) && validate(root.right, root.val, max);
	}
}
