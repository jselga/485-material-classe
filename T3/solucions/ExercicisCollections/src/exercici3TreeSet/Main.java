/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici3TreeSet;

/**
 *
 * @author jordi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Ranking jugadors = new Ranking();
        jugadors.afegir(new Jugador("Link", 120));
        jugadors.afegir(new Jugador("Zelda", 200));
        jugadors.afegir(new Jugador("Ganondorf", 50));
        jugadors.afegir(new Jugador("Mipha", 180));
        jugadors.afegir(new Jugador("Daruk", 80));
        jugadors.afegir(new Jugador("Revali", 90)); // punts repetits
        jugadors.afegir(new Jugador("Urbosa", 300));
        jugadors.afegir(new Jugador("Link", 400));   // nick repetit

        System.out.println("Primer: " + jugadors.primer());
        System.out.println("Últim: " + jugadors.ultim());

        jugadors.mostrarTopN(3);

        jugadors.mostrarEntrePunts(50, 100);
    }

}
