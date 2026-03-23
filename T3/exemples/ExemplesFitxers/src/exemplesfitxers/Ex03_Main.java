/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exemplesfitxers;

/**
 *
 * @author jordi
 */
public class Ex03_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Magatzem magatzem = new Magatzem();

        // Afegim dades
        magatzem.afegir(new Material("Fusta", 10));
        magatzem.afegir(new Material("Ferro", 5));

        // Guardar
        magatzem.guardar();

        // Crear nou objecte (simula nova execució)
        Magatzem nouMagatzem = new Magatzem();

        // Carregar dades
        nouMagatzem.carregar();

        // Mostrar
        System.out.println("📦 Contingut:");
        nouMagatzem.mostrar();
    }

}
