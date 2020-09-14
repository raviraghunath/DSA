package TreesAndGraphs;

public class CheckBalanced {
	public static void main(String[] args) {
		CheckBalanced balanced = new CheckBalanced();
		System.out.println(balanced.isBalanced(BinaryTreeNode.getBinaryTree()));
	}

	private boolean isBalanced(BinaryTreeNode node) {
		if (node == null) {
			return true;
		}
		return Math.abs(getHeight(node.getLeftNode()) - getHeight(node.getRightNode())) <= 1;
	}

	private int getHeight(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode()));
	}
}
