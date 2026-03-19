package exemplesexcepcions;

public class Exemple03_CatchIncorrecteIFinally {

    public static void main(String[] args) {
        String[] paraules = {"Hola", "Adeu", "Fins dema"};

        try {
            System.out.println("Abans del recorregut");
            for (int i = 0; i <= paraules.length; i++) {
                System.out.println("Posicio " + i + ": " + paraules[i]);
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Aquest catch no serveix per a l'error que es produeix.");
        } finally {
            System.out.println("El bloc finally s'executa sempre.");
        }

        System.out.println("Aquesta linia no s'arriba a executar.");
    }
}
