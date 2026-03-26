/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class SheikahSlate {

    private ArrayList<Monster> monsters = new ArrayList<>();
    private String pathMonsters = "monsters.obj";

    public boolean addMonster(Monster monster) {
        return monsters.add(monster);
    }

    public void showMonsters() {
        if (monsters.isEmpty()) {
            System.out.println("Monsters list is Empty.");
        } else {
            for (Monster monster : monsters) {
                System.out.println(monster);
            }
        }
    }

    public boolean saveMonsters() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(pathMonsters)
            );

            oos.writeObject(monsters);
            oos.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error saving monsters: " + e.getMessage());
            return false;
        }
    }

    public boolean loadMonsters() {
        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(pathMonsters)
            );

            monsters = (ArrayList<Monster>) ois.readObject();
            ois.close();
            return true;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading monsters: " + e.getMessage());
            return false;
        }
    }
}
