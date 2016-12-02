package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.MenuBar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class App extends JFrame {

    public App() {

        JFrame jf = new JFrame();
        JPanel jp = new JPanel();
        jf.add(jp);
        jp.setLayout(new BorderLayout());
        jf.setTitle("Skill Papa Simulator");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        Game game = new Game();
        jp.add(game, BorderLayout.CENTER);
        jf.setSize(1000, 700);
    }
}