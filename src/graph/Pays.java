package graph;

import java.util.TreeSet;



public class Pays extends Node{

	public static final int BONHEUR_MIN = 0;
	public static final int BONHEUR_MAX = 100;
	public static final int BONHEUR_INIT = (BONHEUR_MAX - BONHEUR_MIN)/2;
	
	
	private int bonheur;
	private int population;
	private int populationMax;
	private TreeSet<Parametre> params;
		
	public Pays(int x, int y, int popMax) {
		super(x,y);
		bonheur = BONHEUR_INIT;
		population = 0;
		populationMax = popMax;
	}
	
	public int getBonheur() {
		return bonheur;
	}
	
	public int getPopulationMax() {
		return populationMax;
	}

	public void addParam(Parametre p) {
		params.add(p);
	}
	
	public void removeParam(Parametre p) {
		params.remove(p);
	}
	
	public void update() {
		double coef = Math.atan(populationMax - population)*2/Math.PI;
		if (coef > 0) {
			bonheur += (BONHEUR_MAX - bonheur) * coef;
		} else {
			bonheur += bonheur * coef;
		}
	}
	
	
	
    /*public String toString() {
		if (!params.isEmpty()) {
			txt += " Informations supplémentaire  : \n";
			for (Parametre p : params) {
				txt += p.getName()  + "\n";	
			}
		}
		return txt;
	}*/

	
}
