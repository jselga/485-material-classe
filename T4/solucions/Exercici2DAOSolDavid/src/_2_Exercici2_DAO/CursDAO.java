package _2_Exercici2_DAO;

import _1_Execici1_Model.Curs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursDAO {

    private Connection conn;

    public CursDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Curs curs) throws SQLException {
        String query = "INSERT INTO cursos (codi, nom, nivell) VALUES (?, ?, ?)";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, curs.getCodi());
        stmt.setString(2, curs.getNom());
        stmt.setString(3, curs.getNivell());

        stmt.executeUpdate();
        stmt.close();
    }

    public Curs buscarPerId(int id) throws SQLException {
        String query = "SELECT * FROM cursos WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        Curs curs = null;

        if (rs.next()) {
            curs = new Curs(
                    rs.getInt("id"),
                    rs.getString("codi"),
                    rs.getString("nom"),
                    rs.getString("nivell")
            );
        }

        rs.close();
        stmt.close();

        return curs;
    }

    public Curs buscarPerCodi(String codi) throws SQLException {
        String query = "SELECT * FROM cursos WHERE codi = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, codi);

        ResultSet rs = stmt.executeQuery();

        Curs curs = null;

        if (rs.next()) {
            curs = new Curs(
                    rs.getInt("id"),
                    rs.getString("codi"),
                    rs.getString("nom"),
                    rs.getString("nivell")
            );
        }

        rs.close();
        stmt.close();

        return curs;
    }

    public List<Curs> llistarTots() throws SQLException {
        List<Curs> llista = new ArrayList<>();

        String query = "SELECT * FROM cursos ORDER BY id";
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Curs curs = new Curs(
                    rs.getInt("id"),
                    rs.getString("codi"),
                    rs.getString("nom"),
                    rs.getString("nivell")
            );
            llista.add(curs);
        }

        rs.close();
        stmt.close();

        return llista;
    }

    public boolean teAlumnes(int cursId) throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM alumnes WHERE curs_id = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, cursId);

        ResultSet rs = stmt.executeQuery();

        boolean teAlumnes = false;

        if (rs.next()) {
            teAlumnes = rs.getInt("total") > 0;
        }

        rs.close();
        stmt.close();

        return teAlumnes;
    }

    public boolean eliminar(int id) throws SQLException {
        String query = "DELETE FROM cursos WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);

        int filesAfectades = stmt.executeUpdate();
        stmt.close();

        return filesAfectades > 0;
    }
}