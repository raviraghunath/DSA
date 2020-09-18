package TreesAndGraphs;

import TreesAndGraphs.PathSumIII.TreeNode;

public class MaxPathInBT {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(-1);
		TreeNode nodem2 = new TreeNode(-2);
		TreeNode nodem3 = new TreeNode(-3);
		TreeNode node3 = new TreeNode(3);
		TreeNode node_m2 = new TreeNode(-2);
		TreeNode node_1 = new TreeNode(1);
		TreeNode nodem1 = new TreeNode(-1);
		node1.left = nodem2;
		node1.right = nodem3;
		nodem2.right = node3;
		nodem3.right = node_m2;
		node3.right = node_1;
		node_m2.right = nodem1;

		System.out.println(new MaxPathInBT().maxPathSum(node1));
	}

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int i1 = maxPathSum(root.left);
		int i2 = maxPathSum(root.right);

		int res = Math.max(i1, i2);
		res = Math.max(root.val, res);
		if (i1 != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE) {
			res = Math.max(root.val + i1 + i2, res);
		}
		if (i1 != Integer.MIN_VALUE) {
			res = Math.max(root.val + i1, res);
		}
		if (i2 != Integer.MIN_VALUE) {
			res = Math.max(root.val + i2, res);
		}
		return res;

	}
}
