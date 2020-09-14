package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DFS {

	public static void main(String[] args) {
		DFS bfs = new DFS();
		GraphNode node0 = new GraphNode(0);
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		node0.setGraphNodes(new ArrayList<GraphNode>(Arrays.asList(node1, node2)));
		node1.setGraphNodes(new ArrayList<GraphNode>(Arrays.asList(node2)));
		node2.setGraphNodes(new ArrayList<GraphNode>(Arrays.asList(node0, node3)));
		node3.setGraphNodes(new ArrayList<GraphNode>(Arrays.asList(node3)));
		Set<GraphNode> set = new HashSet<GraphNode>();
		set.add(node0);
		bfs.doDFS(node0, set);
	}

	private void doDFS(GraphNode graphNode, Set<GraphNode> set) {
		System.out.print(graphNode.getData());
		for (GraphNode node : graphNode.getGraphNodes()) {
			if (!set.contains(node)) {
				set.add(node);
				doDFS(node, set);
			}
		}
	}
}
