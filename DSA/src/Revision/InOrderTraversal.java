package Revision;

import TreesAndGraphs.BinaryTreeNode;

public class InOrderTraversal {

	public static void main(String[] args) {
		new InOrderTraversal().inOrder(BinaryTreeNode.getBinaryTree());
	}

	private void inOrder(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.getLeftNode());
		System.out.print(node.getData());
		inOrder(node.getRightNode());
	}
}
