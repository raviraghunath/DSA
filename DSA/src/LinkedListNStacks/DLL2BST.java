package LinkedListNStacks;
import TreesAndGraphs.BinaryTreeNode;
import TreesAndGraphs.InOrderTraversal;

public class DLL2BST { 

	public static void main(String[] args) {
		DLL2BST dll2bst = new DLL2BST();
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
		binaryTreeNode1.setRightNode(binaryTreeNode2);
		binaryTreeNode2.setLeftNode(binaryTreeNode1);
		binaryTreeNode2.setRightNode(binaryTreeNode3);
		binaryTreeNode3.setLeftNode(binaryTreeNode2);
		binaryTreeNode3.setRightNode(binaryTreeNode4);
		binaryTreeNode4.setLeftNode(binaryTreeNode3);
		binaryTreeNode4.setRightNode(binaryTreeNode5);
		binaryTreeNode5.setLeftNode(binaryTreeNode4);
		binaryTreeNode5.setRightNode(binaryTreeNode6);
		binaryTreeNode6.setLeftNode(binaryTreeNode5);
		binaryTreeNode6.setRightNode(binaryTreeNode7);
		binaryTreeNode7.setLeftNode(binaryTreeNode6);
		binaryTreeNode7.setRightNode(binaryTreeNode8);
		binaryTreeNode8.setLeftNode(binaryTreeNode7);
		binaryTreeNode8.setRightNode(binaryTreeNode9);
		binaryTreeNode9.setLeftNode(binaryTreeNode8);
		binaryTreeNode9.setRightNode(binaryTreeNode10);
		binaryTreeNode10.setLeftNode(binaryTreeNode9);
		binaryTreeNode10.setRightNode(binaryTreeNode11);
		binaryTreeNode11.setLeftNode(binaryTreeNode10);
		binaryTreeNode11.setRightNode(binaryTreeNode12);
		binaryTreeNode12.setLeftNode(binaryTreeNode11);
		BinaryTreeNode root = dll2bst.convertToBST(binaryTreeNode1, 12);
		System.out.println(root.getData());
		InOrderTraversal traversal = new InOrderTraversal();
		traversal.printInorder(root);
	}

	private BinaryTreeNode convertToBST(BinaryTreeNode node, int len) {
		if (node == null) {
			return null;
		}
		if (len == 1) {
			node.setLeftNode(null);
			node.setRightNode(null);
			return node;
		}
		if (len == 2) {
			node.setLeftNode(null);
			BinaryTreeNode rNode = node.getRightNode();
			node.setRightNode(null);
			rNode.setRightNode(null);
			return rNode;
		}
		int mid = (len / 2) + 1;
		BinaryTreeNode root = getBinaryTreeNode(node, mid);
		BinaryTreeNode left = convertToBST(node, mid - 1);
		root.setLeftNode(left);
		BinaryTreeNode right = convertToBST(root.getRightNode(), len - mid);
		root.setRightNode(right);
		return root;
	}

	private BinaryTreeNode getBinaryTreeNode(BinaryTreeNode node, int pos) {
		BinaryTreeNode ptr = node;
		int len = 0;
		while (ptr != null) {
			len++;
			if (len == pos) {
				break;
			}
			if (ptr.getRightNode() != null) {
				ptr = ptr.getRightNode();
			}
		}
		return ptr;
	}

}
