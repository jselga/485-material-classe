package _14_Coleccions_TreeSet;

/**
 * @author david
 */
public class Llibre implements Comparable<Llibre> {

    private String titol;
    private String autor;
    private int ISBN;

    public Llibre(String titol, String autor, int ISBN) {
        this.titol = titol;
        this.autor = autor;
        this.ISBN = ISBN;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return titol + ", " + autor + ", " + ISBN;
    }

    @Override
    public int compareTo(Llibre altreLlibre) {
        return this.getISBN() - altreLlibre.getISBN();
    }

}
