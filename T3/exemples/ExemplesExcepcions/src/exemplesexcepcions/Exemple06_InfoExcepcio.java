package exemplesexcepcions;

public class Exemple06_InfoExcepcio {

    public static void main(String[] args) {
        try {
            provocarError();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Missatge de l'excepcio:");
            System.out.println(e.getMessage());

            System.out.println("\nClasse de l'excepcio:");
            System.out.println(e.getClass().getName());

            System.out.println("\nRepresentacio amb toString():");
            System.out.println(e.toString());

            System.out.println("\nStack trace:");
            System.out.println("COMPTE: Pot sortir en qualsevol lloc del output en vermell");
            e.printStackTrace();
        }
    }

    public static void provocarError() {
        String[] paraules = {"Hola", "Adeu", "Fins dema"};
        for (int i = 0; i <= paraules.length; i++) {
            System.out.println(paraules[i]);
        }
    }
}
