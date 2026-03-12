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
        Participant p2 = new Participant("Marc", "MARC@mail.com");
        Participant p3 = new Participant("Laura", "laura@mail.com");
        Participant p4 = new Participant("Joan", "anna@mail.com");   // email repetit
        Participant p5 = new Participant("Clara", "clara@mail.com");

        Inscripcions i1 = new Inscripcions();

        System.out.println("Afegint Anna: " + i1.inscriure(p1));
        System.out.println("Afegint Marc: " + i1.inscriure(p2));
        System.out.println("Afegint Laura: " + i1.inscriure(p3));
        System.out.println("Afegint Joan amb email repetit: " + i1.inscriure(p4));
        System.out.println("Afegint Clara: " + i1.inscriure(p5));
        System.out.println("Mostra de totes les persones participants");
        System.out.printf("Nombre de participants: %d\n", i1.total());
        i1.mostrar();
        System.out.println("");
//        String emailBaixa = "clara@mail.com";
        String emailBaixa = "CLARA@mail.com";
//        String emailBaixa = "marti@mail.com";
        if (i1.donarDeBaixaPerEmail(emailBaixa)) {
            System.out.printf("Usuari  amb email: %s s'ha donat de baixa correctament\n", emailBaixa.toLowerCase());
        } else {
            System.out.printf("No s'ha trobat cap participant amb aquest email: %s\n", emailBaixa.toLowerCase());
        }
        System.out.println("");
        System.out.println("Mostra de totes les persones participants després d'eliminar");
        i1.mostrar();
    }

}
