/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicisexcepcions;

/**
 *
 * @author jordi
 */
public class Exercici2Propagacio {

    public static void main(String[] args) {
        System.out.println("Inici del programa");

        metode1();

        System.out.println("El programa continua després de capturar l'excepció.");
    }

    public static void metode1() {
        try {
            System.out.println("Entrant a metode1...");
            metode2();
            System.out.println("Aquesta línia no s'executarà si hi ha error a metode2.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error capturat a metode1.");
            System.out.println("Missatge: " + e.getMessage());
            System.out.println("Excepció: " + e.getClass().getSimpleName());
        }
    }

    public static void metode2() {
        System.out.println("Entrant a metode2...");
        int[] dades = {1, 2, 3};
        System.out.println(dades[5]); // provoca l'excepció
    }
}
