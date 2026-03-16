/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _16_Coleccions_TreeMap;

/**
 *
 * @author jordi
 */
public class Paraula {

    private String nom;
    private String significat;
    private String idioma;

    public Paraula(String nom, String significat, String idioma) {
        this.nom = nom;
        this.significat = significat;
        this.idioma = idioma;
    }

    public String getNom() {
        return nom;
    }

    public String getSignificat() {
        return significat;
    }

    public String getIdioma() {
        return idioma;
    }

    @Override
    public String toString() {
        return nom + " (" + idioma + ") -> " + significat;
    }
}
