package TreesAndGraphs;

public class BSTorNot {

	static class Res {
		int rightMostLeftChild;
		int leftMostRightChild;
		boolean isBst;
	}

	public static void main(String[] args) {
		BSTorNot bsTorNot = new BSTorNot();
		BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
		BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
		BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
		BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
		BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);

		binaryTreeNode1.setLeftNode(binaryTreeNode2);
		binaryTreeNode2.setLeftNode(binaryTreeNode4);
		binaryTreeNode2.setRightNode(binaryTreeNode5);
		binaryTreeNode1.setRightNode(binaryTreeNode3);
		System.out.println(bsTorNot.isBST(binaryTreeNode1));
		System.out.println(bsTorNot.isBST_V1(binaryTreeNode1).isBst);
		System.out.println("V2");
		System.out.println(bsTorNot.isBST_V2(binaryTreeNode1, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(bsTorNot.isBST(BinaryTreeNode.getBinaryTree()));
		System.out.println(bsTorNot.isBST_V1(BinaryTreeNode.getBinaryTree()).isBst);
		System.out.println("V2");
		System.out.println(bsTorNot.isBST_V2(BinaryTreeNode.getBinaryTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	private boolean isBST_V2(BinaryTreeNode node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.getData() <= min || node.getData() > max) {
			return false;
		}
		return isBST_V2(node.getLeftNode(), min, node.getData()) && isBST_V2(node.getRightNode(), node.getData(), max);
	}

	private Res isBST_V1(BinaryTreeNode node) {

		Res r1 = node.getLeftNode() == null ? null : isBST_V1(node.getLeftNode());
		Res r2 = node.getRightNode() == null ? null : isBST_V1(node.getRightNode());

		Res res1 = new Res();

		res1.rightMostLeftChild = r1 != null ? r1.rightMostLeftChild : node.getData();

		res1.leftMostRightChild = r2 != null ? r2.leftMostRightChild : node.getData();

		boolean l = node.getLeftNode() != null ? res1.rightMostLeftChild < node.getData() : true;
		boolean r = node.getRightNode() != null ? node.getData() < res1.leftMostRightChild : true;

		res1.isBst = ((r1 != null) ? r1.isBst : true && (r2 != null) ? r2.isBst : true) && l && r;

		return res1;

	}

	private boolean isBST(BinaryTreeNode node) {
		if (node == null) {
			return true;
		}
		int rightostValueOfLeftChile = Integer.MIN_VALUE;
		if (node.getLeftNode() != null)
			rightostValueOfLeftChile = getRightMostValue(node.getLeftNode());
		int leftostValueOfRightChile = Integer.MAX_VALUE;
		if (node.getRightNode() != null)
			leftostValueOfRightChile = getLeftMostValue(node.getRightNode());

		return isBST(node.getLeftNode()) && isBST(node.getRightNode()) && rightostValueOfLeftChile <= node.getData()
				&& node.getData() <= leftostValueOfRightChile;

	}

	private int getRightMostValue(BinaryTreeNode node) {
		if (node.getRightNode() == null) {
			return node.getData();
		}
		return getRightMostValue(node.getRightNode());
	}

	private int getLeftMostValue(BinaryTreeNode node) {
		if (node.getLeftNode() == null) {
			return node.getData();
		}
		return getLeftMostValue(node.getLeftNode());
	}

}
