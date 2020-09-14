package TreesAndGraphs;

import java.util.HashMap;
import java.util.Map;

public class LargestBST {

	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode25 = new BinaryTreeNode(25);
		BinaryTreeNode binaryTreeNode18 = new BinaryTreeNode(18);
		BinaryTreeNode binaryTreeNode50 = new BinaryTreeNode(50);
		BinaryTreeNode binaryTreeNode19 = new BinaryTreeNode(19);
		BinaryTreeNode binaryTreeNode20 = new BinaryTreeNode(20);
		BinaryTreeNode binaryTreeNode35 = new BinaryTreeNode(35);
		BinaryTreeNode binaryTreeNode60 = new BinaryTreeNode(60);
		BinaryTreeNode binaryTreeNode15 = new BinaryTreeNode(15);
		BinaryTreeNode binaryTreeNode18_1 = new BinaryTreeNode(18);
		BinaryTreeNode binaryTreeNode25_1 = new BinaryTreeNode(25);
		BinaryTreeNode binaryTreeNode20_1 = new BinaryTreeNode(20);
		BinaryTreeNode binaryTreeNode40 = new BinaryTreeNode(40);
		BinaryTreeNode binaryTreeNode55 = new BinaryTreeNode(55);
		BinaryTreeNode binaryTreeNode70 = new BinaryTreeNode(70);
		BinaryTreeNode binaryTreeNode25_2 = new BinaryTreeNode(25);

		binaryTreeNode25.setLeftNode(binaryTreeNode18);
		binaryTreeNode25.setRightNode(binaryTreeNode50);
		binaryTreeNode18.setLeftNode(binaryTreeNode19);
		binaryTreeNode18.setRightNode(binaryTreeNode20);
		binaryTreeNode19.setRightNode(binaryTreeNode15);
		binaryTreeNode20.setLeftNode(binaryTreeNode18_1);
		binaryTreeNode20.setRightNode(binaryTreeNode25_1);
		binaryTreeNode50.setLeftNode(binaryTreeNode35);
		binaryTreeNode50.setRightNode(binaryTreeNode60);
		binaryTreeNode35.setLeftNode(binaryTreeNode20_1);
		binaryTreeNode35.setRightNode(binaryTreeNode40);
		binaryTreeNode60.setLeftNode(binaryTreeNode55);
		binaryTreeNode60.setRightNode(binaryTreeNode70);
		binaryTreeNode20_1.setRightNode(binaryTreeNode25_2);

		LargestBST largestBST = new LargestBST();

		System.out.println(largestBST.getLargestBST(binaryTreeNode25));
	}

	private Map<String, Integer> getLargestBST(BinaryTreeNode treeNode) {
		if (treeNode == null) {
			return null;
		}
		Map<String, Integer> m1 = getLargestBST(treeNode.getLeftNode());
		Map<String, Integer> m2 = getLargestBST(treeNode.getRightNode());
		Map<String, Integer> m = new HashMap<String, Integer>(1);
		if (m1 == null && m2 == null) {
			m.put("isBST", 1);
			m.put("Size", 1);
			m.put("Min", treeNode.getData());
			m.put("Max", treeNode.getData());
		} else if ((m1 == null || m1.get("isBST") == 1) && (m2 == null || m2.get("isBST") == 1)
				&& (m1 == null || m1.get("Max") < treeNode.getData())
				&& (m2 == null || treeNode.getData() < m2.get("Min"))) {
			m.put("isBST", 1);
			m.put("Size", 1 + (m1 == null ? 0 : m1.get("Size")) + (m2 == null ? 0 : m2.get("Size")));
			m.put("Min", m1 == null ? treeNode.getData() : m1.get("Min"));
			m.put("Max", m2 == null ? treeNode.getData() : m2.get("Max"));
		} else {
			m.put("isBST", 0);
			m.put("Size", Math.max(m1 == null ? 0 : m1.get("Size"), m2 == null ? 0 : m2.get("Size")));
		}
		return m;
	}

}
