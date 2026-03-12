/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici2HashSet;

/**
 *
 * @author jordi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Participant p1 = new Participant("Anna", "anna@mail.com");
        Participant p2 = new Participant("Marc", "marc@mail.com");
        Participant p3 = new Participant("Laura", "laura@mail.com");
        Participant p4 = new Participant("Joan", "anna@mail.com");   // email repetit
        Participant p5 = new Participant("Clara", "clara@mail.com");

        Inscripcions i1 = new Inscripcions();

        i1.inscriure(p1);
        i1.inscriure(p2);
        i1.inscriure(p3);
        i1.inscriure(p4);
        i1.inscriure(p5);
        System.out.println("Mostra de totes les persones participants");
        i1.mostrar();
        String emailBaixa = "clara@mail.com";
        if (i1.donarDeBaixaPerEmail(emailBaixa)) {
            System.out.printf("Usuari  amb email: %s s'ha donat de baixa correctament\n", emailBaixa);
        }

        System.out.println("Mostra de totes les persones participants després d'eliminar");
        i1.mostrar();
    }

}
