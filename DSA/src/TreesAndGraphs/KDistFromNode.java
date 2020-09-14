//https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
package TreesAndGraphs;

public class KDistFromNode {

	public static void main(String[] args) {
		BinaryTreeNode tree3 = new BinaryTreeNode(3);
		BinaryTreeNode tree5 = new BinaryTreeNode(5);
		BinaryTreeNode tree1 = new BinaryTreeNode(1);
		BinaryTreeNode tree6 = new BinaryTreeNode(6);
		BinaryTreeNode tree2 = new BinaryTreeNode(2);
		BinaryTreeNode tree7 = new BinaryTreeNode(7);
		BinaryTreeNode tree4 = new BinaryTreeNode(4);
		BinaryTreeNode tree0 = new BinaryTreeNode(0);
		BinaryTreeNode tree8 = new BinaryTreeNode(8);
 
		tree3.setLeftNode(tree5);
		tree3.setRightNode(tree1);
		tree5.setLeftNode(tree6);
		tree5.setRightNode(tree2);
		tree1.setLeftNode(tree0);
		tree1.setRightNode(tree8);
		tree2.setLeftNode(tree7);
		tree2.setRightNode(tree4);
		KDistFromNode kDistFromNode = new KDistFromNode();
		kDistFromNode.printKDistAnces(tree3, tree5, 2);
	}

	private void printKDistDown(BinaryTreeNode target, int n, boolean visitLeft, boolean visitRight) {
		if (target == null || n < 0) {
			return;
		}
		if (n == 0) {
			System.out.println(target.getData());
		}
		if (visitLeft) {
			printKDistDown(target.getLeftNode(), n - 1, visitLeft, visitRight);
		}
		if (visitRight) {
			printKDistDown(target.getRightNode(), n - 1, visitLeft, visitRight);
		}
	}


	private int printKDistAnces(BinaryTreeNode node, BinaryTreeNode target, int n) {
		if (node == null) {
			return -1;
		}
		if (node == target) {
			printKDistDown(node, n, true, true);
			return 0;
		}
		int r1 = printKDistAnces(node.getLeftNode(), target, n);
		if (r1 != -1) {
			r1 = r1 + 1;
			if (n == r1) {
				System.out.println(node.getLeftNode().getData());
				return -1;
			} else {
				printKDistDown(node, n - r1, false, true);
				return r1;
			}
		} else {
			r1 = printKDistAnces(node.getRightNode(), target, n);
			if (r1 != -1) {
				r1 = r1 + 1;
				if (n == r1) {
					System.out.println(node.getRightNode().getData());
					return -1;
				} else {
					printKDistDown(node, n - r1, true, false);
					return r1;
				}
			} else {
				return -1;
			}
		}
	}

}
