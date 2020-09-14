package TreesAndGraphs;

public class InOrderToBST {

	public static void main(String[] args) {
		InOrderToBST inOrderToBST = new InOrderToBST();
		BinaryTreeNode node = inOrderToBST.getBST(new int[] { 1, 2, 3, 4 }, 0, 3);
		InOrderTraversal inOrderTraversal = new InOrderTraversal();
		inOrderTraversal.printInorder(node);
	}

	private BinaryTreeNode getBST(int arr[], int st, int ed) {
		if (st > ed) {
			return null;
		}
		if (st == ed) {
			BinaryTreeNode node = new BinaryTreeNode(arr[st]);
			return node;
		}
		int len = ed - st + 1;
		int mid = len / 2;
		BinaryTreeNode root = new BinaryTreeNode(arr[mid]);
		root.setLeftNode(getBST(arr, st, mid - 1));
		root.setRightNode(getBST(arr, mid + 1, ed));
		return root;
	}
}
