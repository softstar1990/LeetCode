/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		TreeLinkNode nextHead = null;
		TreeLinkNode p = root;
		TreeLinkNode pre = null;
		while (p != null) {
			if (p.left != null) {
				if (pre == null) {
					pre = p.left;
					nextHead = pre;
				} else {
					pre.next = p.left;
					pre = pre.next;
				}
			}
			if (p.right != null) {
				if (pre == null) {
					pre = p.right;
					nextHead = pre;
				} else {
					pre.next = p.right;
					pre = pre.next;
				}
			}
			p = p.next;
			if (p == null) {
				p = nextHead;
				nextHead = null;
				pre = null;
			}
		}
	}
}
