package TreesAndGraphs;

public class BFSToBST {

	public static void main(String[] args) {
		BFSToBST bfsToBST = new BFSToBST();
		BinaryTreeNode root = bfsToBST.getBST(new int[] { 7, 4, 12, 3, 6, 8, 1, 5, 10 });
		BSTBFS bstbfs = new BSTBFS();
		bstbfs.printBFS(root); 
	}

	private BinaryTreeNode getBST(int arr[]) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			helper(root, arr[i]);
		}
		return root;
	}

	private BinaryTreeNode helper(BinaryTreeNode root, int data) {
		if (root == null) {
			BinaryTreeNode node = new BinaryTreeNode(data);
			return node;
		}
		if (root.getData() >= data) {
			root.setLeftNode(helper(root.getLeftNode(), data));
		} else {
			root.setRightNode(helper(root.getRightNode(), data));
		}
		return root;
	}

}
