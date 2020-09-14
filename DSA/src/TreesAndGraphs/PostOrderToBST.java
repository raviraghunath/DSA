package TreesAndGraphs;

import java.util.Stack;

public class PostOrderToBST {

	static class Index {
		int i;

		Index(int i) {
			this.i = i;
		}
	}

	public static void main(String[] args) {
		PostOrderToBST postOrderToBST = new PostOrderToBST();
		BinaryTreeNode treeNode = postOrderToBST.getBST(new int[] { 1, 7, 5, 40, 50, 10 }, 0, 5);
		PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
		postOrderTraversal.printPostorder(treeNode);
		System.out.println();
		treeNode = postOrderToBST.getBSTV1(new int[] { 1, 7, 5, 40, 50, 10 }, new Index(5), Integer.MIN_VALUE,
				Integer.MAX_VALUE);
		postOrderTraversal.printPostorder(treeNode);
		System.out.println();
		treeNode = postOrderToBST.getBSTV2(new int[] { 1, 7, 5, 40, 50, 10 });
		postOrderTraversal.printPostorder(treeNode);

	}

	private BinaryTreeNode getBSTV2(int arr[]) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode root = new BinaryTreeNode(arr[arr.length - 1]);
		stack.push(root);

		for (int i = arr.length - 2; i >= 0; i--) {
			int elel = arr[i];
			BinaryTreeNode temp = null;
			while (!stack.isEmpty() && stack.peek().getData() > elel) {
				temp = stack.pop();
			}
			BinaryTreeNode node = new BinaryTreeNode(elel);
			if (temp != null) {
				temp.setLeftNode(node);
				stack.push(node);
			} else {
				stack.peek().setRightNode(node);
				stack.push(node);
			}
		}
		return root;
	}

	private BinaryTreeNode getBSTV1(int arr[], Index index, int min, int max) {
		if (index.i < 0) {
			return null;
		}
		BinaryTreeNode root = null;
		if (arr[index.i] > min && arr[index.i] < max) {
			root = new BinaryTreeNode(arr[index.i]);
			index.i--;
			root.setRightNode(getBSTV1(arr, index, root.getData(), max));
			root.setLeftNode(getBSTV1(arr, index, min, root.getData()));
		}
		return root;
	}

	private BinaryTreeNode getBST(int arr[], int st, int ed) {
		if (st > ed) {
			return null;
		}
		if (st == ed) {
			BinaryTreeNode node = new BinaryTreeNode(arr[ed]);
			return node;
		}
		int lastEle = arr[ed];
		BinaryTreeNode root = new BinaryTreeNode(lastEle);
		int lEd = getFirstDecEleIndex(arr, 0, ed - 1);
		root.setLeftNode(getBST(arr, 0, lEd));
		root.setRightNode(getBST(arr, lEd + 1, ed - 1));
		return root;
	}

	private int getFirstDecEleIndex(int arr[], int st, int n) {
		for (int i = st; i > 0; i--) {
			if (arr[i] == n) {
				return i;
			}
		}
		return -1;
	}

}
