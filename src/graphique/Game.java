package graphique;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class Game extends JPanel {

	double x = 0;
	double y = 0;
    protected double speed = 0.1;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //System.out.println("im goint to filloval now");
        g2d.fillOval((int)x, (int)y, 30, 30);
        System.out.println((int)x + " " + (int)y);
    }
    
    public Game(){
    	ThreadDessin thread = new ThreadDessin(this);
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