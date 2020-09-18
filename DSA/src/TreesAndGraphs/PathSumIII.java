//https://leetcode.com/problems/path-sum-iii/
package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {

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
		PathSumIII pathSumIII = new PathSumIII();
		TreeNode node10 = new TreeNode(10);
		TreeNode node5 = new TreeNode(5);
		TreeNode nodem3 = new TreeNode(-3);
		TreeNode node3 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node11 = new TreeNode(11);
		TreeNode node_3 = new TreeNode(3);
		TreeNode nodem2 = new TreeNode(-2);
		TreeNode node1 = new TreeNode(1);
		node10.left = node5;
		node10.right = nodem3;
		node5.left = node3;
		node5.right = node2;
		nodem3.right = node11;
		node3.left = node_3;
		node3.right = nodem2;
		node2.right = node1;
		System.out.println(pathSumIII.pathSum(node10, 8));
	}

	public int pathSum(TreeNode root, int sum) {
		return pathSum(root, sum, new ArrayList<Integer>());
	}

	public int pathSum(TreeNode root, int sum, List<Integer> list) {
		if (root == null) {
			return 0;
		}
		list.add(root.val);
		int currRes = hasSubArrayWithSumStartingLastIndex(list, sum);
		int res = currRes;
		List<Integer> list1 = new ArrayList<Integer>();
		list1.addAll(list);
		if (root.left != null) {
			res += pathSum(root.left, sum, list1);
		}
		List<Integer> list2 = new ArrayList<Integer>();
		list2.addAll(list);
		if (root.right != null) {
			res += pathSum(root.right, sum, list2);
		}
		return res;
	}

	public int hasSubArrayWithSumStartingLastIndex(List<Integer> arr, int sum) {
		int currSum = 0;
		for (int i = arr.size() - 1; i >= 0; i--) {
			currSum += arr.get(i);
		}
		int res = 0;
		if (currSum == sum) {
			res++;
		}
		for (int i = 0; i < arr.size() - 1; i++) {
			currSum -= arr.get(i);
			if (currSum == sum) {
				res++;
			}
		}
		return res;
	}
}
