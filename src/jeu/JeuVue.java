package jeu;

import javax.swing.*;
import java.awt.*;

public class JeuVue extends JFrame {
    public JeuVue(){
        setTitle("Pendu");
        setSize(1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel bouttonPanel = new JPanel();

        JButton bouttonDebut = new JButton("Lancer le jeu");
        bouttonDebut.setLayout(null);
        bouttonDebut.setMaximumSize(new Dimension(200,100));
        bouttonPanel.add(bouttonDebut);

        add(bouttonPanel);

        setVisible(true);
    }
}
