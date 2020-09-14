package LinkedListNStacks;

public class RandomLL {

	private static class Node {
		int data;
		Node next;
		Node random;

		Node(int data) {
			this.data = data;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + data;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((random == null) ? 0 : random.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (data != other.data)
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (random == null) {
				if (other.random != null)
					return false;
			} else if (!random.equals(other.random))
				return false;
			return true;
		}

	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n1.random = n3;
		n2.random = n1;
		n3.random = n3;
		n4.random = n2;
		RandomLL randomLL = new RandomLL();
		Node n = randomLL.clone(n1);
	}

	private Node clone(Node nn) {
		Node n = nn;
		Node head = null;
		while (n != null) {
			Node n1 = new Node(n.data);
			if (head == null) {
				head = n1;
			}
			n1.next = n.next;
			n.next = n1;
			n1.random = n.random;
			n = n1.next;
		}
		n = nn;
		System.out.println(n);
		while (n != null) {
			n.next = n.next.next;
			n = n.next;
		}
		return head;
	}

}
