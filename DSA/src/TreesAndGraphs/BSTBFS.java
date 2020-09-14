package TreesAndGraphs;
import java.util.LinkedList;
import java.util.Queue;

public class BSTBFS {
	public static void main(String[] args) {
		BSTBFS bstbfs = new BSTBFS();
		bstbfs.printBFS(BinaryTreeNode.getBinaryTree());
	}

	public void printBFS(BinaryTreeNode node) {
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode deMark = new BinaryTreeNode(-1);
		queue.add(node);
		queue.add(deMark); 
		int level = 1;
		while (!queue.isEmpty()) {
			BinaryTreeNode n = queue.poll();
			if (n == deMark) {
				if(queue.isEmpty()) {
					break;
				}
				System.out.println();
				level++;
				queue.add(deMark);
			} else {
				System.out.print(n.getData() + " , ");
				if (n.getLeftNode() != null) {
					queue.add(n.getLeftNode());
				}
				if (n.getRightNode() != null) {
					queue.add(n.getRightNode());
				}
			}
		}
		System.out.println();
		System.out.println("Level : " + level);
	}
}
