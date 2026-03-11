/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _14_Coleccions_TreeSet;

import java.util.Comparator;

/**
 *
 * @author jordi
 */
public class ComparatorTitol implements Comparator<Llibre> {

    @Override
    public int compare(Llibre llibre1, Llibre llibre2) {
        return llibre1.getTitol().compareTo(llibre2.getTitol());

    }

}
