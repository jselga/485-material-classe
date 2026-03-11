/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici1ArrayList;

/**
 *
 * @author jordi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorTasques gestor = new GestorTasques();

        gestor.afegir(new Tasca("Estudiar Java", 2));
        gestor.afegir(new Tasca("Fer exercicis", 1));
        gestor.afegir(new Tasca("Ordenar apunts", 3));
        gestor.afegir(new Tasca("Repassar UML", 5));

        System.out.println("TOTES LES TASQUES:");
        gestor.mostrar();

        System.out.println("\nMarquem 'Fer exercicis' com completada");
        gestor.marcarCompletada("Fer exercicis");

        System.out.println("\nTasques pendents:");
        for (Tasca t : gestor.pendents()) {
            System.out.println(t);
        }

        System.out.println("\nOrdenem per prioritat descendent:");
        gestor.ordenarPerPrioritatDesc();
        gestor.mostrar();

        System.out.println("\nEliminem 'Repassar UML'");
        gestor.eliminarPerTitol("Repassar UML");

        gestor.mostrar();
    }
}
