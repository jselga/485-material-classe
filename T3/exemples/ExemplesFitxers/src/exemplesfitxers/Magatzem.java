/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplesfitxers;

/**
 *
 * @author jordi
 */
import java.io.*;
import java.util.ArrayList;

public class Magatzem {

    private ArrayList<Material> materials;
    private String fitxer = "magatzem.dat";

    public Magatzem() {
        materials = new ArrayList<>();
    }

    public void afegir(Material m) {
        materials.add(m);
    }

    public void mostrar() {
        for (Material m : materials) {
            System.out.println(m);
        }
    }

    public void guardar() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(fitxer)
            );

            oos.writeObject(materials);
            oos.close();

            System.out.println("✔ Magatzem guardat");

        } catch (IOException e) {
            System.out.println("Error guardant magatzem");
        }
    }

    public void carregar() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(fitxer)
            );

            materials = (ArrayList<Material>) ois.readObject();
            ois.close();

            System.out.println("📂 Magatzem carregat");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error carregant magatzem");
        }
    }
}
