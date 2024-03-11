package jeu;

public class JeuController {
    private JeuModele modele;
    private JeuVue vue;

    public JeuController(JeuModele modele, JeuVue vue){
        this.modele = modele;
        this.vue = vue;
    }
}
