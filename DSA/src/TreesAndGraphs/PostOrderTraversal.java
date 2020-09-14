package TreesAndGraphs;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
		BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
		BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
		BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
		BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
		BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);

		binaryTreeNode1.setLeftNode(binaryTreeNode2);
		binaryTreeNode2.setLeftNode(binaryTreeNode4);
		binaryTreeNode2.setRightNode(binaryTreeNode5);
		binaryTreeNode1.setRightNode(binaryTreeNode3);

		postOrderTraversal.printPostorder(binaryTreeNode1);
		System.out.println();
		postOrderTraversal.printPostorderIterative(binaryTreeNode1);
	}
 
	public void printPostorder(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode != null) {
			printPostorder(binaryTreeNode.getLeftNode());
			printPostorder(binaryTreeNode.getRightNode());
			System.out.print(binaryTreeNode.getData()+",");
		}
	}

	private void printPostorderIterative(BinaryTreeNode binaryTreeNode) {
		Stack<BinaryTreeNode> lstack = new Stack<BinaryTreeNode>();
		Set<BinaryTreeNode> rightVisitedSet = new HashSet<BinaryTreeNode>();
		boolean popped = false;
		while (binaryTreeNode != null) {
			if (!popped && binaryTreeNode.getLeftNode() != null) {
				lstack.push(binaryTreeNode);
				binaryTreeNode = binaryTreeNode.getLeftNode();
				popped = false;
			} else if (!rightVisitedSet.contains(binaryTreeNode) && binaryTreeNode.getRightNode() != null) {
				rightVisitedSet.add(binaryTreeNode);
				lstack.push(binaryTreeNode);
				binaryTreeNode = binaryTreeNode.getRightNode();
				popped = false;
			} else {
				System.out.print(binaryTreeNode.getData());
				if (!lstack.isEmpty()) {
					binaryTreeNode = lstack.pop();
					popped = true;
				} else {
					binaryTreeNode = null;
				}
			}
		}
	}
}
