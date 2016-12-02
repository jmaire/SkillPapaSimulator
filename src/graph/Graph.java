package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class Graph {
	
	public static final double TAUX_EMIGRATION = 0.3; 
	
	ArrayList<Node> nodes;
	ArrayList<Link> links;
	
	public Graph() {
		nodes = new ArrayList<Node>();
		links = new ArrayList<Link>();
	}
	
	public ArrayList<Node> getNodes(){
		return nodes;
	}
	
	public ArrayList<Link> getLink(){
		return links;
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

	public int getLinkNumber() {
		return links.size();
	}

	public int getNodeNumber() {
		return nodes.size();
	}

	public boolean existingLink(Node n1, Node n2) {
		for (Link l : links) {
			if (l.getNode1() == n1 || l.getNode2() == n1){
				if (getLinkedNodes(n1).contains(n2)){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void update() {
		HashMap<Pays, HashMap<Pays, Integer>> up = new HashMap<>();
		/* Calcul des mouvements dans le monde entier */
		for (Node pays : nodes) {
			int nbEmigrant = (int)((Pays.BONHEUR_MAX - ((Pays)pays).getBonheur()) * TAUX_EMIGRATION);
			up.put((Pays) pays, roulette((Pays)pays, nbEmigrant));			
		}
		
		/* Application des mouvements */
		for (Map.Entry<Pays, HashMap<Pays, Integer>> e1 : up.entrySet()){
			int nbEmigr = 0;
			for (Map.Entry<Pays, Integer> e2 : e1.getValue().entrySet()) {
				nbEmigr += e2.getValue();
				e2.getKey().setPopulation(e2.getKey().getPopulation() + e2.getValue());
			}
			e1.getKey().setPopulation(e1.getKey().getPopulation() - nbEmigr);
		}
	}
	
	public HashMap<Pays, Integer> roulette(Pays p, int nbEmigr) {
		HashMap<Pays, Integer> res = new HashMap<>();
		
		/*Total des differences absolues de bonheur*/
		int totalBonheur = 0;
		
		int g = getLinkedNodes(p).size();
		for (int i = 0; i<g; i++) {
			Pays tmp = ((Pays)getLinkedNodes(p).get(i));
			totalBonheur += Math.abs(tmp.getBonheur() - p.getBonheur());
			res.put(tmp, 0);
		}
		
		Random r = new Random();
		int rand = r.nextInt(totalBonheur);
		for (int j = 0; j<nbEmigr; j++) {
			int compteur = 0;
			int i = 0;
			
			while (compteur < rand) {
				compteur += Math.abs(((Pays)getLinkedNodes(p).get(i)).getBonheur() - p.getBonheur());
				i++;
			}
			
			Pays paysSelect = ((Pays)getLinkedNodes(p).get(i));
			if (paysSelect.getBonheur() > p.getBonheur()) {
				res.put(paysSelect, res.get(paysSelect)+1);
			}
		}		
		return res;
	}
	
	
	
}
