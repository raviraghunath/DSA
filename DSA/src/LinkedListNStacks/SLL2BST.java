package LinkedListNStacks;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next; 
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right; 

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class SLL2BST {
	public static void main(String[] args) {
		SLL2BST sll2bst = new SLL2BST();
		ListNode node_10 = new ListNode(-10);
		ListNode node_3 = new ListNode(-3);
		ListNode node0 = new ListNode(0);
		ListNode node5 = new ListNode(5);
		ListNode node9 = new ListNode(9);
		node_10.next = node_3;
		node_3.next = node0;
		node0.next = node5;
		node5.next = node9;
		TreeNode node = sll2bst.sortedListToBST(node_10);
		sll2bst.printInorder(node);
	}

	private TreeNode sortedListToBST(ListNode head) {
		ListNode node = head;
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return sortedListToBST(head, len);
	}

	private TreeNode sortedListToBST(ListNode head, int len) {
		if (len == 0) {
			return null;
		} else if (len == 1) {
			return convertTN(head);
		} else if (len == 2) {
			TreeNode node1 = convertTN(head);
			TreeNode node2 = convertTN(head.next);
			node2.left = node1;
			return node2;
		} else {
			int mid = len / 2 + 1;
			ListNode ln = getListNode(head, mid);
			TreeNode root = convertTN(ln);
			root.left = sortedListToBST(head, mid - 1);
			root.right = sortedListToBST(ln.next, len - mid);
			return root;
		}
	}

	private ListNode getListNode(ListNode listNode, int pos) {
		int i = 0;
		while (listNode != null) {
			i++;
			if (pos == i) {
				return listNode;
			}
			listNode = listNode.next;
		}
		return null;
	}

	private TreeNode convertTN(ListNode head) {
		if (head == null)
			return null;
		TreeNode node1 = new TreeNode(head.val);
		return node1;
	}

	public void printInorder(TreeNode treeNode) {
		if (treeNode != null) {
			printInorder(treeNode.left);
			System.out.print(treeNode.val);
			printInorder(treeNode.right);
		}
	}

}
