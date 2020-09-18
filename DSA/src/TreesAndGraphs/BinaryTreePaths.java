package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

import TreesAndGraphs.RootToLeafSum.TreeNode;

public class BinaryTreePaths {
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
		BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
		TreeNode node4 = new TreeNode(4);
		TreeNode node9 = new TreeNode(9);
		TreeNode node0 = new TreeNode(0);
		TreeNode node5 = new TreeNode(5);
		TreeNode node1 = new TreeNode(1);
		node4.left = node9;
		node4.right = node0;
		node9.left = node5;
		node9.right = node1;
		System.out.println(binaryTreePaths.binaryTreePaths(node4));
	}

	public List<String> binaryTreePaths(TreeNode root) {
		return binaryTreePaths(root, "");
	}

	public List<String> binaryTreePaths(TreeNode root, String incomingStr) {
		if (root == null) {
			return null;
		}
		String currStr = (incomingStr.length() == 0 ? "" : incomingStr + "->") + root.val;
		if (root.left == null && root.right == null) {
			List<String> res = new ArrayList<String>();
			res.add(currStr);
			return res;
		}
		List<String> res = new ArrayList<String>();
		if (root.left != null) {
			res.addAll(binaryTreePaths(root.left, currStr));
		}
		if (root.right != null) {
			res.addAll(binaryTreePaths(root.right, currStr));
		}
		return res;
	}
}
