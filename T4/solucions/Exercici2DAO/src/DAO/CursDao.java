package DAO;

import model.Curs;

import java.sql.*;
import java.util.ArrayList;

public class CursDao {

    public void inserir(Curs curs) {
        String sql = "INSERT INTO cursos (codi, nom, nivell) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, curs.getCodi());
            ps.setString(2, curs.getNom());
            ps.setString(3, curs.getNivell());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut inserir el curs '" + curs.getNom() + "'.", e);
        }
    }

    public Curs buscarPerId(int id) {
        String sql = "SELECT id, codi, nom, nivell FROM cursos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToCurs(rs);
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut buscar el curs amb id " + id + ".", e);
        }
    }
    public Curs buscarPerCodi(String codi) {
        String sql = "SELECT id, codi, nom, nivell FROM cursos WHERE codi = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, codi);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToCurs(rs);
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut buscar el curs amb el codi " + codi + ".", e);
        }
    }
    public ArrayList<Curs> llistarTots() {
        ArrayList<Curs> cursos = new ArrayList<>();
        String sql = "SELECT id, codi, nom, nivell FROM cursos ORDER BY id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                cursos.add(mapRowToCurs(rs));
            }
            return cursos;
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut recuperar el llistat de cursos.", e);
        }
    }

    public boolean actualitzar(Curs curs) {
        String sql = "UPDATE cursos SET nom = ?, nivell = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, curs.getNom());
            ps.setString(2, curs.getNivell());
            ps.setInt(3, curs.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut actualitzar el curs amb id " + curs.getId() + ".", e);
        }
    }

    public int comptarAlumnes(int cursId) {
        String sql = "SELECT COUNT(*) FROM alumnes WHERE curs_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cursId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut comptar els alumnes del curs " + cursId + ".", e);
        }
    }

    public boolean teAlumnes(int cursId) {
        String sql = "SELECT COUNT(*) AS total FROM alumnes WHERE curs_id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, cursId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total") > 0;
                }
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut comprovar si el curs " + cursId + " té alumnes.", e);
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM cursos WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut eliminar el curs amb id " + id + ".", e);
        }
    }

    public void netejarTaula() {
        String sql = "DELETE FROM cursos";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No s'ha pogut netejar la taula cursos.", e);
        }
    }

    private Curs mapRowToCurs(ResultSet rs) throws SQLException {
        return new Curs(rs.getInt("id"), rs.getString("codi"), rs.getString("nom"), rs.getString("nivell"));
    }
}
