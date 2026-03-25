/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici4HashMap;

/**
 *
 * @author jordi
 */
import java.util.HashMap;
import java.util.Map;
// Com que la clau és una String ja té implementat el Comparable, la classe no cal!

public class Cataleg {

    private HashMap<String, Producte> productes;

    public Cataleg() {
        productes = new HashMap<>();
    }
// Si el codi existeix no l'afegeix i retorna false

    public boolean afegir(Producte p) {
        if (productes.containsKey(p.getCodi())) {
            return false;
        }
        productes.put(p.getCodi(), p);
        return true;
    }
//La cerca és molt més àgil per qui programa

    public Producte cercar(String codi) {
        return productes.get(codi);
    }
//Podem reutilitzar el mètode cercar

    public boolean actualitzarPreu(String codi, double nouPreu) {
        Producte p = cercar(codi);
        if (p == null) {
            return false;
        }
        p.setPreu(nouPreu);
        return true;
    }

    public boolean eliminar(String codi) {
        return productes.remove(codi) != null;
    }

    public void mostrarCodis() {
        System.out.println("Codis del catàleg:");
        for (String codi : productes.keySet()) {
            System.out.println("- " + codi);
        }
    }

    public void mostrarTot() {
        System.out.println("Contingut complet del catàleg:");
        for (Map.Entry<String, Producte> entry : productes.entrySet()) {
            System.out.println("Clau: " + entry.getKey() + " -> Valor: " + entry.getValue());
        }
    }
}
