import jeu.JeuModele;
import jeu.JeuVue;
import org.junit.Assert;
import org.junit.Test;
import utils.Utils;

public class Tests {
    JeuVue vue = new JeuVue();
    JeuModele modele = new JeuModele();
    @Test
    public void testMethodeModele() {
        Assert.assertFalse(modele.isLetterInWord("("));
    }

    @Test
    public void testUtilCompterLigne(){
        Assert.assertEquals(Utils.compterLignes(),58);
    }
}
