package Graph;

import java.util.List;

public class GraphNode {

	private final int data;
	private List<GraphNode> graphNodes;

	public GraphNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public List<GraphNode> getGraphNodes() {
		return graphNodes;
	}

	public void setGraphNodes(List<GraphNode> graphNodes) {
		this.graphNodes = graphNodes;
	}

	@Override
	public String toString() {
		return "GraphNode [data=" + data + "]";
	}

}
