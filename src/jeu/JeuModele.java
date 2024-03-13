package jeu;

import utils.Utils;

import java.nio.charset.Charset;

public class JeuModele {
    private String motADeviner;
    private String definition;
    private StringBuilder motAffiche;
    public JeuModele(){
        motADeviner = Utils.getRandomWord();
        motAffiche = initMotAffiche();
        definition = Utils.getDefintion(motADeviner);
    }

    public StringBuilder initMotAffiche(){
        StringBuilder rep = new StringBuilder();
        System.out.println(motADeviner);
        for (int i = 0; i < motADeviner.length(); i++) {
            if (motADeviner.charAt(i) == '-') rep.append("-");
            else rep.append("_");
        }
        return rep;
    }

    public int getNbLettre(){
        return motADeviner.length();
    }

    public StringBuilder getMotAffiche() {
        return motAffiche;
    }

    public String getMotADeviner(){
        return motADeviner;
    }

    public boolean isLetterInWord(String lettre){
        boolean rep = false;
        for (int i = 0; i < motADeviner.length(); i++) {
            if(motADeviner.charAt(i) == lettre.charAt(0)){
                rep = true;
                motAffiche.setCharAt(i,lettre.charAt(0));
            }else rep = false;
        }
        System.out.println(motAffiche);
        return rep;
    }

    public boolean isWordDiscovered(){
        return motADeviner.contentEquals(motAffiche);
    }
}
