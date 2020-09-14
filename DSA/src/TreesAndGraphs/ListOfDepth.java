package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LinkedListNStacks.Node;

public class ListOfDepth {
	public static void main(String[] args) {
		ListOfDepth listOfDepth = new ListOfDepth();
		List<Node> res = listOfDepth.getLLfromEachLevel(BinaryTreeNode.getBinaryTree());
		for (Node n : res) {
			Node.printLL(n);
		}
	}

	private List<Node> getLLfromEachLevel(BinaryTreeNode binaryTreeNode) {
		List<Node> res = new ArrayList<Node>();
		Queue<BinaryTreeNode> graphNodes = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode seperator = new BinaryTreeNode(-1);
		graphNodes.add(binaryTreeNode);
		graphNodes.add(seperator);
		boolean newLevel = true;
		Node curr = null;
		while (!graphNodes.isEmpty()) {
			BinaryTreeNode btn = graphNodes.poll();
			if (btn == seperator) {
				if(graphNodes.isEmpty()) {
					break;
				}
				graphNodes.add(seperator);
				newLevel = true;
				continue;
			}
			Node node = new Node(btn.getData());
			if (newLevel) {
				res.add(node);
			} else {
				curr.setNextNode(node);
			}
			if (btn.getLeftNode() != null) {
				graphNodes.add(btn.getLeftNode());
			}
			if (btn.getRightNode() != null) {
				graphNodes.add(btn.getRightNode());
			}
			curr = node;
			newLevel = false;
		}
		return res;
	}
}
