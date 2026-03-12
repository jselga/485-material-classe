/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercici2HashSet;

/**
 *
 * @author jordi
 */
public class Participant {

    private String nom;
    private String email;

    public Participant(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
//hashCode i equals per defecte amb insert code:

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 13 * hash + Objects.hashCode(this.email);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Participant other = (Participant) obj;
//        return Objects.equals(this.email, other.email);
//    }
//hashCode i equals personalitzat per tenir ser coherent amb ingoreCase:
    @Override
    public int hashCode() {
        return email.toLowerCase().hashCode();
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
        final Participant other = (Participant) obj;
        return email.equalsIgnoreCase(other.email);
    }

    @Override
    public String toString() {
        return String.format("Nom: %-15s | Email: %s", nom, email);
    }

}
