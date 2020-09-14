package TreesAndGraphs;
import java.util.Stack;

public class PreOrderTraversal {

	public static void main(String[] args) {

		PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
		preOrderTraversal.printPreOrder(BinaryTreeNode.getBinaryTree());
		System.out.println();
		preOrderTraversal.printPreOrderIterative(BinaryTreeNode.getBinaryTree());
	}

	public void printPreOrder(BinaryTreeNode binaryTreeNode) {
		if (binaryTreeNode != null) {
			System.out.print(binaryTreeNode.getData()+",");
			printPreOrder(binaryTreeNode.getLeftNode());
			printPreOrder(binaryTreeNode.getRightNode());
		}
	}

	private void printPreOrderIterative(BinaryTreeNode binaryTreeNode) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		boolean popped = false; 
		while (binaryTreeNode != null) {
			if(!popped) {
				System.out.print(binaryTreeNode.getData()+",");
			}
			if (!popped && binaryTreeNode.getLeftNode() != null) {
				stack.add(binaryTreeNode);
				binaryTreeNode = binaryTreeNode.getLeftNode();
				popped = false;
			} else if (binaryTreeNode.getRightNode() != null) {
				binaryTreeNode = binaryTreeNode.getRightNode();
				popped = false;
			} else {
				if(stack.isEmpty()) {
					binaryTreeNode = null;
				}else {
					binaryTreeNode = stack.pop();
					popped = true;
				}
			}
		}
	}

}
