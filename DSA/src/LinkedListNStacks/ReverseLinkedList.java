package LinkedListNStacks;

public class ReverseLinkedList {

	public static void main(String args[]) {
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		System.out.println(n1);
		Node reverserHead = reverseLinkedList.reverseIterative(n1);
		System.out.println(reverserHead);
		SpecialNode specialNode = reverseLinkedList.reverseRecursive(reverserHead);
		System.out.println(specialNode.headNode);
	} 

	private Node reverseIterative(Node n) {
		if (n == null) {
			return null;
		}
		Node head = null;
		while (n != null) {
			Node next = n.getNextNode();
			n.setNextNode(head);
			head = n;
			n = next;
		}
		return head;
	}

	private SpecialNode reverseRecursive(Node n) {
		if (n == null) {
			return null;
		}

		SpecialNode specialNode1 = reverseRecursive(n.getNextNode());
		SpecialNode specialNode = new SpecialNode();
		specialNode.node = n;
		if (specialNode1 == null) {
			specialNode.headNode = n;
		} else {
			specialNode.headNode = specialNode1.headNode;
			Node n1 = specialNode1.node;
			n1.setNextNode(n);
		}
		n.setNextNode(null);
		return specialNode;
	}

	private class SpecialNode {
		Node node;
		Node headNode;
	}
}
