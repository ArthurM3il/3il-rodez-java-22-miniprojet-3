import jeu.JeuController;
import jeu.JeuModele;
import jeu.JeuVue;
import utils.Utils;

public class Main {

    public static void main(String[] args){
        /*JeuModele modele = new JeuModele();
        JeuVue vue = new JeuVue();
        JeuController controller = new JeuController(modele,vue);*/

        Utils.compterLignes();
        Utils.lireMotsEtDefinitions();
        System.out.println(Utils.getRandomWord());

    }
}
