package exerciciherencia2;

import java.util.ArrayList;

public class Botiga {

    private String nom;
    private ArrayList<Article> articles;

    public Botiga(String nom) {

        this.nom = nom;
        this.articles = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public Article cercarPerCodi(String codi) {
        if (codi == null) {
            return null;
        }
        String c = codi.trim();
        for (Article a : articles) {
            if (a.getCodi().equalsIgnoreCase(c)) {
                return a;
            }
        }
        return null;
    }

    public boolean afegirArticle(Article a) {

        if (cercarPerCodi(a.getCodi()) != null) {
            return false;
        }

        articles.add(a);

        return true;
    }

    public boolean eliminarPerCodi(String codi) {

        Article a = cercarPerCodi(codi);

        if (a == null) {
            return false;
        } else {
            return articles.remove(a);

        }
    }

    public boolean modificarArticle(String codi, String nouNom, Double nouPreuBase) {

        Article a = cercarPerCodi(codi);
        if (a == null) {
            return false;
        } else {
            a.setNom(nouNom);
            a.setPreuBase(nouPreuBase);
            return true;
        }

    }

    public void mostrarArticlesPerTipus(String tipus) {

        System.out.println("Els articles del " + tipus + " són: ");

        for (Article a : articles) {
            if (esDelTipus(a, tipus)) {
                System.out.println(a.toString());
            }
        }
    }

    private boolean esDelTipus(Article a, String t) {

        if (t.equals("roba")) {
            return (a instanceof ArticleRoba);
        }

        if (t.equals("alimentació")) {
            return (a instanceof ArticleAlimentacio);
        }

        if (t.equals("electronic")) {
            return (a instanceof ArticleElectronic);
        }
        return a.getClass().getSimpleName().toLowerCase().contains(t);
    }

    public void mostrarInventari() {

        System.out.println("\n==============================");
        System.out.println("Inventari de la botiga: " + nom);
        System.out.println("==============================");

        for (Article a : articles) {
            System.out.println(a.toString());
        }
    }

}
