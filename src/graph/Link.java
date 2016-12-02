package graph;

public class Link {
	protected Pays node1;
	protected Pays node2;
	
	public Link(Pays n1, Pays n2) {
		this.node1 = n1;
		this.node2 = n2;
	}

	public Node getNode1() {
		return node1;
	}
	
	public Node getNode2() {
		return node2;
	}


	
	
	

}
