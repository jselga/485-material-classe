package exemplesexcepcions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exemple08_Prova3_GestioCompleta {

    public static void main(String[] args) {
        ServeiFitxers servei = new ServeiFitxers();

        try {
            servei.crearFitxerBuit("/something/sortida.txt");
            System.out.println("Hem tornat del metode crearFitxerBuit().");
        } catch (FileNotFoundException e) {
            System.out.println("No s'ha pogut crear el fitxer.");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Hi ha hagut un problema d'entrada/sortida.");
            System.out.println(e.getMessage());
        }

        System.out.println("Final del programa.");
    }
}
