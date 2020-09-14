package TreesAndGraphs;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class BSTZigZagPrint {
	public static void main(String[] args) {
		BSTZigZagPrint bstZigZagPrint = new BSTZigZagPrint();
		bstZigZagPrint.printZigZag(BinaryTreeNode.getBinaryTree());
	}

	private void printZigZag(BinaryTreeNode node) {

		if (node == null) 
			return;
		Deque<BinaryTreeNode> deque = new LinkedBlockingDeque<BinaryTreeNode>();
		BinaryTreeNode deMarkNode = new BinaryTreeNode(-1);
		deque.addFirst(node);
		deque.addFirst(deMarkNode);
		int level = 1;
		while (!deque.isEmpty()) {
			if (level % 2 != 0) {
				node = deque.pollLast();
				if (node == deMarkNode) {
					if(deque.isEmpty()) {
						break;
					}
					deque.addLast(deMarkNode);
					level++;
				} else {
					System.out.print(node.getData() + ",");
					if (node.getRightNode() != null) {
						deque.addFirst(node.getRightNode());
					}
					if (node.getLeftNode() != null) {
						deque.addFirst(node.getLeftNode());
					}
				}
			} else {
				node = deque.pollFirst();
				if (node == deMarkNode) {
					if(deque.isEmpty()) {
						break;
					}
					deque.addFirst(deMarkNode);
					level++;
				} else {
					System.out.print(node.getData() + ",");
					if (node.getLeftNode() != null) {
						deque.addLast(node.getLeftNode());
					}
					if (node.getRightNode() != null) {
						deque.addLast(node.getRightNode());
					}
				}
			}
		}
	}
}
