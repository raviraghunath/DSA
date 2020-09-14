package TreesAndGraphs;

import java.util.Stack;

public class PreOrderToBST {
	static class Index {
		int ind;

		Index(int ind) {
			this.ind = ind;
		}
	}

	public static void main(String[] args) {
		PreOrderToBST preOrderToBST = new PreOrderToBST();
		BinaryTreeNode treeNode = preOrderToBST.getBST(new int[] { 10, 5, 1, 7, 40, 50 });
		PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
		preOrderTraversal.printPreOrder(treeNode);
		System.out.println();
		Index index = new Index(0);
		treeNode = preOrderToBST.getBSTV2(new int[] { 10, 5, 1, 7, 40, 50 }, index, Integer.MIN_VALUE,
				Integer.MAX_VALUE);
		preOrderTraversal.printPreOrder(treeNode);
		System.out.println();
		treeNode = preOrderToBST.getBSTV3(new int[] { 10, 5, 1, 7, 40, 50 });
		preOrderTraversal.printPreOrder(treeNode);
		System.out.println();
		treeNode = preOrderToBST.getBSTV2_V1(new int[] { 10, 5, 1, 7, 40, 50 }, Integer.MIN_VALUE, Integer.MAX_VALUE);
		preOrderTraversal.printPreOrder(treeNode);
	}

	private BinaryTreeNode getBST(int[] arr) {
		return getBSTV1(arr, 0, arr.length - 1);
	}

	private BinaryTreeNode getBSTV3(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode root = new BinaryTreeNode(arr[0]);
		stack.push(root);
		BinaryTreeNode temp = null;
		for (int i = 1; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > stack.peek().getData()) {
				temp = stack.pop();
			}
			BinaryTreeNode node = new BinaryTreeNode(arr[i]);
			if (temp != null) {
				temp.setRightNode(node);
				stack.push(node);
			} else {
				stack.peek().setLeftNode(node);
				stack.push(node);
			}
		}
		return root;
	}

	private BinaryTreeNode getBSTV2(int[] arr, Index keyIndex, int min, int max) {
		if (keyIndex.ind >= arr.length) {
			return null;
		}
		BinaryTreeNode root = null;
		if (arr[keyIndex.ind] > min && arr[keyIndex.ind] < max) {
			root = new BinaryTreeNode(arr[keyIndex.ind]);
			keyIndex.ind++;
			root.setLeftNode(getBSTV2(arr, keyIndex, min, root.getData()));
			root.setRightNode(getBSTV2(arr, keyIndex, root.getData(), max));
		}
		return root;
	}

	int index = 0;

	private BinaryTreeNode getBSTV2_V1(int[] arr, int min, int max) {
		if (index >= arr.length) {
			return null;
		}
		BinaryTreeNode root = null;
		if (arr[index] > min && arr[index] < max) {
			root = new BinaryTreeNode(arr[index]);
			index++;
			root.setLeftNode(getBSTV2_V1(arr, min, root.getData()));
			root.setRightNode(getBSTV2_V1(arr, root.getData(), max));
		}
		return root;
	}

	private BinaryTreeNode getBSTV1(int[] arr, int low, int high) {
		if (low > high) {
			return null;
		}
		if (low == high) {
			BinaryTreeNode node = new BinaryTreeNode(arr[low]);
			return node;
		}
		BinaryTreeNode node = new BinaryTreeNode(arr[low]);
		int firstIncEleIndex = getFirstIncEleIndex(arr, low, arr[low]);
		node.setLeftNode(getBSTV1(arr, low + 1, firstIncEleIndex - 1));
		node.setRightNode(getBSTV1(arr, firstIncEleIndex + 1, high));
		return node;
	}

	private int getFirstIncEleIndex(int arr[], int st, int n) {
		for (int i = st; i < arr.length; i++) {
			if (arr[i] == n) {
				return i;
			}
		}
		return -1;
	}

}
