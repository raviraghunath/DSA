package TreesAndGraphs;

public class VisibleNodes {

	public static void main(String[] args) {
		VisibleNodes nodes = new VisibleNodes();
		BinaryTreeNode node5 = new BinaryTreeNode(5);
		BinaryTreeNode node3 = new BinaryTreeNode(3);
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node20 = new BinaryTreeNode(20);
		BinaryTreeNode node21 = new BinaryTreeNode(21);
		BinaryTreeNode node1 = new BinaryTreeNode(1);
		node5.setLeftNode(node3);
		node5.setRightNode(node10);
		node10.setLeftNode(node1);
		node3.setLeftNode(node20);
		node3.setRightNode(node21);

		BinaryTreeNode node_10 = new BinaryTreeNode(-10);
		BinaryTreeNode node_15 = new BinaryTreeNode(-15);
		BinaryTreeNode node_1 = new BinaryTreeNode(-1);
		node_10.setRightNode(node_15);
		node_15.setRightNode(node_1);

		System.out.println(nodes.countVisibleNodes(node5, node5.getData()));
		System.out.println(nodes.countVisibleNodes(node_10, node_10.getData()));
	}

	private int countVisibleNodes(BinaryTreeNode node, int max) {
		if (node == null) {
			return 0;
		}
		if (node.getData() >= max) {
			return 1 + countVisibleNodes(node.getLeftNode(), node.getData())
					+ countVisibleNodes(node.getRightNode(), node.getData());
		} else {
			return countVisibleNodes(node.getLeftNode(), max) + countVisibleNodes(node.getRightNode(), max);
		}
	}

}
