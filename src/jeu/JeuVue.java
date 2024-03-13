package jeu;

import utils.Utils;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JeuVue extends JFrame {
    private JPanel boutonPanel;
    private TextField propositionLettre;
    private TextField motADeviner;
    private JPanel panelJeu;
    private JPanel panelEssai;
    private JLabel essaiMessage;
    private int essais = 10;
    private JFrame gestionResultat;
    public JeuVue(){
        setTitle("Pendu");
        setSize(1080,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        essaiMessage = new JLabel("Nombre d'essai : " + essais);

        panelEssai = new JPanel();
        panelEssai.setBounds(10,10,200,100);
        propositionLettre = new TextField(1);

        boutonPanel = new JPanel();
        panelJeu = new JPanel();
        panelJeu.add(new JLabel("Entrez une lettre"));
        panelJeu.setBounds(200,10,200,100);

        JButton bouttonDebut = new JButton("Lancer le jeu");
        bouttonDebut.setLayout(null);
        bouttonDebut.setMaximumSize(new Dimension(200,100));
        bouttonDebut.addActionListener(ActionListener -> lancerPendu());
        boutonPanel.add(bouttonDebut);

        add(boutonPanel);

        setVisible(true);

        propositionLettre.addActionListener(actionEvent -> {
            if(!propositionLettre.getText().isEmpty()){
                if(!(JeuController.isLetterInWord(propositionLettre.getText()))) essais --;
            }
            motADeviner.setText(JeuController.getMotAffiche().toString());
            essaiMessage.setText("Nombre d'essai : " + essais);
            panelEssai.updateUI();
            panelJeu.updateUI();
            if (JeuController.isWordDiscovered()) affichageResultatPendu(true);
            if (essais == 0) affichageResultatPendu(false);
        });
    }

    public void lancerPendu(){
        panelEssai.add(essaiMessage);

        panelJeu.add(propositionLettre);
        motADeviner = new TextField(JeuController.getNombreLettre());
        motADeviner.setEditable(false);
        motADeviner.setText(JeuController.getMotAffiche().toString());
        panelJeu.add(motADeviner);
        remove(boutonPanel);
        add(panelJeu);
        add(panelEssai);
        setVisible(true);
    }

    public void affichageResultatPendu(boolean resultat){
        gestionResultat = new JFrame();
        JPanel victoire = new JPanel();
        victoire.add(new JLabel("Félicitations ! Le mot était : " + JeuController.getMotADeviner() + " Il vous restait " + essais + " essais !"));

        JPanel defaite = new JPanel();
        defaite.add(new JLabel("Dommage.. Le mot était : " + JeuController.getMotADeviner()));

        if(resultat) gestionResultat.add(victoire);
        else gestionResultat.add(defaite);

        gestionResultat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gestionResultat.setLocationRelativeTo(null);
        gestionResultat.setSize(500,250);
        gestionResultat.setVisible(true);
    }
}
