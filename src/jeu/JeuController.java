package jeu;

public class JeuController {
    private static JeuModele modele;
    private static JeuVue vue;

    public JeuController(JeuModele modele, JeuVue vue){
        this.modele = modele;
        this.vue = vue;
    }

    public static int getNombreLettre(){
       return modele.getNbLettre();
    }

    public static StringBuilder getMotAffiche(){
        return modele.getMotAffiche();
    }

    public static boolean isLetterInWord(String lettre){
        return modele.isLetterInWord(lettre);
    }

    public static String getMotADeviner(){
        return modele.getMotADeviner();
    }

    public static boolean isWordDiscovered(){
        return modele.isWordDiscovered();
    }
}
