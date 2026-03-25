package exemplesexcepcions;

public class Exemple08_Prova1_NoCompila {

    public static void main(String[] args) {
        ServeiFitxers servei = new ServeiFitxers();
        // No compila: el metode delega IOException i aqui no es gestiona.
        servei.crearFitxerBuit("sortida.txt");
    }
}
