//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
package TreesAndGraphs;

// Duplicate
public class ConstructBSTfromPreOrder {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		ConstructBSTfromPreOrder bsTfromPreOrder = new ConstructBSTfromPreOrder();
		System.out.println(bsTfromPreOrder.bstFromPreorder(new int[] { 4, 2 }).val);
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, 0, preorder.length - 1);
	}

	public TreeNode bstFromPreorder(int[] preorder, int pos, int ed) {
		if (pos == preorder.length || pos > ed) {
			return null;
		}
		TreeNode node = new TreeNode(preorder[pos]);
		int index = getNextIncIndex(preorder, pos, ed);
		if (index != -1) {
			node.left = bstFromPreorder(preorder, pos + 1, index - 1);
			node.right = bstFromPreorder(preorder, index, ed);
		} else {
			if (pos < ed) {
				node.left = bstFromPreorder(preorder, pos + 1, ed);
			}
		}
		return node;
	}

	private int getNextIncIndex(int[] arr, int pos, int ed) {
		for (int i = pos + 1; i <= ed; i++) {
			if (arr[pos] < arr[i]) {
				return i;
			}
		}
		return -1;
	}

}
