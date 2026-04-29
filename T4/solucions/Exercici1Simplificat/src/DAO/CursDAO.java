package DAO;

import Model.Curs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursDAO {

    private final Connection conn;

    public CursDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Curs curs) throws SQLException {
        String query = "INSERT INTO cursos (codi, nom, nivell) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, curs.getCodi());
            stmt.setString(2, curs.getNom());
            stmt.setString(3, curs.getNivell());
            stmt.executeUpdate();
        }
    }

    public Curs buscarPerId(int id) throws SQLException {
        String query = "SELECT * FROM cursos WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Curs(
                            rs.getInt("id"),
                            rs.getString("codi"),
                            rs.getString("nom"),
                            rs.getString("nivell")
                    );
                }
            }
        }
        return null;
    }

    public List<Curs> llistarTots() throws SQLException {
        List<Curs> llista = new ArrayList<>();

        String query = "SELECT * FROM cursos ORDER BY id";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curs curs = new Curs(
                        rs.getInt("id"),
                        rs.getString("codi"),
                        rs.getString("nom"),
                        rs.getString("nivell")
                );
                llista.add(curs);
            }
        }

        return llista;
    }

    public boolean actualitzar(Curs curs) throws SQLException {
        String query = "UPDATE cursos SET nom = ?, nivell = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, curs.getNom());
            stmt.setString(2, curs.getNivell());
            stmt.setInt(3, curs.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean eliminar(int id) throws SQLException {
        String query = "DELETE FROM cursos WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
     public void netejarTaula() throws SQLException {
        //        String query = "DELETE FROM cursos";
        String query = "TRUNCATE TABLE cursos";
        //Fem servir TRUNCATE en comptes de DELETE per poder reinciar els autoincriment


        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
        }
    }
}
