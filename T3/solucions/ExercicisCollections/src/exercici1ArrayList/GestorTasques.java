/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici1ArrayList;

import java.util.ArrayList;

/**
 *
 * @author jordi
 */
public class GestorTasques {

    private ArrayList<Tasca> tasques;

    public GestorTasques() {
        this.tasques = new ArrayList<>();
    }

    public void afegir(Tasca t) {
        tasques.add(t);

    }

    public boolean eliminarPerTitol(String titol) {
        return false;
    }

    public void marcarCompletada(String titol) {

    }

    public void ordenarPerPrioritatDesc() {

    }

    public void mostrar() {

    }

}
