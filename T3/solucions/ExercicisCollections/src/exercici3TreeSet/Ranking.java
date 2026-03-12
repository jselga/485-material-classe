/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici3TreeSet;

import java.util.TreeSet;

/**
 *
 * @author jordi
 */
public class Ranking {

    TreeSet<Jugador> jugadors = new TreeSet<>();

    public void afegir(Jugador j) {
        if (jugadors.add(j)) {
            System.out.println("Jugador afegit correctament");
        } else {
            System.out.println("Jugador repetit");
        }
    }

    public void mostrarTopN(int n) {
        int cnt = 0;
        for (Jugador jugador : jugadors) {
            if (cnt < n) {
                System.out.println(jugador);
                cnt++;
            }

        }

    }

    public Jugador primer() {
        //Sense check de empty
        return jugadors.first();
    }

    Jugador ultim() {
        return jugadors.last();
    }

    //(pots fer-ho amb recorregut o amb un “set auxiliar”)auxiliar
    public void mostrarEntrePunts(int min, int max) {
        for (Jugador j : jugadors) {
            if (j.getPunts() >= min && j.getPunts() <= max) {
                System.out.println(j);
            }
        }
    }

    void mostrar() {
        for (Jugador jugador : jugadors) {
            System.out.println(jugador);
        }
    }

}
