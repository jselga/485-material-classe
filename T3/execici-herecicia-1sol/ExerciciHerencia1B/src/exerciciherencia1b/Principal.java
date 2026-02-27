package exerciciherencia1b;

import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {

        Empresa e = new Empresa("Vallbona", "B12345678", "C/ Major 10, Barcelona");

        // Treballadors
        e.afegirTreballador(new Treballador(
                1, "Eva", "Serra", "11111111A", "600111222",
                "IT", 32000.0, LocalDate.of(2024, 3, 10), "SS12345"
        ));

        e.afegirTreballador(new Treballador(
                2, "Marc", "Puig", "22222222B", "600333444",
                "Vendes", 28000.0, LocalDate.of(2023, 9, 1), "SS67890"
        ));

        // Clients
        e.afegirClient(new Client(
                10, "Laia", "Roca", "33333333C", "600555666",
                "laia@example.com", "Premium", LocalDate.of(2022, 5, 20), 1250.50
        ));
        e.afegirClient(new Client(
                11, "Jordi", "Vila", "44444444D", "600777888",
                "jordi@example.com", "Bàsic", LocalDate.of(2024, 1, 15), 199.99
        ));

        // Mostrar tot
        e.mostrar();

        // Cercar
        Treballador t = e.cercarTreballadorPerDni("22222222B");
        System.out.println("Cercar treballador DNI 22222222B: " + (t != null ? t : "No trobat"));

        Client c = e.cercarClientPerDni("33333333C");
        System.out.println("Cercar client DNI 33333333C: " + (c != null ? c : "No trobat"));

        // Eliminar
        boolean eliminatT = e.eliminarTreballadorPerDni("11111111A");
        System.out.println("Eliminar treballador DNI 11111111A: " + (eliminatT ? "OK" : "No trobat"));

        boolean eliminatC = e.eliminarClientPerDni("44444444D");
        System.out.println("Eliminar client DNI 44444444D: " + (eliminatC ? "OK" : "No trobat"));

        // Tornar a mostrar
        System.out.println();
        e.mostrar();
    }
}
