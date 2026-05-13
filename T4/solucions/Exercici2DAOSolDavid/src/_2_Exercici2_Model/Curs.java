
package _1_Execici1_Model;


public class Curs {
    private int id;
    private String codi;
    private String nom;
    private String nivell;

    public Curs() {
    }

    public Curs(String codi, String nom, String nivell) {
        this.codi = codi;
        this.nom = nom;
        this.nivell = nivell;
    }

    public Curs(int id, String codi, String nom, String nivell) {
        this.id = id;
        this.codi = codi;
        this.nom = nom;
        this.nivell = nivell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNivell() {
        return nivell;
    }

    public void setNivell(String nivell) {
        this.nivell = nivell;
    }

    @Override
    public String toString() {
        return "Curs{" +
                "id=" + id +
                ", codi='" + codi + '\'' +
                ", nom='" + nom + '\'' +
                ", nivell='" + nivell + '\'' +
                '}';
    }
}
