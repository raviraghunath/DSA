package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

	public static void main(String[] args) {
		BFS bfs = new BFS();
		GraphNode node0 = new GraphNode(0);
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		node0.setGraphNodes(new ArrayList<GraphNode>(Arrays.asList(node1, node2)));
		node1.setGraphNodes(new ArrayList<GraphNode>(Arrays.asList(node2)));
		node2.setGraphNodes(new ArrayList<GraphNode>(Arrays.asList(node0, node3)));
		node3.setGraphNodes(new ArrayList<GraphNode>(Arrays.asList(node3)));
		bfs.doBFS(node0);
	}

	private void doBFS(GraphNode graphNode) {
		Set<GraphNode> set = new HashSet<GraphNode>();
		Queue<GraphNode> graphNodes = new LinkedList<GraphNode>();
		graphNodes.add(graphNode);
		set.add(graphNode);
		while (!graphNodes.isEmpty()) {
			GraphNode g = graphNodes.poll();
			System.out.print(g.getData());
			for (GraphNode node : g.getGraphNodes()) {
				if (!set.contains(node)) {
					graphNodes.add(node);
					set.add(node);
				}
			}
		}
	}
}
