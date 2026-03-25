/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplesfitxers;

/**
 *
 * @author jordi
 */
import java.io.*;
import java.util.ArrayList;

public class Ex01_ArrayList {

    public static void main(String[] args) {

        String fitxer = "dades.dat";

        // Crear dades
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Link");
        noms.add("Zelda");
        noms.add("Ganon");

        // Guardar
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fitxer)
            );

            oos.writeObject(noms);
            oos.close();

            System.out.println("✔ Llista guardada correctament");

        } catch (IOException e) {
            System.out.println("Error guardant dades");
        }

        // Llegir
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fitxer)
            );

            ArrayList<String> nomsRecuperats = (ArrayList<String>) ois.readObject();

            ois.close();

            System.out.println("📂 Dades recuperades:");
            for (String nom : nomsRecuperats) {
                System.out.println(nom);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error llegint dades");
        }
    }
}
