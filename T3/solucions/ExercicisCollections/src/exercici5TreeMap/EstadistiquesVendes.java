/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici5TreeMap;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jordi
 */
public class EstadistiquesVendes {

    private TreeMap<LocalDate, Integer> vendes;

    public EstadistiquesVendes() {

        vendes = new TreeMap<>();
    }

    // Acumula quantitat per data (String -> LocalDate)
    public void registrarVenda(String data, int quantitat) {

        LocalDate dataVenda = LocalDate.parse(data); // format ISO: YYYY-MM-DD
        if (vendes.containsKey(dataVenda)) {
            vendes.put(dataVenda, quantitat + vendes.get(dataVenda));
        } else {
            vendes.put(dataVenda, quantitat);
        }
    }

    // Rang inclòs: [dataInici, dataFi]
    public int totalEntre(String dataInici, String dataFi) {

        LocalDate ini = LocalDate.parse(dataInici.trim());
        LocalDate fi = LocalDate.parse(dataFi.trim());

        int total = 0;

        /*
        1) subMap(ini, true, fi, true)
            - subMap retorna un submapa només les entrades que tenen clau dins del rang.
            - ini és la data d’inici
            - fi és la data final
            - el true indica que el límit és inclòs
        2) .values()
            - D’aquest submapa, values() et dona només els valors
         */
        for (int q : vendes.subMap(ini, true, fi, true).values()) {
            total += q;
        }
        return total;
    }

    public String primeraData() {
        return vendes.isEmpty() ? null : vendes.firstKey().toString();
    }

    public String ultimaData() {
        return vendes.isEmpty() ? null : vendes.lastKey().toString();
    }

    public void mostrar() {
        if (vendes.isEmpty()) {
            System.out.println("(sense dades)");
            return;
        }
        for (Map.Entry<LocalDate, Integer> entrada : vendes.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
    }
}
