package exemplesexcepcions;

import java.io.FileNotFoundException;

public class Exemple08_Prova2_GestioParcial {

    public static void main(String[] args) {
        ServeiFitxers servei = new ServeiFitxers();

        try {
            servei.crearFitxerBuit("sortida.txt");
        } catch (FileNotFoundException e) {
            System.out.println("S'ha capturat FileNotFoundException.");
        }

        System.out.println("Aquest exemple no compila perque encara falta gestionar IOException.");
    }
}
