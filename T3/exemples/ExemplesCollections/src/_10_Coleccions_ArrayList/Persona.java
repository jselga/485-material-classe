package _10_Coleccions_ArrayList;

/*
 @author David
 */
public class Persona implements Comparable {

    private String DNI;
    private String nom;
    private int edat;

    public Persona(String DNI, String nom, int edat) {
        this.DNI = DNI;
        this.nom = nom;
        this.edat = edat;
    }

    public String getDNI() {
        return DNI;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    @Override
    public String toString() {
        return "DNI=" + DNI + ", nom=" + nom + ", edat=" + edat;
    }

//    @Override
//    public int compareTo(Object other) {
//        Persona otherPersona = (Persona) other;
//        return edat - otherPersona.edat;
//    }
    @Override
    public int compareTo(Object o) {
        Persona p = (Persona) o;
//        //ordenat per edat

//      return edat - p.edat;
//        //ordenat de nom
        return DNI.compareTo(p.DNI);
    }

}
