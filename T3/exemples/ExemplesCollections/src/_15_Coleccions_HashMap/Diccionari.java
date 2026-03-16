/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _15_Coleccions_HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jordi
 */
public class Diccionari {

    private Map<String, Paraula> paraules;

    public Diccionari() {
        paraules = new HashMap<>();
    }

    public void afegir(Paraula p) {

        if (!paraules.containsKey(p.getNom().toLowerCase())) {

            paraules.put(p.getNom().toLowerCase(), p);
            System.out.printf("Registre afegit amb èxit\n");
        } else {
            System.out.println("Clau repetida no s'afegeix");
        }

    }

    public void eliminar(String nom) {
        paraules.remove(nom.toLowerCase());
    }

    public Paraula cercar(String nom) {
        return paraules.get(nom.toLowerCase());
    }

    public void mostrar() {
        for (Map.Entry<String, Paraula> entry : paraules.entrySet()) {
            System.out.printf("Clau: %s|", entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
