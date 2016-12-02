package graphique;

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
            g2d.fillOval((int)gra.getNodes().get(i).getX()-15, (int)gra.getNodes().get(i).getY()-15, 30, 30);
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
       
    	moveBall(d_time);
        repaint();
    }
  
}