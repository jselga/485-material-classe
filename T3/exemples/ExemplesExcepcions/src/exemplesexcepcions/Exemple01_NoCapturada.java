package exemplesexcepcions;

public class Exemple01_NoCapturada {

    public static void main(String[] args) {
        String[] paraules = {"Hola", "Adeu", "Fins dema"};

        System.out.println("Recorregut incorrecte d'un array:");
        for (int i = 0; i <= paraules.length; i++) {
            System.out.println("Posicio " + i + ": " + paraules[i]);
        }

        System.out.println("Aquesta linia no s'arriba a executar.");
    }
}
