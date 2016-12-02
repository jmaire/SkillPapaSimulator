package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import graph.Graph;
import graph.Pays;

public class App extends JFrame {

    public App() {

        JFrame jf = new JFrame();
        JPanel jp = new JPanel();
        jf.add(jp);
        jp.setLayout(new BorderLayout());
        jf.setTitle("Skill Papa Simulator");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        Graph gra = new Graph();
        Pays a = new Pays(400,400,50);
        Pays a2 = new Pays(100,5,50);
        Pays a3 = new Pays(600,100,50);
        Pays a4 = new Pays(100,100,50);
        Pays a5 = new Pays(200,50,50);

        gra.addNode(a);
        gra.addNode(a2);
        gra.addNode(a3);
        gra.addNode(a4);
        gra.addNode(a5);
        
        gra.addLink(a, a2);
        gra.addLink(a2, a3);
        gra.addLink(a5, a4);
        gra.addLink(a4, a2);




        Game game = new Game(gra);
        jp.add(game, BorderLayout.CENTER);
        jf.setSize(1000, 700);
    }
}