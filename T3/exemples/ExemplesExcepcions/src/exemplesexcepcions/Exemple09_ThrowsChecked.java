package exemplesexcepcions;

public class Exemple09_ThrowsChecked {

    public static void verificarLongitud(String[] dades, int longitudEsperada) throws Exception {
        if (dades.length != longitudEsperada) {
            throw new Exception("La longitud esperada era " + longitudEsperada + " pero s'ha rebut " + dades.length + ".");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Primera comprovacio correcta");
            verificarLongitud(new String[4], 4);

            System.out.println("Segona comprovacio incorrecta");
            verificarLongitud(new String[4], 2);

            System.out.println("Aquesta linia ja no s'executa.");
        } catch (Exception e) {
            System.out.println("S'ha capturat l'excepcio checked llancada amb throw.");
            System.out.println(e.getMessage());
        }
    }
}
