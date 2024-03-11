package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static final String pathName = "mots.txt";
    private static int nbLigne;

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

    public static String lireMotAleatoire(){
        int ligneALire = genererRandom(1, nbLigne);
        String[] line = new String[0];
        try {
            //lire le fichier file.txt
            FileReader file = new FileReader(pathName);
            BufferedReader buffer = new BufferedReader(file);

            // parcourir le fichier
            for (int i = 1; i <= ligneALire ; i++) {
                if (i == ligneALire)
                    line = buffer.readLine().split(" ");
                else
                    buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line[0];
    }

    private static int genererRandom(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }
}
