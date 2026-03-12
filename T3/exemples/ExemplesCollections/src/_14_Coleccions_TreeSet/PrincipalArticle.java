package _14_Coleccions_TreeSet;

import java.util.TreeSet;

/**
 * @author David
 */
public class PrincipalArticle {

    public static void main(String[] args) {

        TreeSet<String> ordenarPersones = new TreeSet<>();

        ordenarPersones.add("Xavi");
        ordenarPersones.add("Rosa");
        ordenarPersones.add("Jordi");
        // TreeSet per defecte, ordena els objectes tipus String alfabèticament
        System.out.println(ordenarPersones);

        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(6);
        numbers.add(3);
        numbers.add(1);
        numbers.add(5);
        numbers.add(4);
        numbers.add(1);
        numbers.add(8);
        // TreeSet per defecte, ordena els objctes tipus Integer ascendent-ment

        System.out.println(numbers);

        //El TreeSet per no tenir duplicat té en compte el mètode compareTo de la interfice Comparable
        //Si el vol un mètode d'ordenació d'un atribut diferent al de compareTo, s'ha d'implementar el mètode compare de la interfície Comparator
        // En el cas dels objectes s'ha de implementar l'Interface Comparable
        TreeSet<Article> articles = new TreeSet<Article>();

        Article a1 = new Article(5, "E");
        Article a2 = new Article(3, "C");
        Article a3 = new Article(1, "D");
        Article a4 = new Article(4, "A");
        Article a5 = new Article(2, "B");
        Article a6 = new Article(2, "Z");

        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
        articles.add(a4);
        articles.add(a5);
        articles.add(a6); //No l'afageix per que ja hi ha un article amb el mateix numero de codi

        System.out.println("\nOrdenats per número d'article");
        for (Article a : articles) {
            System.out.println(a.getNumero_article() + ", " + a.getDescripcio());
        }

//         Per tenir un segon criteri d'ordenació es pot implementar l'interficie Comparator
        TreeSet<Article> articles2 = new TreeSet<Article>(a1);
        articles2.add(a1);
        articles2.add(a2);
        articles2.add(a3);
        articles2.add(a4);
        articles2.add(a5);

        System.out.println("\nOrdenats per descripció");
        for (Article a : articles2) {
            System.out.println(a.getNumero_article() + ", " + a.getDescripcio());
        }
    }

}
