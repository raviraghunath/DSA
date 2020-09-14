package TreesAndGraphs;

public class LongestConsecutiveBranch {

	public static void main(String[] args) {
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		BinaryTreeNode node2 = new BinaryTreeNode(2);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node4 = new BinaryTreeNode(4);
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node6 = new BinaryTreeNode(6);
		BinaryTreeNode node7 = new BinaryTreeNode(7);

		node1.setLeftNode(node2);
		node1.setRightNode(node4);
		node2.setLeftNode(node3);
		node4.setLeftNode(node5);
		node4.setRightNode(node6);
		node6.setLeftNode(node7);

		LongestConsecutiveBranch longestConsecutiveBranch = new LongestConsecutiveBranch();
		System.out.println(longestConsecutiveBranch.getLongestConsecutiveBranchLen(node1));
	}

	private int getLongestConsecutiveBranchLen(BinaryTreeNode node) {
		return Math.max(getLongestConsecutiveBranchLen(node.getRightNode(), node.getData()),
				getLongestConsecutiveBranchLen(node.getLeftNode(), node.getData())) + 1;
	}

	private int getLongestConsecutiveBranchLen(BinaryTreeNode node, int parentVal) {
		if (node == null) {
			return 0;
		}
		if (node.getData() == parentVal + 1) {
			int r1 = getLongestConsecutiveBranchLen(node.getLeftNode(), node.getData());
			int r2 = getLongestConsecutiveBranchLen(node.getRightNode(), node.getData());
			return 1 + Math.max(r1, r2);
		} else {
			int r1 = getLongestConsecutiveBranchLen(node.getLeftNode(), node.getData());
			int r2 = getLongestConsecutiveBranchLen(node.getRightNode(), node.getData());
			return Math.max(r1, r2);
		}
	}

}
