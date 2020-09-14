package TreesAndGraphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class ShortestPathGraph {

	public static class GraphNode {
		int data;
		Map<GraphNode, Integer> neighbours;

		public GraphNode(int data) {
			this.data = data;
		}

		public void setNeighbours(Map<GraphNode, Integer> neighbours) {
			this.neighbours = neighbours;
		}

		@Override
		public String toString() {
			return "GraphNode [data=" + data + "]";
		}

	}

	public static void main(String[] args) { 
		ShortestPathGraph shortestPathGraph = new ShortestPathGraph();
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		GraphNode node4 = new GraphNode(4);
		GraphNode node5 = new GraphNode(5);
		GraphNode node6 = new GraphNode(6);
		node1.neighbours = new HashMap<ShortestPathGraph.GraphNode, Integer>();
		node1.neighbours.put(node2, 2);
		node1.neighbours.put(node3, 4);
		node2.neighbours = new HashMap<ShortestPathGraph.GraphNode, Integer>();
		node2.neighbours.put(node4, 7);
		node2.neighbours.put(node3, 1);
		node3.neighbours = new HashMap<ShortestPathGraph.GraphNode, Integer>();
		node3.neighbours.put(node5, 3);
		node4.neighbours = new HashMap<ShortestPathGraph.GraphNode, Integer>();
		node4.neighbours.put(node6, 1);
		node5.neighbours = new HashMap<ShortestPathGraph.GraphNode, Integer>();
		node5.neighbours.put(node6, 5);
		node5.neighbours.put(node4, 2);
		shortestPathGraph.getMinPath(node1);
		System.out.println(shortestPathGraph.minDist);
	}

	Map<GraphNode, Integer> minDist = new HashMap<ShortestPathGraph.GraphNode, Integer>();
	Set<GraphNode> visited = new HashSet<ShortestPathGraph.GraphNode>();

	private void getMinPath(GraphNode source) {
		Map<GraphNode, Integer> neighbours = source.neighbours;
		if (neighbours != null) {
			for (Entry<GraphNode, Integer> entry : neighbours.entrySet()) {
				GraphNode graphNode = entry.getKey();
				int dist = entry.getValue();
				int currDist = minDist.get(source) == null ? 0 : minDist.get(source);
				if (minDist.containsKey(graphNode)) {
					if (dist + currDist < minDist.get(graphNode)) {
						minDist.put(graphNode, dist + currDist);
						visited.remove(graphNode);
					}
				} else {
					minDist.put(graphNode, dist + currDist);
				}
				if (!visited.contains(graphNode)) {
					getMinPath(graphNode);
				}
			}
		}
		visited.add(source);
	}

}
