package TreesAndGraphs;

public class SubTreeCheck {
	public static void main(String[] args) {
		SubTreeCheck check = new SubTreeCheck();
		System.out.println(check.isSubTree(BinaryTreeNode.getBinaryTree(), BinaryTreeNode.getBinaryTree()));
		System.out.println(check.isSubTreeV1(BinaryTreeNode.getBinaryTree(), BinaryTreeNode.getBinaryTree()));

	}

	private boolean isSubTreeV1(BinaryTreeNode n1, BinaryTreeNode n2) {
		if (n1 == null) {
			return false;
		}
		if (n2 == null) {
			return true;
		}
		return subTree(n1, n2);
	}

	private boolean subTree(BinaryTreeNode n1, BinaryTreeNode n2) {
		if (n1.getData() == n2.getData() && checkSameTree(n1, n2)) {
			return true;
		}
		return subTree(n1.getLeftNode(), n2) || subTree(n1.getRightNode(), n2);
	}

	private boolean isSubTree(BinaryTreeNode n1, BinaryTreeNode n2) {
		n1 = getNode(n1, n2);
		return checkSameTree(n1, n2);
	}

	private boolean checkSameTree(BinaryTreeNode n1, BinaryTreeNode n2) {
		if (n1 == null && n2 == null) {
			return true;
		} else if (n1 == null) {
			return false;
		} else if (n2 == null) {
			return false;
		} else if (n1.getData() != n2.getData()) {
			return false;
		}
		return checkSameTree(n1.getLeftNode(), n2.getLeftNode()) && checkSameTree(n1.getRightNode(), n2.getRightNode());
	}

	private BinaryTreeNode getNode(BinaryTreeNode node, BinaryTreeNode tNode) {
		if (node == null) {
			return null;
		}
		if (node.getData() == tNode.getData()) {
			return node;
		}
		BinaryTreeNode btn1 = getNode(node.getLeftNode(), tNode);
		BinaryTreeNode btn2 = getNode(node.getRightNode(), tNode);
		return btn1 == null ? btn2 == null ? null : btn2 : btn1;
	}

}
