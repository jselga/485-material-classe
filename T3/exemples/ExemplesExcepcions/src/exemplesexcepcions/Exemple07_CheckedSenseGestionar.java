package exemplesexcepcions;

import java.io.FileOutputStream;

public class Exemple07_CheckedSenseGestionar {

    public static void main(String[] args) {
        // Exemple intencionadament incorrecte.
        // No compila perque FileOutputStream() i close() poden llencar checked exceptions.
        // Aquests mètodes obliguen a capturar o delegar: must be caught o declared to be thrown
        FileOutputStream fitxer = new FileOutputStream("/something/sortida.txt");
        fitxer.close();
    }
}
