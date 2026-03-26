/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicisfitxers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author jordi
 */
public class Exercici1ArrayList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rutaFitxer = "llistat.obj";
        ArrayList<String> llista = new ArrayList<>();
        llista.add("Stone");
        llista.add("Paper");
        llista.add("Scissors");
        llista.add("Lizard");
        llista.add("Spock");
        System.out.println("Mostrant llista abans de guardar");
        System.out.println(llista);
        guardar(llista, rutaFitxer);

        ArrayList<String> llistaRecuperada = new ArrayList<>();
        llistaRecuperada = carregar(rutaFitxer);
        System.out.println("Mostrant llista carregada");
        System.out.println(llistaRecuperada);
    }

    public static void guardar(ArrayList<String> llStrings, String ruta) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta));
            oos.writeObject(llStrings);
            oos.close();
            System.out.println("Fitxer guardat amb èxit");
        } catch (IOException ex) {
            System.out.println("Error guardant les dades");
            System.out.println("Excepció: " + ex.getClass().getName() + " " + ex.getMessage());
        }
    }

    public static ArrayList<String> carregar(String ruta) {
        ArrayList<String> llStrings = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta));
            llStrings = (ArrayList<String>) ois.readObject();
            ois.close();
            System.out.println("Fitxer carregat amb èxit");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error carregant les dades");
            System.out.println("Excepció: " + ex.getClass().getName() + " " + ex.getMessage());
        }
        return llStrings;
    }

}
