package graph;

import java.util.ArrayList;

public class Graph {
	private ArrayList<Node> nodes;
	private ArrayList<Link> links;
	
	public Graph() {
		nodes = new ArrayList<Node>();
		links = new ArrayList<Link>();
	}
	
	public void addNode(Node... n) {
		for(Node elem : n) {
			if (!nodes.contains(elem)){
				nodes.add(elem);
			}
		}
	}
	
	public void addLink(Node n1, Node n2) {
		if (nodes.contains(n1) 
			&& nodes.contains(n2)
			&& !existingLink(n1, n2)
			&& n1!=n2) {
			links.add(new Link(n1,n2));
		}
	}
	
	
	public boolean existingLink(Node n1, Node n2) {
		for(Link l : links){
			if (l.getNode1() == n1 || l.getNode2() == n1){
				Node tmpNode = l.getNeighbour(n1);
				if (tmpNode == n2){
					return true;
				}
			}
		}
		return false;
	}
	
	public ArrayList<Node> getLinkedNodes(Node n) {
		ArrayList<Node> res = new ArrayList<Node>();
		for(Link l : links){
			Node tmpNode = l.getNeighbour(n);
			if (tmpNode != null){
				res.add(tmpNode);
			}
		}
		return res;
	}

	public int getNodeNumber() {
		return this.nodes.size();
	}
	
	public int getLinkNumber() {
		return this.links.size();
	}
}
