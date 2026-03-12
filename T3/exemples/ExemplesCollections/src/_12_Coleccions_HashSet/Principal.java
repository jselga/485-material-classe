package _12_Coleccions_HashSet;

import java.util.HashSet;

public class Principal {

    public static void main(String[] args) {

        Llibre l1 = new Llibre("Programció en Java", "Maria", 1111);
//        Llibre l2 = l1;
        Llibre l2 = new Llibre("LLenguatges servidors web: PHP", "Carlos", 1111);
        Llibre l3 = new Llibre("Learn Ubuntu", "Adria", 2222);
        Llibre l4 = new Llibre("Android Studio", "Pau", 4444);

        //sobreescriure el mètode equals
        if (l1.equals(l2)) {
            System.out.println("Són iguals");
        } else {
            System.out.println("No Són iguals");
        }

        HashSet<Llibre> magatzemLlibres = new HashSet<>();

        magatzemLlibres.add(l1);
        magatzemLlibres.add(l2);
        magatzemLlibres.add(l3);
        magatzemLlibres.add(l4);

        //No afageix els llibres amb ISBN repetit
        for (Llibre l : magatzemLlibres) {
            System.out.println(l.toString());
        }

    }

}
