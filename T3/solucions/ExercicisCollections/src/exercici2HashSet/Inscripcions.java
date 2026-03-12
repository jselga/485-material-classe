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
//    (retorna false si ja existeix)
        return false;
    }

    public boolean donarDeBaixaPerEmail(String email) {
        return false;
    }

    public boolean estaInscrit(String email) {
        return false;
    }

    public int total() {
        return 0;
    }

    public void mostrar() {

    }

}
