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
//        magatzem.afegir(new Material("Fusta", 10));
//        magatzem.afegir(new Material("Ferro", 5));
        magatzem.afegir(new Material("Fusta", 10, 12.99));
        magatzem.afegir(new Material("Ferro", 5, 15.99));
        //Mostra abans de guardar
        System.out.println("Abans de guardar");
        System.out.println("📦 Contingut:");
        magatzem.mostrar();

        // Guardar
        magatzem.guardar();

        // Crear nou objecte (simula nova execució)
        Magatzem nouMagatzem = new Magatzem();

        // Carregar dades
        nouMagatzem.carregar();

        // Mostrar
        System.out.println("Després de Recuperar");
        System.out.println("📦 Contingut:");
        nouMagatzem.mostrar();
    }

}
