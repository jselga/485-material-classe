package exemplesexcepcions;

public class Exemple10_ThrowsRuntime {

    public static void verificarLongitud(String[] dades, int longitudEsperada) {
        if (dades.length != longitudEsperada) {
            throw new RuntimeException("La longitud esperada era " + longitudEsperada + " pero s'ha rebut " + dades.length + ".");
        }
    }

    public static void main(String[] args) {
        System.out.println("Primera comprovacio correcta");
        verificarLongitud(new String[4], 4);

        System.out.println("Segona comprovacio incorrecta");
        verificarLongitud(new String[4], 2);

        System.out.println("Aquesta linia no s'arriba a executar.");
    }
}
