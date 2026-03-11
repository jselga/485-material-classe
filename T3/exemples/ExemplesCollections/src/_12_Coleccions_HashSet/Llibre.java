package _12_Coleccions_HashSet;

/**
 * @author david
 */
public class Llibre {

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
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.ISBN;
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
        final Llibre other = (Llibre) obj;
        return this.ISBN == other.ISBN;
    }

}
