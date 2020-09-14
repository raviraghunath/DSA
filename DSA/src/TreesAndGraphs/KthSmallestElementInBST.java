package TreesAndGraphs;

import java.util.HashMap;
import java.util.Map;

public class KthSmallestElementInBST {

	public static void main(String[] args) {
		BinaryTreeNode node20 = new BinaryTreeNode(20);
		BinaryTreeNode node8 = new BinaryTreeNode(8);
		BinaryTreeNode node22 = new BinaryTreeNode(22);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node12 = new BinaryTreeNode(12);
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node14 = new BinaryTreeNode(14);

		node20.setLeftNode(node8);
		node20.setRightNode(node22);
		node8.setLeftNode(node4);
		node8.setRightNode(node12);
		node12.setLeftNode(node10);
		node12.setRightNode(node14);

		KthSmallestElementInBST kthSmallestElementInBST = new KthSmallestElementInBST();
		System.out.println(kthSmallestElementInBST.getKthSmallestNode(node20, 3));
	}

	private BinaryTreeNode getKthSmallestNode(BinaryTreeNode node, int K) {
		Map<BinaryTreeNode, Integer> lCounts = new HashMap<BinaryTreeNode, Integer>();
		fillMap(node, lCounts);
		System.out.println(lCounts);
		return getKthSmallestNode(node, lCounts, K);
	}

	private BinaryTreeNode getKthSmallestNode(BinaryTreeNode node, Map<BinaryTreeNode, Integer> lCounts, int K) {
		if (node == null) {
			return null;
		}
		int val = lCounts.get(node);
		if (K == (val + 1)) {
			return node;
		} else if (K > (val + 1)) {
			return getKthSmallestNode(node.getRightNode(), lCounts, K - (val + 1));
		} else {
			return getKthSmallestNode(node.getLeftNode(), lCounts, K);
		}
	}

	private int fillMap(BinaryTreeNode node, Map<BinaryTreeNode, Integer> lCounts) {

		if (node == null) {
			return 0;
		}
		int val1 = fillMap(node.getLeftNode(), lCounts);
		lCounts.put(node, val1);
		int val2 = fillMap(node.getRightNode(), lCounts);
		return val1 + val2 + 1;
	}

}
