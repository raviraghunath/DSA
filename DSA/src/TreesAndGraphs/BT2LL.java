package TreesAndGraphs;

import java.util.HashMap;
import java.util.Map;

public class BT2LL {

	public static void main(String[] args) { 
		BinaryTreeNode node10 = new BinaryTreeNode(10);
		BinaryTreeNode node12 = new BinaryTreeNode(12);
		BinaryTreeNode node15 = new BinaryTreeNode(15);
		BinaryTreeNode node25 = new BinaryTreeNode(25);
		BinaryTreeNode node30 = new BinaryTreeNode(30);
		BinaryTreeNode node36 = new BinaryTreeNode(36);

		node10.setLeftNode(node12);
		node10.setRightNode(node15);
		node12.setLeftNode(node25);
		node12.setRightNode(node30);
		node15.setLeftNode(node36);

		BT2LL bt2ll = new BT2LL();
		bt2ll.getLL(node10);
		bt2ll.printList(bt2ll.head);

	}

	BinaryTreeNode head = null;
	BinaryTreeNode prev = null;

	void BinaryTree2DoubleLinkedList(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		BinaryTree2DoubleLinkedList(root.getLeftNode());
		if (prev == null) {
			head = root;
		} else {
			prev.setRightNode(root);
			root.setLeftNode(prev);
		}
		prev = root;
		BinaryTree2DoubleLinkedList(root.getRightNode());

	}

	private Map<String, BinaryTreeNode> getLL(BinaryTreeNode node) {
		if (node == null) {
			return null;
		}
		System.out.println(node.getData());
		Map<String, BinaryTreeNode> b1 = getLL(node.getLeftNode());
		if(head == null) {
			head = node;
		}
		if (b1 != null && b1.get("rlm") != null) {
			node.setLeftNode(b1.get("rlm"));
			b1.get("rlm").setRightNode(node);
		}
		Map<String, BinaryTreeNode> b2 = getLL(node.getRightNode());
		if (b2 != null && b2.get("lrm") != null) {
			node.setRightNode(b2.get("lrm"));
			b2.get("lrm").setLeftNode(node);
		}
		Map<String, BinaryTreeNode> map = new HashMap<String, BinaryTreeNode>();
		if (b1 != null) {
			map.put("lrm", b1.get("rlm"));
		} else {
			map.put("lrm", node);
		}
		if (b2 != null) {
			map.put("rlm", b2.get("lrm"));
		} else {
			map.put("rlm", node);
		}

		return map;
	}

	void printList(BinaryTreeNode node) {
		int i = 0;
		while (node != null && i <= 10) {
			System.out.print(node.getData() + " ");
			node = node.getRightNode();
			i++;
		}
	}
}
