/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici4HashMap;

/**
 *
 * @author jordi
 */
public class Producte {

    private String codi;
    private String nom;
    private double preu;

    public Producte(String codi, String nom, double preu) {
        this.codi = codi;
        this.nom = nom;
        this.preu = preu;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Producte{"
                + "codi='" + codi + '\''
                + ", nom='" + nom + '\''
                + ", preu=" + preu
                + '}';
    }

}
