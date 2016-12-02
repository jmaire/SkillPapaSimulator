package graphique;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import graph.Graph;
import graph.Link;
import graph.Node;
import graph.Pays;

public class Game extends JPanel {

	double x = 0;
	double y = 0;
    protected double speed = 0.1;
    
    Graph gra = new Graph();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        paintNodes(g2d);
        paintLink(g2d);
    }
    
    public void paintNodes(Graphics2D g2d){
    	for(int i=0;i<gra.getNodes().size();i++){
    		 
    		int population = ((Pays) gra.getNodes().get(i)).getPopulation()/100;
    		if(i == 4){
    			((Pays) gra.getNodes().get(i)).setPopulation(((Pays) gra.getNodes().get(i)).getPopulation()-1);
    		}
    		g2d.setColor(Color.black);
    		int rayon = ((Pays) gra.getNodes().get(i)).getPopulationMax()/100;
    		//System.out.println(rayon + "_" +  population);
    		
            g2d.fillOval((int)gra.getNodes().get(i).getX() - (population/2), (int)gra.getNodes().get(i).getY()- (population/2), population, population);
            g2d.setColor(Color.red);
      
            g2d.drawOval((int)gra.getNodes().get(i).getX()- (rayon/2), (int)gra.getNodes().get(i).getY()- (rayon/2), rayon, rayon);
            g2d.setColor(Color.black);
            
        }
    }
    
    public void paintLink(Graphics2D g2d){
    	ArrayList<Link> aLinks=gra.getLink();
    	for(int i = 0; i<aLinks.size();i++){
            g2d.draw(new Line2D.Double(aLinks.get(i).getNode1().getX(), aLinks.get(i).getNode1().getY(), aLinks.get(i).getNode2().getX(), aLinks.get(i).getNode2().getY()));
    	}
    }
    
    public Game(Graph gra){
    	ThreadDessin thread = new ThreadDessin(this);
    	this.gra = gra;
    	thread.start();
    }
   
        
    private void moveBall(long d_time) {
        x = x + speed*(double)d_time;
        y = y + speed*(double)d_time;
    }
    

    
    public void draw(long d_time) {

        repaint();
    }
  
}