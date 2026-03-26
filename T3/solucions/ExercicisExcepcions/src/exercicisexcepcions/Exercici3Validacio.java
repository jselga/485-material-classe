/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicisexcepcions;

/**
 *
 * @author jordi
 */
public class Exercici3Validacio {

    public static void main(String[] args) {
        provarUsuari("Anna", 20, "anna@gmail.com");
        provarUsuari(null, 20, "anna@gmail.com");
        provarUsuari("Joan", -5, "joan@gmail.com");
        provarUsuari("Maria", 22, "maria.gmail.com");
    }

    public static void provarUsuari(String nom, int edat, String correu) {
        try {
            validarUsuari(nom, edat, correu);
            System.out.println("Usuari vàlid: " + nom);
        } catch (NullPointerException e) {
            System.out.println("Error: el nom no pot ser null.");
            System.out.println("Excepció: " + e.getClass().getSimpleName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: l'edat ha de ser positiva.");
            System.out.println("Excepció: " + e.getClass().getSimpleName());
        } catch (CorreuInvalidException e) {
            System.out.println("Error: correu invàlid.");
            System.out.println("Missatge: " + e.getMessage());
            System.out.println("Excepció: " + e.getClass().getSimpleName());
        }

        System.out.println();
    }

    public static void validarUsuari(String nom, int edat, String correu)
            throws CorreuInvalidException {

        if (nom == null) {
            throw new NullPointerException("El nom és null");
        }

        if (edat <= 0) {
            throw new IllegalArgumentException("L'edat ha de ser major que zero");
        }

        if (correu == null || !correu.contains("@")) {
            throw new CorreuInvalidException("El correu ha de contenir @");
        }
    }
}
