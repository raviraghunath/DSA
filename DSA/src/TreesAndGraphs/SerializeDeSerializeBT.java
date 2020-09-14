package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeSerializeBT {

	public static void main(String[] args) {
		SerializeDeSerializeBT serializeDeSerializeBT = new SerializeDeSerializeBT();
		List<Integer> list = new ArrayList<Integer>();
		BinaryTreeNode node = BinaryTreeNode.getBinaryTree();
		PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
		preOrderTraversal.printPreOrder(node);
		System.out.println();
		serializeDeSerializeBT.serialize(node, list);
		System.out.println(list);
		node = serializeDeSerializeBT.deSerialize(list);
		preOrderTraversal.printPreOrder(node);
	}

	private void serialize(BinaryTreeNode node, List<Integer> list) {
		if (node == null) {
			list.add(-1);
			return;
		}
		list.add(node.getData());
		serialize(node.getLeftNode(), list);
		serialize(node.getRightNode(), list);
	}

	int index;

	private BinaryTreeNode deSerialize(List<Integer> list) {
		if (list.get(index) == -1 || list.size() <= index) {
			index++;
			return null;
		}
		int ele = list.get(index);
		BinaryTreeNode root = new BinaryTreeNode(ele);
		index++;
		root.setLeftNode(deSerialize(list));
		root.setRightNode(deSerialize(list));
		return root;
	}

}
