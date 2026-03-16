/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package _15_Coleccions_HashMap;

/**
 *
 * @author jordi
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Diccionari dic = new Diccionari();

        dic.afegir(new Paraula("Casa", "Lloc on viu la gent", "CAT"));
        dic.afegir(new Paraula("House", "Building for human habitation", "EN"));
        dic.afegir(new Paraula("Perro", "Animal doméstico", "ES"));
        dic.afegir(new Paraula("Gato", "Animal doméstico felino", "ES"));
        dic.afegir(new Paraula("Gato", "Animal doméstico 2", "ES"));

        System.out.println("Buscar:");
        System.out.println(dic.cercar("casa"));

        System.out.println("\nDiccionari complet:");
        dic.mostrar();
    }

}
