package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Graph {
	
	public static final double TAUX_EMIGRATION = 0.3; 
	
	ArrayList<Pays> nodes;
	ArrayList<Frontiere> links;
	
	public Graph() {
		nodes = new ArrayList<Pays>();
		links = new ArrayList<Frontiere>();
	}
	
	public ArrayList<Pays> getNodes(){
		return nodes;
	}
	
	public ArrayList<Frontiere> getLink(){
		return links;
	}
	
	
	public void addNode(Pays... n) {
		for(Pays p : n) {
			if (!nodes.contains(p)) {
				nodes.add(p);
			}
		}
	}
	
	public void addLink(Pays n1, Pays n2) {
		if (nodes.contains(n1) && nodes.contains(n2) && n1!=n2) {
			links.add(new Frontiere(n1,n2));
		}
	}
	
	public ArrayList<Pays> getLinkedNodes(Pays n) {
		ArrayList<Pays> res = new ArrayList<Pays>();
		for(Frontiere l : links){
			Pays tmpNode = (Pays) l.getNeighbour(n);
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

	public boolean existingLink(Pays n1, Pays n2) {
		for (Frontiere l : links) {
			if (l.getNode1() == n1 || l.getNode2() == n1){
				if (getLinkedNodes(n1).contains(n2)){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void update() {
		System.out.print("a");
		HashMap<Pays, HashMap<Pays, Integer>> up = new HashMap<>();
		/* Calcul des mouvements dans le monde entier */
		for (Pays pays : nodes) {
			pays.update();
			int nbEmigrant = (int)((Pays.BONHEUR_MAX - pays.getBonheur()) * TAUX_EMIGRATION);
			up.put(pays, roulette(pays, nbEmigrant));			
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
			Pays tmp = getLinkedNodes(p).get(i);
			totalBonheur += Math.abs(tmp.getBonheur() - p.getBonheur());
			res.put(tmp, 0);
		}
		
		if (totalBonheur == 0){
			return res;
		}
		
		Random r = new Random();
		int rand = r.nextInt(totalBonheur);
		for (int j = 0; j<nbEmigr; j++) {
			int compteur = 0;
			int i = -1;
			
			while (compteur < rand) {
				i++;
				compteur += Math.abs(getLinkedNodes(p).get(i).getBonheur() - p.getBonheur());
				
			}
			
			Pays paysSelect = getLinkedNodes(p).get(i);
			if (paysSelect.getBonheur() > p.getBonheur()) {
				res.put(paysSelect, res.get(paysSelect)+1);
			}
		}		
		return res;
	}
	
	
	
}
