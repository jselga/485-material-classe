/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package _14_Coleccions_TreeSet;

import java.util.TreeSet;

/**
 *
 * @author jordi
 */
public class PrincipalLlibre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeSet<Llibre> llibres = new TreeSet<>();

        Llibre l1 = new Llibre("Programció en Java", "Maria", 1111);
        Llibre l2 = new Llibre("LLenguatges servidors web: PHP", "Carlos", 1111);
        Llibre l3 = new Llibre("Learn Ubuntu", "Adria", 4444);
        Llibre l4 = new Llibre("Android Studio", "Pau", 2222);

        llibres.add(l1);
        llibres.add(l2);
        llibres.add(l3);
        llibres.add(l4);
        System.out.println("Ordenat per ISBN (Comparable)");
        for (Llibre llibre : llibres) {
            System.out.println(llibre);

        }
        System.out.println("Ordenat per Títol (Comparator)");
        ComparatorTitol comparatorTitol = new ComparatorTitol();
        TreeSet<Llibre> llibresOrdenatsPerTitol = new TreeSet<>(comparatorTitol);
        llibresOrdenatsPerTitol.addAll(llibres);
        for (Llibre llibre : llibresOrdenatsPerTitol) {
            System.out.println(llibre);
        }

    }

}
