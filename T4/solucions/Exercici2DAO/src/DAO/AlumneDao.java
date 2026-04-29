package DAO;

import model.Alumne;
import model.Curs;

import java.sql.*;
import java.util.ArrayList;

public class AlumneDao {

    public boolean inserir(Alumne alumne) {
        String sql = "INSERT INTO alumnes (nom, cognoms, email, curs_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, alumne.getNom());
            ps.setString(2, alumne.getCognoms());
            ps.setString(3, alumne.getEmail());
            ps.setInt(4, alumne.getCurs().getId());
            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut inserir l'alumne '" + alumne.getNom() + "'.", e);
        }
    }

    public ArrayList<Alumne> llistarTotsAmbCurs() {
        ArrayList<Alumne> alumnes = new ArrayList<>();
        String sql = "SELECT a.id, a.nom, a.cognoms, a.email, a.curs_id, " +
                     "c.id AS c_id, c.codi, c.nom AS c_nom, c.nivell " +
                     "FROM alumnes a " +
                     "LEFT JOIN cursos c ON a.curs_id = c.id " +
                     "ORDER BY a.id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                alumnes.add(mapRowToAlumneAmbCurs(rs));
            }
            return alumnes;
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut recuperar el llistat d'alumnes.", e);
        }
    }

    public ArrayList<Alumne> llistarPerCursId(int cursId) {
        ArrayList<Alumne> alumnes = new ArrayList<>();
        String sql = "SELECT a.id, a.nom, a.cognoms, a.email, a.curs_id, " +
                     "c.id AS c_id, c.codi, c.nom AS c_nom, c.nivell " +
                     "FROM alumnes a " +
                     "LEFT JOIN cursos c ON a.curs_id = c.id " +
                     "WHERE a.curs_id = ? " +
                     "ORDER BY a.id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cursId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    alumnes.add(mapRowToAlumneAmbCurs(rs));
                }
            }
            return alumnes;
        } catch (SQLException e) {
            throw new RuntimeException("No s'han pogut recuperar els alumnes del curs " + cursId + ".", e);
        }
    }

    public boolean actualitzarEmail(int alumneId, String nouEmail) {
        String sql = "UPDATE alumnes SET email = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nouEmail);
            ps.setInt(2, alumneId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut actualitzar l'email de l'alumne " + alumneId + ".", e);
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM alumnes WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut eliminar l'alumne amb id " + id + ".", e);
        }
    }

    public void netejarTaula() {
        String sql = "TRUNCATE TABLE  alumnes";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut netejar la taula alumnes.", e);
        }
    }

    private Alumne mapRowToAlumneAmbCurs(ResultSet rs) throws SQLException {
        Curs curs = new Curs(
                rs.getInt("c_id"),
                rs.getString("codi"),
                rs.getString("c_nom"),
                rs.getString("nivell")
        );
        return new Alumne(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("cognoms"),
                rs.getString("email"),
                curs
        );
    }
}
