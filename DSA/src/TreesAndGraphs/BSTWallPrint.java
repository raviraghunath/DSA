package TreesAndGraphs;

public class BSTWallPrint {
	public static void main(String[] args) {
		BSTWallPrint bstWallPrint = new BSTWallPrint();
		bstWallPrint.printWall(BinaryTreeNode.getBinaryTree());

	}

	private void printWall(BinaryTreeNode Tnode) {
		BinaryTreeNode node = Tnode;
		while (null != node) {
			System.out.print(node.getData() + ",");
			if (node.getLeftNode() != null) {
				node = node.getLeftNode();
			} else {
				node = null;
			}
		}
		System.out.println();
		node = Tnode;
		while (null != node) {
			System.out.print(node.getData() + ",");
			if (node.getRightNode() != null) {
				node = node.getRightNode();
			} else {
				node = null;
			}
		}
		System.out.println();
		BinaryTreeNode lnode = Tnode.getLeftNode();
		BinaryTreeNode rnode = Tnode.getRightNode();
		System.out.println(Tnode.getData());
		while (lnode != null || rnode != null) {
			if (lnode != null) {
				System.out.print(lnode.getData() + ",");
				lnode = lnode.getLeftNode();
			}
			if (rnode != null) {
				if (rnode != null) {
					System.out.print(rnode.getData() + ",");
					rnode = rnode.getRightNode();
				}
			}
		}
	}
}
