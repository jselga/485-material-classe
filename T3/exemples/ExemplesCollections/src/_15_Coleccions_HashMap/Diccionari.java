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
        paraules.put(p.getNom().toLowerCase(), p);
    }

    public void eliminar(String nom) {
        paraules.remove(nom.toLowerCase());
    }

    public Paraula cercar(String nom) {
        return paraules.get(nom.toLowerCase());
    }

    public void mostrar() {
        for (Map.Entry<String, Paraula> entry : paraules.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
