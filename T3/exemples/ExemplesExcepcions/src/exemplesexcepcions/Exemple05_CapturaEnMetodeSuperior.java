package exemplesexcepcions;

public class Exemple05_CapturaEnMetodeSuperior {

    public static void main(String[] args) {
        System.out.println("main() crida met01()");
        met01();
        System.out.println("main() continua despres de gestionar l'error.");
    }

    public static void met01() {
        try {
            System.out.println("met01() crida met02()");
            met02();
            System.out.println("Aquesta linia no s'executa si hi ha error a met02().");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("met01() ha capturat l'excepcio propagada des d'un metode interior.");
        }
    }

    public static void met02() {
        String[] paraules = {"Hola", "Adeu", "Fins dema"};
        for (int i = 0; i <= paraules.length; i++) {
            System.out.println("Posicio " + i + ": " + paraules[i]);
        }
    }
}
