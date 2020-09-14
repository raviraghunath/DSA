package TreesAndGraphs;

public class HeightOfBT {
	public static void main(String[] args) {
		HeightOfBT balanced = new HeightOfBT();
		System.out.println(balanced.getHeight(BinaryTreeNode.getBinaryTree()));

	}

	private int getHeight(BinaryTreeNode node) {
		return node == null ? 0 : 1 + Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode()));
	}
}
