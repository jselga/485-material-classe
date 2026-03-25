/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplesfitxers;

/**
 *
 * @author jordi
 */
import java.io.Serializable;

public class Material implements Serializable {

    private String nom;
    private int quantitat;
    private transient double preu;

    public Material(String nom, int quantitat) {
        this.nom = nom;
        this.quantitat = quantitat;
    }

    public Material(String nom, int quantitat, double preu) {
        this.nom = nom;
        this.quantitat = quantitat;
        this.preu = preu;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return nom + " (" + quantitat + ")" + "\nPreu:" + preu;
    }
}
