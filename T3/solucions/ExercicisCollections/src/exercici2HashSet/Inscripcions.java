/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici2HashSet;

import java.util.HashSet;

/**
 *
 * @author jordi
 */
public class Inscripcions {

    HashSet<Participant> participants;

    // El contructor instancia la Col·lecció quan es crea una instància Inscripcions
    public Inscripcions() {
        this.participants = new HashSet<>();
    }

    public boolean inscriure(Participant p) {
        return participants.add(p);

    }

    public Participant cercarPerEmail(String email) {
        for (Participant participant : participants) {
            if (participant.getEmail().equalsIgnoreCase(email)) {
                return participant;
            }
        }
        return null;
    }

    public boolean donarDeBaixaPerEmail(String email) {
        return participants.remove(cercarPerEmail(email));
    }

    public boolean estaInscrit(String email) {
        if (cercarPerEmail(email) == null) {
            return false;
        }
        return true;
    }

    public int total() {
        return participants.size();
    }

    public void mostrar() {
        for (Participant participant : participants) {
            System.out.println(participant);
        }

    }

}
