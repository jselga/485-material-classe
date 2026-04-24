package Principal;

import DAO.CursDAO;
import Model.Curs;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Connexió amb la base de dades correcta.");

            CursDAO dao = new CursDAO(conn);
            // Netejem per no repetir codi a cada execucció
            dao.netejarTaula();
            //Inserim tres cursos
            dao.inserir(new Curs("DAW2", "Desenvolupament web entorn Client", "Grau Superior"));
            dao.inserir(new Curs("SMX1", "Sistemes microinformàtics", "Grau Mitjà"));
            dao.inserir(new Curs("DAM2", "Processos i Serveis", "Grau Superior"));
            // Llistem tots els cursos
            List<Curs> cursos = dao.llistarTots();
            for (Curs c : cursos) {
                System.out.println(c);
            }
            // Actualitzem un curs
            Curs curs = dao.buscarPerId(1);
            if (curs != null) {
                System.out.println("Curs trobat: " + curs);

                curs.setNom("Desenvolupament d'aplicacions web entorn Servidor");
                curs.setNivell("GS");
                dao.actualitzar(curs);
            }
            // Eliminem el curs 2
            dao.eliminar(2);
        } catch (SQLException e) {
            System.out.println("Error SQL");
            e.printStackTrace();
        }
    }
}
