package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;
import model.Publisher;

public class BookDao {

    public void insertar(Book book) {
        String sql = "INSERT INTO book (isbn, book_name, publisher_code, publish_date, price) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getName());
            if (book.getPublisher() != null) {
                ps.setInt(3, book.getPublisher().getCode());
            } else {
                ps.setNull(3, java.sql.Types.INTEGER);
            }
            ps.setDate(4, book.getPublishDate());
            ps.setDouble(5, book.getPrice());

            ps.executeUpdate();
            System.out.println("Book inserit correctament");

        } catch (SQLException e) {
            System.out.println("Error en inserir book: " + e.getMessage());
        }
    }

    public Book buscarPerIsbn(String isbn) {
        String sql = "SELECT b.isbn, b.book_name, b.publisher_code, b.publish_date, b.price, "
                + "p.code, p.name, p.address "
                + "FROM book b LEFT JOIN publisher p ON b.publisher_code = p.code "
                + "WHERE b.isbn = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, isbn);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Book book = new Book();
                    book.setIsbn(rs.getString("isbn"));
                    book.setName(rs.getString("book_name"));
                    book.setPublishDate(rs.getDate("publish_date"));
                    book.setPrice(rs.getDouble("price"));

                    int publisherCode = rs.getInt("publisher_code");
                    if (!rs.wasNull()) {
                        Publisher publisher = new Publisher();
                        publisher.setCode(rs.getInt("code"));
                        publisher.setName(rs.getString("name"));
                        publisher.setAddress(rs.getString("address"));
                        book.setPublisher(publisher);
                    }

                    return book;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en buscar book: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<Book> llistarTots() {
        String sql = "SELECT b.isbn, b.book_name, b.publisher_code, b.publish_date, b.price, "
                + "p.code, p.name, p.address "
                + "FROM book b LEFT JOIN publisher p ON b.publisher_code = p.code";
        ArrayList<Book> llista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Book book = new Book();
                book.setIsbn(rs.getString("isbn"));
                book.setName(rs.getString("book_name"));
                book.setPublishDate(rs.getDate("publish_date"));
                book.setPrice(rs.getDouble("price"));

                int publisherCode = rs.getInt("publisher_code");
                if (!rs.wasNull()) {
                    Publisher publisher = new Publisher();
                    publisher.setCode(rs.getInt("code"));
                    publisher.setName(rs.getString("name"));
                    publisher.setAddress(rs.getString("address"));
                    book.setPublisher(publisher);
                }

                llista.add(book);
            }

        } catch (SQLException e) {
            System.out.println("Error en llistar books: " + e.getMessage());
        }

        return llista;
    }

    public void actualitzar(Book book) {
        String sql = "UPDATE book SET book_name = ?, publisher_code = ?, publish_date = ?, price = ? WHERE isbn = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getName());
            if (book.getPublisher() != null) {
                ps.setInt(2, book.getPublisher().getCode());
            } else {
                ps.setNull(2, java.sql.Types.INTEGER);
            }
            ps.setDate(3, book.getPublishDate());
            ps.setDouble(4, book.getPrice());
            ps.setString(5, book.getIsbn());

            int files = ps.executeUpdate();
            System.out.println("Files actualitzades: " + files);

        } catch (SQLException e) {
            System.out.println("Error en actualitzar book: " + e.getMessage());
        }
    }

    public void eliminar(String isbn) {
        String sql = "DELETE FROM book WHERE isbn = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, isbn);

            int files = ps.executeUpdate();
            System.out.println("Files eliminades: " + files);

        } catch (SQLException e) {
            System.out.println("Error en eliminar book: " + e.getMessage());
        }
    }
}