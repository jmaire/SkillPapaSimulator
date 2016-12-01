package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
	ArrayList<Node> nodes;
	ArrayList<Link> links;
	
	public Graph() {
		nodes = new ArrayList<Node>();
		links = new ArrayList<Link>();
	}
	
	public void addNode(Node... n) {
		nodes.addAll(Arrays.asList(n));
	}
	
	public void addLink(Node n1, Node n2) {
		if (nodes.contains(n1) && nodes.contains(n2)) {
			links.add(new Link(n1,n2));
		}
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
}
