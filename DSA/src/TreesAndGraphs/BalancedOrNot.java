package TreesAndGraphs;

public class BalancedOrNot {
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
		BalancedOrNot  balancedOrNot=new BalancedOrNot();
		System.out.println(balancedOrNot.isBalanced(null));

	}

	private boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
}
