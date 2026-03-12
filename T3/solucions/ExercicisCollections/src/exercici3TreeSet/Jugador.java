/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici3TreeSet;

/**
 *
 * @author jordi
 */
public class Jugador implements Comparable<Jugador> {

    private String nick;
    private int punts;

    public Jugador(String nick, int punts) {
        this.nick = nick;
        this.punts = punts;
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return String.format("Nick: %-15s | Pts: %d", nick, punts);
    }

    @Override
    public int compareTo(Jugador jugador) {
        return this.nick.compareTo(jugador.nick);
    }

}
