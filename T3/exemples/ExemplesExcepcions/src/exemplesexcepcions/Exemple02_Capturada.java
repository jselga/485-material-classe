package exemplesexcepcions;

public class Exemple02_Capturada {

    public static void main(String[] args) {
        String[] paraules = {"Hola", "Adeu", "Fins dema"};

        try {
            System.out.println("Abans del recorregut");
            for (int i = 0; i <= paraules.length; i++) {
                System.out.println("Posicio " + i + ": " + paraules[i]);
            }
            System.out.println("Despres del recorregut");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("S'ha capturat una ArrayIndexOutOfBoundsException.");
            System.out.println("El recorregut s'ha sortit dels limits de l'array.");
        }

        System.out.println("Final del programa.");
    }
}
