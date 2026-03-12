/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici3TreeSet;

import java.util.Comparator;

/**
 *
 * @author jordi
 */
public class ComparatorJugador implements Comparator<Jugador> {

    @Override
    public int compare(Jugador jugador1, Jugador jugador2) {
        return jugador2.getPunts() - jugador1.getPunts();

    }

}
