package utils;

import java.util.Scanner;

public class Utils {

    public static void validarNom(String nom) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("El nom del curs no pot estar buit.");
        }
    }

    public static void validarNivell(String nivell) {
        if (nivell == null || nivell.isBlank()) {
            throw new IllegalArgumentException("El nivell no pot estar buit.");
        }

    }

    public static void validarId(int id, String missatge) {
        if (id <= 0) {
            throw new IllegalArgumentException(missatge);
        }
    }

    public static int llegirEnter(Scanner scanner, String missatge) {
        while (true) {
            System.out.print(missatge);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Has d'introduir un enter.");
            }
        }
    }

    public static String llegirText(Scanner scanner, String missatge) {
        System.out.print(missatge);
        return scanner.nextLine();
    }
}
