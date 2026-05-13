package _2_Exercici2_Model;

import _1_Execici1_Model.Curs;

public class Alumne {

    private int id;
    private String nom;
    private String cognoms;
    private String email;
    private Curs curs;

    public Alumne() {
    }

    public Alumne(String nom, String cognoms, String email, Curs curs) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
        this.curs = curs;
    }

    public Alumne(int id, String nom, String cognoms, String email, Curs curs) {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
        this.curs = curs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Curs getCurs() {
        return curs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "Alumne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", cognoms='" + cognoms + '\'' +
                ", email='" + email + '\'' +
                ", curs=" + (curs != null ? curs.getNom() : "sense curs") +
                '}';
    }
}