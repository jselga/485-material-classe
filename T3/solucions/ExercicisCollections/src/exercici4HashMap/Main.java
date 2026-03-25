/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici4HashMap;

/**
 *
 * @author jordi
 */
public class Main {

    public static void main(String[] args) {
        Cataleg cataleg = new Cataleg();

        System.out.println("=== AFEGIR PRODUCTES ===");
        System.out.println(cataleg.afegir(new Producte("P001", "Teclat", 29.99)));
        System.out.println(cataleg.afegir(new Producte("P002", "Ratolí", 15.50)));
        System.out.println(cataleg.afegir(new Producte("P003", "Monitor", 189.95)));
        System.out.println(cataleg.afegir(new Producte("P004", "Portàtil", 799.00)));
        System.out.println(cataleg.afegir(new Producte("P005", "Webcam", 45.25)));

        System.out.println("\n=== MOSTRAR CODIS ===");
        cataleg.mostrarCodis();

        System.out.println("\n=== CERCAR 2 PRODUCTES ===");
        System.out.println("Cerca P002: " + cataleg.cercar("P002"));
        System.out.println("Cerca P004: " + cataleg.cercar("P004"));
        System.out.println("Cerca P042: " + cataleg.cercar("P042"));
        System.out.println("\n=== MOSTRAR TOT ===");
        cataleg.mostrarTot();
        System.out.println("\n=== PROVAR AFEGIR CODI REPETIT ===");
        boolean afegit = cataleg.afegir(new Producte("P003", "Altaveus", 39.99));
        if (!afegit) {
            System.out.println("No s'ha pogut afegir: el codi P003 ja existeix.");
        }

        System.out.println("\n=== ACTUALITZAR PREU ===");
        System.out.println("Actualitzant Producte amb codi P005");
        boolean actualitzat = cataleg.actualitzarPreu("P005", 49.99);
        if (actualitzat) {
            System.out.println("Preu actualitzat correctament.");
        } else {
            System.out.println("No s'ha trobat el producte.");
        }

        System.out.println("\n=== MOSTRAR TOT ===");
        cataleg.mostrarTot();
    }
}
