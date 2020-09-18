package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {

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
		TreePathSum treePathSum = new TreePathSum();
		TreeNode node5 = new TreeNode(5);
		TreeNode node4 = new TreeNode(4);
		TreeNode node8 = new TreeNode(8);
		TreeNode node11 = new TreeNode(11);
		TreeNode node13 = new TreeNode(13);
		TreeNode node_4 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		TreeNode node2 = new TreeNode(2);
		TreeNode node_5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		node5.left = node4;
		node5.right = node8;
		node4.left = node11;
		node8.left = node13;
		node8.right = node_4;
		node11.left = node7;
		node11.right = node2;
		node_4.left = node_5;
		node_4.right = node1;

		System.out.println(treePathSum.pathSum(node5, 22));
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		return pathSum(root, 22, new ArrayList<Integer>());
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum, List<Integer> list) {
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}

		sum -= root.val;
		list.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				List<List<Integer>> res = new ArrayList<List<Integer>>();
				res.add(list);
				return res;
			} else {
				return new ArrayList<List<Integer>>();
			}
		}

		List<List<Integer>> res = new ArrayList<List<Integer>>();

		List<Integer> r1 = new ArrayList<Integer>();
		r1.addAll(list);
		List<List<Integer>> res1 = pathSum(root.left, sum, r1);
		if (res1 != null) {
			res.addAll(res1);
		}

		List<Integer> r2 = new ArrayList<Integer>();
		r2.addAll(list);
		List<List<Integer>> res2 = pathSum(root.right, sum, r2);
		if (res2 != null) {
			res.addAll(res2);
		}

		return res;

	}

}
