package TreesAndGraphs;
public class BinaryTreeNode {

	private final int data;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;

	public BinaryTreeNode(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}

	public int getData() {
		return data;
	}

	@Override
	public String toString() {
		return "TreeNode : " + data;
	}

	public static BinaryTreeNode getBinaryTree() {
		BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
		BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
		BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
		BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
		BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
		BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);
		BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
		BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(8);
		BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(9);
		BinaryTreeNode binaryTreeNode10 = new BinaryTreeNode(10);
		BinaryTreeNode binaryTreeNode11 = new BinaryTreeNode(11);
		BinaryTreeNode binaryTreeNode12 = new BinaryTreeNode(12);
		BinaryTreeNode binaryTreeNode13 = new BinaryTreeNode(13);
		BinaryTreeNode binaryTreeNode14 = new BinaryTreeNode(14);

		binaryTreeNode8.leftNode = binaryTreeNode3;
		binaryTreeNode8.rightNode = binaryTreeNode10;
		binaryTreeNode3.leftNode = binaryTreeNode1;
		binaryTreeNode3.rightNode = binaryTreeNode6;
		binaryTreeNode6.leftNode = binaryTreeNode4;
		binaryTreeNode6.rightNode = binaryTreeNode7;
		binaryTreeNode10.rightNode = binaryTreeNode14;
		binaryTreeNode14.leftNode = binaryTreeNode13;

		return binaryTreeNode8;
	}
}
