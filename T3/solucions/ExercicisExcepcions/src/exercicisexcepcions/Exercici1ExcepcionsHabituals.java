/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicisexcepcions;

/**
 *
 * @author jordi
 */
public class Exercici1ExcepcionsHabituals {

    public static void main(String[] args) {
        exempleArrayIndex();
        exempleNumberFormat();
        exempleNullPointer();
        exempleArithmetic();
    }

    public static void exempleArrayIndex() {
        try {
            int[] numeros = {10, 20, 30};
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: s'ha intentat accedir a una posició inexistent de l'array.");
            System.out.println("Excepció: " + e.getClass().getSimpleName());
        }
        System.out.println();
    }

    public static void exempleNumberFormat() {
        try {
            int numero = Integer.parseInt("hola");
            System.out.println(numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: no es pot convertir el text a número.");
            System.out.println("Excepció: " + e.getClass().getSimpleName());
        }
        System.out.println();
    }

    public static void exempleNullPointer() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Error: s'ha intentat utilitzar una referència null.");
            System.out.println("Excepció: " + e.getClass().getSimpleName());
        }
        System.out.println();
    }

    public static void exempleArithmetic() {
        try {
            int resultat = 10 / 0;
            System.out.println(resultat);
        } catch (ArithmeticException e) {
            System.out.println("Error: divisió per zero.");
            System.out.println("Excepció: " + e.getClass().getSimpleName());
        }
        System.out.println();
    }
}
