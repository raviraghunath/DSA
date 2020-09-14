package LinkedListNStacks;
import java.util.HashMap;
import java.util.Map;

public class CollisonDectectionInLL {

	public static void main(String args[]) {
		CollisonDectectionInLL collisonDectectionInLL = new CollisonDectectionInLL();
		Node n1 = new Node(3);
		Node n2 = new Node(1);
		Node n3 = new Node(5);
		Node n4 = new Node(9);
		Node n5 = new Node(7);
		Node n6 = new Node(2);
		Node n7 = new Node(1);
		Node n8 = new Node(4);
		Node n9 = new Node(6);
		n1.setNextNode(n2);
		n2.setNextNode(n3);
		n3.setNextNode(n4);
		n4.setNextNode(n5);
		n5.setNextNode(n6);
		n6.setNextNode(n7);
		n8.setNextNode(n9);
		n9.setNextNode(n5);
		System.out.println(collisonDectectionInLL.findIntersection(n1, n8).getData());
		System.out.println(collisonDectectionInLL.findIntersection(n1, new Node(122)));
		System.out.println(collisonDectectionInLL.findIntersection(new Node(122), n8));
		System.out.println(collisonDectectionInLL.findIntersection(new Node(122), new Node(122)));

		System.out.println(collisonDectectionInLL.findIntersection_V1(n1, n8).getData());
		System.out.println(collisonDectectionInLL.findIntersection_V1(n1, new Node(122)));
		System.out.println(collisonDectectionInLL.findIntersection_V1(new Node(122), n8));
		System.out.println(collisonDectectionInLL.findIntersection_V1(new Node(122), new Node(122)));

	}

	private Node findIntersection(Node node1, Node node2) {
		Node n1 = node1;
		Node n2 = node2;
		if (n1 == null || n2 == null) {
			return null;
		}
		int n1Cnt = 0;
		while (n1 != null) {
			n1 = n1.getNextNode();
			n1Cnt++;
		}
		int n2Cnt = 0;
		while (n2 != null) {
			n2 = n2.getNextNode();
			n2Cnt++;
		}
		n1 = node1;
		n2 = node2;
		if (n1Cnt > n2Cnt) {
			int diff = n1Cnt - n2Cnt;
			int cnt = 0;
			while (cnt < diff) {
				n1 = n1.getNextNode();
				cnt++;
			}
		} else if (n1Cnt > n2Cnt) {
			int diff = n2Cnt - n1Cnt;
			int cnt = 0;
			while (cnt < diff) {
				n2 = n2.getNextNode();
				cnt++;
			}
		}
		while (n1 != null && n2 != null) {
			if (n1 == n2) {
				return n1;
			}
			n1 = n1.getNextNode();
			n2 = n2.getNextNode();
		}
		return null;
	}

	private Node findIntersection_V1(Node node1, Node node2) {
		Map<Node, Boolean> map = new HashMap<Node, Boolean>();
		while (node1 != null) {
			map.put(node1, Boolean.TRUE);
			node1 = node1.getNextNode();
		}

		while (node2 != null) {
			if (map.containsKey(node2)) {
				return node2;
			}
			node2 = node2.getNextNode();
		}
		return null;
	}

}
