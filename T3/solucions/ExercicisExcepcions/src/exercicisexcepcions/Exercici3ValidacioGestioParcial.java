/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicisexcepcions;

/**
 *
 * @author jordi
 */
public class Exercici3ValidacioGestioParcial {

    public static void main(String[] args) {
        provarUsuari("Anna", 20, "anna@gmail.com");
//        provarUsuari(null, 20, "anna@gmail.com");
        provarUsuari("Joan", -5, "joan@gmail.com");
        provarUsuari("Maria", 22, "maria.gmail.com");
    }

    public static void provarUsuari(String nom, int edat, String correu) {
        try {
            validarUsuari(nom, edat, correu);
            System.out.println("Usuari vàlid: " + nom);
        } catch (CorreuInvalidException e) {
            System.out.println("Error: correu invàlid.");
            System.out.println("Missatge: " + e.getMessage());
            System.out.println("Excepció: " + e.getClass().getSimpleName());
        }
        // L'Excepció CorreuInvalidException és de gestió obligada pel complilador ja que és checked
        // Ho hem forçat a la signatura del mètode. Les altres són del tipus RunTime i si no les gestionem ho veure durant l'execució
//        validarUsuari(nom, edat, correu);
        System.out.println();
    }

    public static void validarUsuari(String nom, int edat, String correu)
            throws CorreuInvalidException {
        // RunTime Exception
        // s'utilitza quan el valor és null
        if (nom == null) {
            throw new NullPointerException("El nom és null");
        }

        if (nom.isBlank()) {
            throw new IllegalArgumentException("El nom no pot ser null ni buit");
        }
        // RunTime Exception
        // s'utilitza quan l'argument rebut pel mètode no és vàlid
        if (edat <= 0) {
            throw new IllegalArgumentException("L'edat ha de ser major que zero");
        }
// Checked Exception
        if (correu == null || !correu.contains("@")) {
            throw new CorreuInvalidException("El correu ha de contenir @");
        }
        //IllegalArgumentException és una runtime exception molt adequada per indicar que un mètode ha rebut un argument invàlid.
        //En canvi, una excepció pròpia que hereta de Exception és checked i obliga a tractar-la explícitament amb try-catch o throws.
    }
}
