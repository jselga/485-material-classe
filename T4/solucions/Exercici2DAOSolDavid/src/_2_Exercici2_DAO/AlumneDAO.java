
package _2_Exercici2_DAO;

import _2_Exercici2_Model.Alumne;
import _1_Execici1_Model.Curs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumneDAO {

    private Connection conn;

    public AlumneDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Alumne alumne) throws SQLException {
        String query = "INSERT INTO alumnes (nom, cognoms, email, curs_id) VALUES (?, ?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, alumne.getNom());
        stmt.setString(2, alumne.getCognoms());
        stmt.setString(3, alumne.getEmail());
        stmt.setInt(4, alumne.getCurs().getId());

        stmt.executeUpdate();
        stmt.close();
    }

    public List<Alumne> llistarTots() throws SQLException {
        List<Alumne> llista = new ArrayList<>();

        String query = "SELECT a.id AS alumne_id, a.nom AS alumne_nom, a.cognoms, a.email, "
                + "c.id AS curs_id, c.codi AS curs_codi, c.nom AS curs_nom, c.nivell AS curs_nivell "
                + "FROM alumnes a "
                + "INNER JOIN cursos c ON a.curs_id = c.id "
                + "ORDER BY a.id";

        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Curs curs = new Curs(
                    rs.getInt("curs_id"),
                    rs.getString("curs_codi"),
                    rs.getString("curs_nom"),
                    rs.getString("curs_nivell")
            );

            Alumne alumne = new Alumne(
                    rs.getInt("alumne_id"),
                    rs.getString("alumne_nom"),
                    rs.getString("cognoms"),
                    rs.getString("email"),
                    curs
            );

            llista.add(alumne);
        }

        rs.close();
        stmt.close();

        return llista;
    }

    public List<Alumne> llistarPerCurs(int cursId) throws SQLException {
        List<Alumne> llista = new ArrayList<>();

        String query = "SELECT a.id AS alumne_id, a.nom AS alumne_nom, a.cognoms, a.email, "
                + "c.id AS curs_id, c.codi AS curs_codi, c.nom AS curs_nom, c.nivell AS curs_nivell "
                + "FROM alumnes a "
                + "INNER JOIN cursos c ON a.curs_id = c.id "
                + "WHERE c.id = ? "
                + "ORDER BY a.id";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, cursId);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Curs curs = new Curs(
                    rs.getInt("curs_id"),
                    rs.getString("curs_codi"),
                    rs.getString("curs_nom"),
                    rs.getString("curs_nivell")
            );

            Alumne alumne = new Alumne(
                    rs.getInt("alumne_id"),
                    rs.getString("alumne_nom"),
                    rs.getString("cognoms"),
                    rs.getString("email"),
                    curs
            );

            llista.add(alumne);
        }

        rs.close();
        stmt.close();

        return llista;
    }

    public boolean actualitzarEmail(int alumneId, String nouEmail) throws SQLException {
        String query = "UPDATE alumnes SET email = ? WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, nouEmail);
        stmt.setInt(2, alumneId);

        int filesAfectades = stmt.executeUpdate();
        stmt.close();

        return filesAfectades > 0;
    }
}
