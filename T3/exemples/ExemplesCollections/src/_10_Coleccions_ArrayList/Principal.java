package _10_Coleccions_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author David
 */
public class Principal {

    public static void main(String[] args) {

        ArrayList<Persona> llistaPersones = new ArrayList<>();

        Persona p1 = new Persona("11111111", "Iker", 20);
        Persona p2 = new Persona("33333333", "Mireia", 19);
        Persona p3 = new Persona("5555555", "Edgar", 17);
        Persona p4 = new Persona("22222222", "Camila", 21);
        Persona p5 = new Persona("4444444", "Eric", 18);

        llistaPersones.add(p1);
        llistaPersones.add(p2);
        llistaPersones.add(p3);
        llistaPersones.add(p4);
        llistaPersones.add(p5);

        System.out.println("Mateix ordre que s'ha anar inserint");
        System.out.println("----------------------------------");
        for (Persona p : llistaPersones) {
            System.out.println(p);
        }

        // Un ArrayList NO s’ordena sol. Si vols que quedi ordenat per un criteri, s'ha implementar la interface Comparable
        // i cridar la funció "sort"
        Collections.sort(llistaPersones);

        System.out.println("\nOrdenat per DNI");
        System.out.println("---------------");
        for (Persona p : llistaPersones) {
            System.out.println(p);

        }
    }
}
