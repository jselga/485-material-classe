/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici5TreeMap;

/**
 *
 * @author jordi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EstadistiquesVendes ev = new EstadistiquesVendes();

        ev.registrarVenda("2026-03-01", 10);
        ev.registrarVenda("2026-03-02", 5);
        ev.registrarVenda("2026-03-03", 7);
        ev.registrarVenda("2026-03-05", 12);
        ev.registrarVenda("2026-03-02", 4);   // repetida (acumula)
        ev.registrarVenda("2026-03-07", 3);
        ev.registrarVenda("2026-03-10", 9);
        ev.registrarVenda("2026-03-05", 1);   // repetida (acumula)

        System.out.println("Primera data: " + ev.primeraData());
        System.out.println("Última data: " + ev.ultimaData());

        System.out.println("\nTotal entre 2026-03-02 i 2026-03-07 (inclòs): "
                + ev.totalEntre("2026-03-02", "2026-03-07"));

        System.out.println("\n== Vendes ordenades ==");
        ev.mostrar();
    }

}
