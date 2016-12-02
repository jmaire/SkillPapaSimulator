package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.MenuBar;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import graph.Graph;
import graph.Pays;

public class App extends JFrame {

    public App() {

        JFrame jf = new JFrame();
        JPanel panelGauche = new JPanel();
        JPanel panelDroite = new JPanel();
        JPanel grandPanel = new JPanel();
        grandPanel.add(panelGauche);
        grandPanel.add(panelDroite);
        
        panelDroite.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        panelDroite.setPreferredSize(new Dimension(200,20));
        
        grandPanel.setLayout(new BoxLayout(grandPanel,BoxLayout.X_AXIS));
    	setContentPane(grandPanel); 
        
        
        jf.add(grandPanel);
        
        
        
        panelGauche.setLayout(new BorderLayout());
        jf.setTitle("Skill Papa Simulator");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        Graph gra = new Graph();
        Pays a = new Pays(50,50,3000);
        a.setPopulation(10000);
        Pays a2 = new Pays(50,500,5000);
        a2.setPopulation(6000);
        Pays a3 = new Pays(500,500,4000);
        a3.setPopulation(25000);
        Pays a4 = new Pays(500,50,4000);
        a4.setPopulation(7000);
        Pays a5 = new Pays(275,275,2000);
        a5.setPopulation(3000);
        Pays a6 = new Pays(700,300,15000);
        a5.setPopulation(3000);
        

        gra.addNode(a);
        gra.addNode(a2);
        gra.addNode(a3);
        gra.addNode(a4);
        gra.addNode(a5);
        gra.addNode(a6);
        
        gra.addLink(a, a2);
        gra.addLink(a2, a3);
        gra.addLink(a3, a4);
        gra.addLink(a4, a);
        
        gra.addLink(a, a5);
        gra.addLink(a2, a5);
        gra.addLink(a3, a5);
        gra.addLink(a4, a5);
        gra.addLink(a3, a6);




        Game game = new Game(gra);
        panelGauche.add(game, BorderLayout.CENTER);
        jf.setSize(1000, 700);
    }
}