import jeu.JeuController;
import jeu.JeuModele;
import jeu.JeuVue;
import utils.Utils;

public class Main {

    public static void main(String[] args){
        JeuVue vue = new JeuVue();
        JeuModele modele = new JeuModele();
        JeuController controller = new JeuController(modele,vue);
    }
}
