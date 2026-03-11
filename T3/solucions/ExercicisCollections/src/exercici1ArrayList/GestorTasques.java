/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici1ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public Tasca cercaTascaPerTitol(String titol) {
        for (Tasca tasca : tasques) {
            if (tasca.getTitol().equalsIgnoreCase(titol)) {
                return tasca;
            }
        }
        return null;
    }

    public boolean eliminarPerTitol(String titol) {
        Tasca t = cercaTascaPerTitol(titol);
        if (t != null) {
            return tasques.remove(t);
        }

        return false;
    }

    public void marcarCompletada(String titol) {
        Tasca t = cercaTascaPerTitol(titol);
        if (t != null) {
            t.setCompletada(true);
        }

    }

    public void ordenarPerPrioritatDesc() {
        tasques.sort(new Comparator<Tasca>() {
            @Override
            public int compare(Tasca t1, Tasca t2) {
                // return t2.getPrioritat()-t1.getPrioritat();
                return Integer.compare(t2.getPrioritat(), t1.getPrioritat());
            }
        });

    }

    public List<Tasca> pendents() {
        List<Tasca> resultat = new ArrayList<>();

        for (Tasca t : tasques) {
            if (!t.isCompletada()) {
                resultat.add(t);
            }
        }
        return resultat;

    }
    public void mostrar() {
        for (Tasca t : tasques) {
            System.out.println(t);
        }
    }

}
