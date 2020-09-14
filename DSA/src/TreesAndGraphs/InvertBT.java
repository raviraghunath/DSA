package TreesAndGraphs;

public class InvertBT {

	public static void main(String[] args) {
		InvertBT invertBT = new InvertBT();
		BinaryTreeNode binaryTreeNode = BinaryTreeNode.getBinaryTree();
		InOrderTraversal inOrderTraversal = new InOrderTraversal();
		inOrderTraversal.printInorder(binaryTreeNode);
		System.out.println();
		invertBT.invert(binaryTreeNode);
		inOrderTraversal.printInorder(binaryTreeNode);
	}

	private void invert(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null) {
			return;
		}
		BinaryTreeNode l = binaryTreeNode.getLeftNode();
		BinaryTreeNode r = binaryTreeNode.getRightNode();
		binaryTreeNode.setLeftNode(r);
		binaryTreeNode.setRightNode(l);
		invert(binaryTreeNode.getLeftNode());
		invert(binaryTreeNode.getRightNode());
	}

}
