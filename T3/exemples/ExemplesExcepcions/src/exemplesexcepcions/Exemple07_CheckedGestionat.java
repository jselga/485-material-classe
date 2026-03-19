package exemplesexcepcions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Exemple07_CheckedGestionat {

    public static void main(String[] args) {
        // Exemple intencionadament incorrecte.
        // No compila perque FileOutputStream() i close() poden llencar checked exceptions.
        // Aquests mètodes obliguen a capturar o delegar: must be caught o declared to be thrown
        FileOutputStream fitxer = null;
        try {
            fitxer = new FileOutputStream("/something/sortida.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
        try {
            fitxer.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }
}
