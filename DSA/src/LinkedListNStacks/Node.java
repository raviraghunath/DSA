package LinkedListNStacks;

public class Node {

	private int data;

	private Node nextNode;

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", nextNode=" + nextNode + "]";
	}

	public static void printLL(Node node) {
		while (node != null) {
			System.out.print(node.data);
			node = node.nextNode;
		}
		System.out.println();
	}

}
