//https://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
package TreesAndGraphs;

public class InorderToSpecialBT {

	public static void main(String[] args) {
		InorderToSpecialBT inorderToSpecialBT = new InorderToSpecialBT();
		BinaryTreeNode root = inorderToSpecialBT.getSpecialBT(new int[] {5, 10, 40, 30, 28}, 0, 4);
		InOrderTraversal inOrderTraversal=new InOrderTraversal();
		inOrderTraversal.printInorder(root);
	}

	private BinaryTreeNode getSpecialBT(int arr[], int st, int ed) {
		if (st > ed) {
			return null;
		}
		if (st == ed) {
			BinaryTreeNode binaryTreeNode = new BinaryTreeNode(arr[st]);
			return binaryTreeNode;
		}
		int maxIndex = findMaxIndex(arr, st, ed);
		BinaryTreeNode root = new BinaryTreeNode(arr[maxIndex]);
		root.setLeftNode(getSpecialBT(arr, st, maxIndex - 1));
		root.setRightNode(getSpecialBT(arr, maxIndex + 1, ed));
		return root;
	}

	private int findMaxIndex(int arr[], int st, int ed) {
		int max = 0;
		int maxIndex = 0;
		for (int i = st; i <= ed; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
