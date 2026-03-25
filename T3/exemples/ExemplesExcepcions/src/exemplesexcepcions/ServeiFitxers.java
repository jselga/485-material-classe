package exemplesexcepcions;

import java.io.FileOutputStream;
import java.io.IOException;

public class ServeiFitxers {

    public void crearFitxerBuit(String nomFitxer) throws IOException {
        FileOutputStream fitxer = new FileOutputStream(nomFitxer);
        fitxer.close();
        System.out.println("Fitxer creat i tancat correctament.");
    }
}
