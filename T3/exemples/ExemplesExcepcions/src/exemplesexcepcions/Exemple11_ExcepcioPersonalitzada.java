package exemplesexcepcions;

public class Exemple11_ExcepcioPersonalitzada {

    public static void validarEdat(int edat) throws ValidacioException {
        if (edat < 0) {
            throw new ValidacioException("L'edat no pot ser negativa: " + edat);
        }
        System.out.println("Edat valida: " + edat);
    }

    public static void main(String[] args) {
        try {
            validarEdat(20);
            validarEdat(-3);
        } catch (ValidacioException e) {
            System.out.println("S'ha produit una excepcio Personalitzada");
            System.out.println(e.getMessage());
        }

        System.out.println("Final del programa.");
    }
}
