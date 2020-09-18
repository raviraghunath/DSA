package TreesAndGraphs;

public class BST2BT {

	public static void main(String[] args) {

		BST2BT bst2bt = new BST2BT();
		new BSTBFS().printBFS(bst2bt.getBT(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 0));
		new InOrderTraversal().printInorder(bst2bt.getBT(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 0));
	}

	private BinaryTreeNode getBT(int arr[], int i) {
		if (arr == null || arr.length == 0 || i >= arr.length) {
			return null;
		}
		BinaryTreeNode node = new BinaryTreeNode(arr[i]);
		node.setLeftNode(getBT(arr, 2 * i + 1));
		node.setRightNode(getBT(arr, 2 * i + 2));
		return node;
	}
}
