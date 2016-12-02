package graph;

import java.util.Random;
import java.util.TreeSet;



public class Pays extends Node{

	public static final int BONHEUR_MIN = 0;
	public static final int BONHEUR_MAX = 100;
	public static final int BONHEUR_INIT = (BONHEUR_MAX - BONHEUR_MIN)/2;
	
	
	protected double bonheur;
	protected int population;
	protected int populationMax;
	protected TreeSet<Parametre> params;
		
	public Pays(int x, int y, int popMax) {
		super(x,y);
		bonheur = (new Random()).nextInt(100);
		population = 0;
		populationMax = popMax;
	}
	
	
	public void setBonheur(int newBonheur) {
		bonheur = newBonheur;
	}
	
	public double getBonheur() {
		return bonheur;
	}
	
	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
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
		/*
		//double coef = Math.atan(populationMax - population)*2/Math.PI;
		double coef = Math.max(-1, Math.min(1, (populationMax - population)/populationMax));
		if (coef > 0) {
			bonheur += (BONHEUR_MAX - bonheur) * coef;
		} else {
			bonheur += bonheur * coef;
		}
		*/
		
		double coef = 0;
		if(population >= populationMax) {
			coef = populationMax/(float)population;
			bonheur = (BONHEUR_MAX - bonheur) * coef;
		}
		else {
			coef = -population/(float)populationMax;
			bonheur = bonheur * coef;
		}
		bonheur = population / (float) populationMax;
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
