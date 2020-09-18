package TreesAndGraphs;

public class SmallestStringFromLeaf {

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

		TreeNode node25 = new TreeNode(25);
		TreeNode node1 = new TreeNode(1);
		TreeNode node0 = new TreeNode(0);
		TreeNode node_0 = new TreeNode(0);
		TreeNode node_1 = new TreeNode(1);
		TreeNode node__0 = new TreeNode(0);
//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(4);
//		TreeNode node_3 = new TreeNode(3);
//		TreeNode node_4 = new TreeNode(4);
		node25.left = node1;
		node1.right = node0;
		node1.left = node_0;
		node0.left = node_1;
		node_1.right = node__0;

//		node1.left = node3;
//		node1.right = node4;
//		node2.left = node_3;
//		node2.right = node_4;
		SmallestStringFromLeaf smallestStringFromLeaf = new SmallestStringFromLeaf();
		System.out.println(smallestStringFromLeaf.smallestFromLeaf(node25));

	}

	String smallestStr = null;

	public String smallestFromLeaf(TreeNode root) {
		smallestFromLeaf(root, "");
		return smallestStr;
	}

	public void smallestFromLeaf(TreeNode root, String currStr) {
		if (root == null) {
			return;
		}
		int val = root.val;
		char c = (char) ('a' + val);
		String str = c + currStr;
		if (root.left == null && root.right == null) {
			if (smallestStr == null || str.compareTo(smallestStr) < 0) {
				smallestStr = str;
			}
		}
		smallestFromLeaf(root.left, str);
		smallestFromLeaf(root.right, str);
	}

}
