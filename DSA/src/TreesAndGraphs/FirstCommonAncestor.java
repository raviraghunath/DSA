package TreesAndGraphs;

public class FirstCommonAncestor {
	public static void main(String[] args) {
		FirstCommonAncestor ancestor = new FirstCommonAncestor();
		BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
		BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
		BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
		BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
		BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);

		binaryTreeNode1.setLeftNode(binaryTreeNode2);
		binaryTreeNode2.setLeftNode(binaryTreeNode4);
		binaryTreeNode2.setRightNode(binaryTreeNode5);
		binaryTreeNode1.setRightNode(binaryTreeNode3);

		System.out.println(ancestor.findCommonAncestor(binaryTreeNode1, binaryTreeNode5, binaryTreeNode3).getData());
	}

	private BinaryTreeNode findCommonAncestor(BinaryTreeNode n, BinaryTreeNode n1, BinaryTreeNode n2) {
		if (n == null) {
			return null;
		}
		if (n == n1 || n == n2) {
			return n;
		}
		BinaryTreeNode btn1 = findCommonAncestor(n.getLeftNode(), n1, n2);
		BinaryTreeNode btn2 = findCommonAncestor(n.getRightNode(), n1, n2);
		return btn2 != null && btn1 != null ? n : btn1 != null ? btn1 : btn2;
	}
}
