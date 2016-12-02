package graph;

public class Frontiere extends Link{

	public Frontiere(Pays n1, Pays n2) {
		super(n1, n2);
	}
	
	public Pays getNeighbour(Node n) {
		if (node1 == n) {
			return node2;
		}
		if (node2 == n) {
			return node1;
		}
		return null;
	}
}
