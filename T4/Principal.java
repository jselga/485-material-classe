package Principal;

import Model.Videojoc;
import DAO.VideojocDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Principal {

    private static final String URL = "jdbc:mysql://localhost:3306/bd_examen_t4";
    private static final String USER = "jordi";
    private static final String PASSWORD = "jordi";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("La Connexió a la Base de dades funciona correctament...");
            System.out.println();

            // Crear la taula videojocs si no existeix
            BDUtil.crearTaula(conn);

            // Netejar la taula abans de començar
            BDUtil.netejarTaula(conn);

            VideojocDAO dao = new VideojocDAO(conn);

            carregarDadesProva(dao);

            System.out.println();
            System.out.println("Llistat per ID");
            mostrarLlista(dao.llistarPerId());
//
            System.out.println();
            mostrarResultatEliminacio(dao.eliminar(110), 110);
            mostrarResultatEliminacio(dao.eliminar(104), 104);

            System.out.println();
            System.out.println("Llistat per ID");
            mostrarLlista(dao.llistarPerId());

            System.out.println();
            Videojoc videojocActualitzat = new Videojoc(
                    101,
                    "Hades Edicio Definitiva",
                    "PC",
                    "Roguelike",
                    2021,
                    29.99
            );

            if (dao.actualitzar(videojocActualitzat)) {
                System.out.println("El videojoc amb id 101 s'ha actualitzat correctament");
            } else {
                System.out.println("El videojoc amb id 101 NO s'ha actualitzat correctament");
            }

            Videojoc cercat = dao.buscarPerId(101);
            if (cercat != null) {
                System.out.println(cercat);
            } else {
                System.out.println("No s'ha trobat cap videojoc amb id 101");
            }

            Videojoc cercat2 = dao.buscarPerId(250);
            if (cercat2 != null) {
                System.out.println(cercat2);
            } else {
                System.out.println("No s'ha trobat cap videojoc amb id 250");
            }

            System.out.println();
            System.out.println("Videojocs de la plataforma PC");
            mostrarLlista(dao.filtrarPerPlataforma("PC"));

//            System.out.println();
//            double mitjana = dao.mitjanaPreuPerPlataforma("PC");
//            System.out.printf("Mitjana de preu de la plataforma 'PC': %.2f%n", mitjana);
//
        } catch (SQLException e) {
            System.out.println("Error de base de dades: " + e.getMessage());
        }
    }
//
    private static void carregarDadesProva(VideojocDAO dao) {
        inserirIMostrar(dao, new Videojoc(101, "Hades", "PC", "Roguelike", 2020, 24.99));
        inserirIMostrar(dao, new Videojoc(102, "Zelda Tears of the Kingdom", "Switch", "Aventura", 2023, 59.99));
        inserirIMostrar(dao, new Videojoc(103, "Hollow Knight", "PC", "Metroidvania", 2017, 14.99));
        inserirIMostrar(dao, new Videojoc(104, "God of War Ragnarok", "PS5", "Aventura", 2022, 69.99));

        // Aquest videojoc té l'id duplicat i no s'hauria d'inserir
        inserirIMostrar(dao, new Videojoc(101, "Celeste", "PC", "Plataformes", 2018, 19.99));

        inserirIMostrar(dao, new Videojoc(105, "Stardew Valley", "PC", "Simulacio", 2016, 13.99));
    }

    private static void inserirIMostrar(VideojocDAO dao, Videojoc v) {
        if (dao.inserir(v)) {
            System.out.println("Videojoc inserit correctament");
        } else {
            System.out.println("Videojoc NO inserit");
        }
    }

    private static void mostrarResultatEliminacio(boolean eliminat, int id) {
        if (eliminat) {
            System.out.println("El videojoc amb id: " + id + " s'ha esborrat correctament");
        } else {
            System.out.println("El videojoc amb id: " + id + " NO s'ha esborrat correctament");
        }
    }

    private static void mostrarLlista(List<Videojoc> videojocs) {
        for (Videojoc v : videojocs) {
            System.out.println(v);
        }
    }
}
