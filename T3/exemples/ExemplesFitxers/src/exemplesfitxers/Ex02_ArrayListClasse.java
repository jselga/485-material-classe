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

public class Ex02_ArrayListClasse {

    public static void main(String[] args) {

        String fitxer = "dades.dat";

        // Crear dades
        ArrayList<Personatge> noms = new ArrayList<>();
        noms.add(new Personatge("Link"));
        noms.add(new Personatge("Zelda"));
        noms.add(new Personatge("Ganon"));

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
            System.out.println(e);
        }

        // Llegir
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fitxer)
            );

            ArrayList<String> recuperat
                    = (ArrayList<String>) ois.readObject();

            ois.close();

            System.out.println("📂 Dades recuperades:");
            for (String nom : recuperat) {
                System.out.println(nom);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error llegint dades");
            System.out.println(e);
        }
    }
}
