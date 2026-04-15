package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Chapter;

public class ChapterDao {

    public void insertar(Chapter chapter, String bookIsbn) {
        String sql = "INSERT INTO chapter (num, title, numpages, book_isbn) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, chapter.getNum());
            ps.setString(2, chapter.getTitle());
            ps.setInt(3, chapter.getNumPages());
            ps.setString(4, bookIsbn);

            ps.executeUpdate();
            System.out.println("Chapter inserit correctament");

        } catch (SQLException e) {
            System.out.println("Error en inserir chapter: " + e.getMessage());
        }
    }

    public ArrayList<Chapter> buscarPerBookIsbn(String bookIsbn) {
        String sql = "SELECT num, title, numpages, book_isbn FROM chapter WHERE book_isbn = ?";
        ArrayList<Chapter> llista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bookIsbn);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Chapter chapter = new Chapter();
                    chapter.setNum(rs.getInt("num"));
                    chapter.setTitle(rs.getString("title"));
                    chapter.setNumPages(rs.getInt("numpages"));
                    llista.add(chapter);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en buscar chapters: " + e.getMessage());
        }

        return llista;
    }

    public void eliminar(String bookIsbn) {
        String sql = "DELETE FROM chapter WHERE book_isbn = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, bookIsbn);

            int files = ps.executeUpdate();
            System.out.println("Chapters eliminats: " + files);

        } catch (SQLException e) {
            System.out.println("Error en eliminar chapters: " + e.getMessage());
        }
    }
}