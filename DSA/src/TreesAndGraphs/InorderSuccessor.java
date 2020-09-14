package TreesAndGraphs;

public class InorderSuccessor {

	public static void main(String[] args) {
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

		binaryTreeNode8.setLeftNode(binaryTreeNode3);
		binaryTreeNode8.setRightNode(binaryTreeNode10);
		binaryTreeNode3.setLeftNode(binaryTreeNode1);
		binaryTreeNode3.setRightNode(binaryTreeNode6);
		binaryTreeNode6.setLeftNode(binaryTreeNode4);
		binaryTreeNode6.setRightNode(binaryTreeNode7);
		binaryTreeNode10.setRightNode(binaryTreeNode14);
		binaryTreeNode14.setLeftNode(binaryTreeNode13);

		InorderSuccessor inorderSuccessor = new InorderSuccessor();
		InOrderTraversal inOrderTraversal=new InOrderTraversal();
		inOrderTraversal.printInorder(binaryTreeNode8);
		System.out.println();
		System.out.println(inorderSuccessor.getInorderSuccessor(binaryTreeNode8, binaryTreeNode12, null));

	}

	private BinaryTreeNode getInorderSuccessor(BinaryTreeNode root, BinaryTreeNode node, BinaryTreeNode immLeftParent) {
		if (root == null || node == null) {
			return null;
		}
		if (root == node) {
			BinaryTreeNode node1 = getLeftMostNode(root.getRightNode());
			if (node1 == null) {
				return immLeftParent;	
			}else {
				return node1;
			}
		} else if (root.getData() > node.getData()) {
			return getInorderSuccessor(root.getLeftNode(), node, root);	
		} else {
			return getInorderSuccessor(root.getRightNode(), node, immLeftParent);	
		}

	}

	private BinaryTreeNode getLeftMostNode(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode == null) {
			return null;
		}
		if (binaryTreeNode.getLeftNode() != null) {
			return getLeftMostNode(binaryTreeNode.getLeftNode());
		} else {
			return binaryTreeNode;
		}
	}
}
