package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Publisher;

public class PublisherDao {

    public void insertar(Publisher publisher) {
        String sql = "INSERT INTO publisher (code, name, address) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, publisher.getCode());
            ps.setString(2, publisher.getName());
            ps.setString(3, publisher.getAddress());

            ps.executeUpdate();
            System.out.println("Publisher inserit correctament");

        } catch (SQLException e) {
            System.out.println("Error en inserir publisher: " + e.getMessage());
        }
    }

    public Publisher buscarPerCodi(int code) {
        String sql = "SELECT code, name, address FROM publisher WHERE code = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, code);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Publisher(
                            rs.getInt("code"),
                            rs.getString("name"),
                            rs.getString("address")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en buscar publisher: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<Publisher> llistarTots() {
        String sql = "SELECT code, name, address FROM publisher";
        ArrayList<Publisher> llista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                llista.add(new Publisher(
                        rs.getInt("code"),
                        rs.getString("name"),
                        rs.getString("address")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error en llistar publishers: " + e.getMessage());
        }

        return llista;
    }

    public void actualitzar(Publisher publisher) {
        String sql = "UPDATE publisher SET name = ?, address = ? WHERE code = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, publisher.getName());
            ps.setString(2, publisher.getAddress());
            ps.setInt(3, publisher.getCode());

            int files = ps.executeUpdate();
            System.out.println("Files actualitzades: " + files);

        } catch (SQLException e) {
            System.out.println("Error en actualitzar publisher: " + e.getMessage());
        }
    }

    public void eliminar(int code) {
        String sql = "DELETE FROM publisher WHERE code = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, code);

            int files = ps.executeUpdate();
            System.out.println("Files eliminades: " + files);

        } catch (SQLException e) {
            System.out.println("Error en eliminar publisher: " + e.getMessage());
        }
    }
}