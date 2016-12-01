package graph;

import java.util.TreeSet;

public class Pays extends Node{
	
	private int surface;
	private int bohneur; 
	private TreeSet<Parametre> params;
	
	
	public Pays(int x, int y, int s) {
		super(x,y);
		surface = s;
		bohneur = 100;
	}
	
	public int getSurface() {
		return surface;
	}
	
	public int getBohneur() {
		return bohneur;
	}

	public void addParam(Parametre p) {
		params.add(p);
	}
	
	public void removeParam(Parametre p) {
		params.remove(p);
	}
	
	public void update() {
		for (Parametre p : params) {
			bohneur += p.getBonus();
		}
	}
	
	public String toString() {
		String txt = "Pays de surface : "+ surface + "\n";
		if (!params.isEmpty()) {
			txt += " Informations supplémentaire  : \n";
			for (Parametre p : params) {
				txt += p.getName()  + "\n";	
			}
		}
		return txt;
	}
	
}
