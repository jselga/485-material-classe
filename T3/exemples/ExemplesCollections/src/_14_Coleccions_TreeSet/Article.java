package _14_Coleccions_TreeSet;

import java.util.Comparator;

/**
 *
 * @author David
 */
public class Article implements Comparable<Article>, Comparator<Article> {

    private int numero_article;
    private String descripcio;

    public Article(int numero_article, String descripcio) {
        this.numero_article = numero_article;
        this.descripcio = descripcio;
    }

    public int getNumero_article() {
        return numero_article;
    }

    public void setNumero_article(int numero_article) {
        this.numero_article = numero_article;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (this.numero_article != other.numero_article) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Article t) {
        return this.numero_article - t.numero_article; //Ordenats per codi
    }

    @Override
    public int compare(Article article1, Article article2) {
        return article1.getDescripcio().compareTo(article2.getDescripcio()); //Ordenats per descripció
    }

}
