package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Graph {
	
	public static final double TAUX_EMIGRATION = 1; 
	
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
		HashMap<Pays, HashMap<Pays, Integer>> up = new HashMap<>();
		/* Calcul des mouvements dans le monde entier */
		for (Pays pays : nodes) {
			pays.update();
			int nbEmigrant = 0;
			if(pays.getBonheur() <= 1){
				continue;
			}
			nbEmigrant = (int) ((pays.getBonheur()-1.f)/500.f * pays.getPopulationMax());
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
		for (Pays pays : nodes) {
			System.out.println(pays + "- " + pays.population + " " + pays.getBonheur());
		}
	}
	
	public HashMap<Pays, Integer> roulette(Pays p, int nbEmigr) {
		HashMap<Pays, Integer> res = new HashMap<>();
		
		/*Total des differences absolues de bonheur*/
		double totalBonheur = 0;
		ArrayList<Pays> linkedTrue = new ArrayList<>();
		int g = getLinkedNodes(p).size();
		for (int i = 0; i<g; i++) {
			Pays tmp = getLinkedNodes(p).get(i);
			if(tmp.getBonheur() < p.getBonheur()) {
				totalBonheur += p.getBonheur()/tmp.getBonheur();
				res.put(tmp, 0);
				linkedTrue.add(tmp);
			}
		}
		
		if (totalBonheur == 0){
			return res;
		}
		
		Random r = new Random();
		double rand = r.nextDouble() * totalBonheur ;
		for (int j = 0; j<nbEmigr; j++) {
			double compteur = p.getBonheur()/linkedTrue.get(0).getBonheur();
			int i;
			for (i=0; i<linkedTrue.size()-1; i++){
				if(compteur >= rand){
					break;
				}
				compteur += p.getBonheur()/linkedTrue.get(i+1).getBonheur();
			}
			
			Pays paysSelect = linkedTrue.get(i);
			res.put(paysSelect, res.get(paysSelect)+1);
		}		
		return res;
	}
	
	
	
}
