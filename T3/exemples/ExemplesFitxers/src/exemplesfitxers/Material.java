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

    public Material(String nom, int quantitat) {
        this.nom = nom;
        this.quantitat = quantitat;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantitat() {
        return quantitat;
    }

    @Override
    public String toString() {
        return nom + " (" + quantitat + ")";
    }
}
