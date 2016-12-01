package graph;

public class Link {
	private Node node1;
	private Node node2;
	
	public Link(Node n1, Node n2) {
		this.node1 = n1;
		this.node2 = n2;
	}

	public Node getNode1() {
		return node1;
	}
	
	public Node getNode2() {
		return node2;
	}


	public Node getNeighbour(Node n) {
		if (node1 == n) {
			return node2;
		}
		if (node2 == n) {
			return node1;
		}
		return null;
	}
	
	

}
