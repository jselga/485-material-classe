package exemplesexcepcions;

public class Exemple04_PropagacioFinsMain {

    public static void main(String[] args) {
        System.out.println("main() crida met01()");
        met01();
        System.out.println("No es torna correctament a main().");
    }

    public static void met01() {
        System.out.println("met01() crida met02()");
        met02();
        System.out.println("No es torna correctament a met01().");
    }

    public static void met02() {
        String[] paraules = {"Hola", "Adeu", "Fins dema"};
        for (int i = 0; i <= paraules.length; i++) {
            System.out.println("Posicio " + i + ": " + paraules[i]);
        }
    }
}
