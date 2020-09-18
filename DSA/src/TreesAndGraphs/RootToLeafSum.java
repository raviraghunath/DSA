package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafSum {

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
		RootToLeafSum rootToLeafSum = new RootToLeafSum();
		TreeNode node4 = new TreeNode(4);
		TreeNode node9 = new TreeNode(9);
		TreeNode node0 = new TreeNode(0);
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		node4.left = node9;
		node4.right = node0;
		node9.left = node5;
		node9.right = node1;
		System.out.println(rootToLeafSum.sumNumbers(node4));

	}

	int highesLevel = 0;

	public int sumNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return sumNumbers(root, new ArrayList<Integer>());
	}

	public int sumNumbers(TreeNode root, List<Integer> list) {
		int res = 0;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			int j = list.size();
			for (Integer i : list) {
				res += (i * Math.pow(10, j - 1));
				j--;
			}
		} else {
			if (root.left != null) {
				List<Integer> list1 = new ArrayList<Integer>();
				list1.addAll(list);
				list1.add(root.val);
				res = sumNumbers(root.left, list1);
			}
			if (root.right != null) {
				List<Integer> list2 = new ArrayList<Integer>();
				list2.addAll(list);
				list2.add(root.val);
				res += sumNumbers(root.right, list2);
			}
		}

		return res;
	}

}
