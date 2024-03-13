package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final String pathName = "mots.txt";
    private static int nbLigne;
    private static Map<Integer, String> mots = new HashMap<>();
    private static Map<String, String> definitions = new HashMap<>();

    public static void compterLignes() {
        nbLigne = 0;
        try {
            File file = new File(pathName);

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                sc.nextLine();
                nbLigne++;
            }

            sc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void lireMotsEtDefinitions(){
        int i = 0;
        try {
            // Créer l'objet File Reader
            FileReader fr = new FileReader(pathName);
            // Créer l'objet BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while(line != null)
            {
                i++;
                String[] splitedLine = line.split(" ");
                int splitedLength = splitedLine[0].length();
                mots.put(i,splitedLine[0]);
                String definition = line.substring(splitedLength);
                definitions.put(splitedLine[0], definition);
                line = br.readLine();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getRandomWord(){
        int randomIndex = genererRandom(1, nbLigne);

        return mots.get(randomIndex);
    }

    public static String getDefintion(String mot){
        return definitions.get(mot);
    }

    private static int genererRandom(int borneInf, int borneSup){
        Random random = new Random();
        return borneInf + random.nextInt(borneSup - borneInf);

    }
}
