package TreesAndGraphs;
import java.util.Stack;

public class InOrderTraversal {

	public static void main(String[] args) {
		InOrderTraversal inOrderTraversal = new InOrderTraversal();
		BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
		BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
		BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
		BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
		BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);

		binaryTreeNode1.setLeftNode(binaryTreeNode2);
		binaryTreeNode2.setLeftNode(binaryTreeNode4);
		binaryTreeNode2.setRightNode(binaryTreeNode5);
		binaryTreeNode1.setRightNode(binaryTreeNode3);

		inOrderTraversal.printInorder(binaryTreeNode1);
		System.out.println();
		inOrderTraversal.printInorderItrative(binaryTreeNode1);
	} 

	public void printInorder(BinaryTreeNode treeNode) {
		if (treeNode != null) { 
			printInorder(treeNode.getLeftNode());
			System.out.print(treeNode.getData());
			printInorder(treeNode.getRightNode());
		}
	}

	public void printInorderItrative(BinaryTreeNode treeNode) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		boolean isPopped = false;
		while (treeNode != null) {
			if (!isPopped && treeNode.getLeftNode() != null) {
				stack.push(treeNode);
				treeNode = treeNode.getLeftNode();
				isPopped = false;
			} else if (treeNode.getRightNode() != null) {
				System.out.print(treeNode.getData());
				treeNode = treeNode.getRightNode();
				isPopped = false;
			} else {
				System.out.print(treeNode.getData());
				if (!stack.isEmpty()) {
					treeNode = stack.pop();
					isPopped = true;
				} else {
					treeNode = null;
				}

			}
		}
	}

}
