/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici1ArrayList;

/**
 *
 * @author jordi
 */
public class Tasca {

    private String titol;
    private int prioritat;
    private boolean completada;

    public Tasca(String titol, int prioritat) {
        this.titol = titol;
        this.prioritat = prioritat;
        this.completada =false;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getPrioritat() {
        return prioritat;
    }

    public void setPrioritat(int prioritat) {
        this.prioritat = prioritat;
    }

    @Override
    public String toString() {
        return "Tasca{" + "titol=" + titol + ", prioritat=" + prioritat + ", completada=" + completada + '}';
    }

    

}
