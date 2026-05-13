package _2_Exercici2_Principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDUtil {

    public static void createEstructuraMysql(Connection conn) throws SQLException {

        PreparedStatement stmt;

        String queryCursos = "CREATE TABLE IF NOT EXISTS cursos ("
                + " id INT NOT NULL AUTO_INCREMENT, "
                + " codi VARCHAR(20) NOT NULL, "
                + " nom VARCHAR(100) NOT NULL, "
                + " nivell VARCHAR(50) NOT NULL, "
                + " CONSTRAINT cursos_pkey PRIMARY KEY (id), "
                + " CONSTRAINT cursos_codi_unique UNIQUE (codi)"
                + ")";

        stmt = conn.prepareStatement(queryCursos);
        stmt.executeUpdate();
        stmt.close();

        String queryAlumnes = "CREATE TABLE IF NOT EXISTS alumnes ("
                + " id INT NOT NULL AUTO_INCREMENT, "
                + " nom VARCHAR(50) NOT NULL, "
                + " cognoms VARCHAR(100) NOT NULL, "
                + " email VARCHAR(100) NOT NULL, "
                + " curs_id INT NOT NULL, "
                + " CONSTRAINT alumnes_pkey PRIMARY KEY (id), "
                + " CONSTRAINT alumnes_curs_fk FOREIGN KEY (curs_id) REFERENCES cursos(id)"
                + ")";

        stmt = conn.prepareStatement(queryAlumnes);
        stmt.executeUpdate();
        stmt.close();
    }

    public static void netejarTaulaAlumnes(Connection conn) {
        PreparedStatement ps;
        try {
            String query = "TRUNCATE TABLE alumnes";
            ps = conn.prepareStatement(query);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en eliminar:" + e.getMessage());
        }
    }
    
}