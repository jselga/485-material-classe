/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempleJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Chapter;
import model.Publisher;

/**
 *
 * @author Enaitz & Alfredo
 */
public class ExempleJDBC {

    static final String url = "jdbc:mysql://localhost:3306/";
    static final String dbName = "llibreria2";                  //Nom de la nostra BBDD
    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String userName = "root";
    static final String password = "root";

//    static final String url = "jdbc:postgresql://localhost:5432/";   //La nostra cadena de connexió
//    static final String dbName = "alfredo";                  //Nom de la nostra BBDD
//    static final String driver = "org.postgresql.Driver";
//    static final String userName = "alfredo";
//    static final String password = "alfredo";
    static Connection conn = null;
    static Connection conn2 = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Connexió a BBDD simple
        try {

            conn = DriverManager.getConnection(url + dbName, userName, password);
//            conn2=DriverManager.getConnection(url, userName, password);
            if (!conn.isClosed()) {
                System.out.println("Database connection is working using TCP/IP ...");
            } else {
                System.out.println("Error");
                System.exit(0);
            }
//            BDUtil.createBDMysql(dbName);
//            BDUtil.createEstructuraMysql(); //un sol cop
            BDUtil.netejaTaules();
            insertaBook("12345", "Nom game", 0, Date.valueOf(LocalDate.now()), 27);
            consultaBook("12345");
            actualitzaBook("12345", "Nou Titol");
            esborraBook("12345");
            consultaBook("12345");

            insertaPublisher(1, "Alianza Editorial", "C/ Pricipal, 3");
            Date data = Date.valueOf(LocalDate.of(2018, 1, 15));
            insertaBook("09876", "Ender's game", 1, data, 34);

            insertaChapter("09876", 1, "Capitol 1", 10);
            insertaChapter("09876", 2, "Capitol 2", 15);

            Date data2 = Date.valueOf(LocalDate.of(2023, 4, 25));
            insertaPublisher(2, "Publicador Anonim", "somewhere");
            insertaBook("19876", "UN altre llibre", 2, data2, 24);
            insertaChapter("19876", 3, "Capitol 1b", 10);
            insertaChapter("19876", 4, "Capitol 2b", 15);

            consultaBook("09876");
            insertaPublisherConcat(3, "'Persona'", "'nosedonde'");
            Book bk = consultaORM("09876");
            System.out.println(bk.toString());

            Book bk2 = consultaORM("19876");
            System.out.println(bk2.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    private static void consultaBook(String isbn) throws SQLException, ClassNotFoundException {

        //Exemple d'una consulta senzilla
        PreparedStatement stmt;
        ResultSet rs;

        String query = "SELECT * FROM book WHERE ISBN = ?";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, isbn);
        rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println("ISBN: " + rs.getString("isbn"));
            System.out.println("Book Name: " + rs.getString("book_name"));
            System.out.println("Publisher Code: " + rs.getInt("publisher_code"));
            System.out.println("Publish date: " + rs.getDate("publish_date"));
            System.out.println("Price: " + rs.getInt("price"));

            System.out.println();

        }
        rs.close();
        stmt.close();
    }

    private static void actualitzaBook(String isbn, String name) throws SQLException {

        //Actualització d'un registre
        PreparedStatement stmt;
        stmt = conn.prepareStatement("UPDATE book SET book_name = ? WHERE isbn = ?");
        stmt.setString(1, name);
        stmt.setString(2, isbn);

        int count = stmt.executeUpdate();

        System.out.println("Update count: " + count);

        stmt.close();
    }

    private static void insertaBook(String isbn, String name, int codiPub, Date fPub, int preu) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO book (isbn, book_name, publisher_code, publish_date, price) VALUES (?,?,?, ?, ?)");

        stmt.setString(1, isbn);
        stmt.setString(2, name);
        if (codiPub != 0) {
            stmt.setInt(3, codiPub);
        } else {
            stmt.setNull(3, 0);
        }
        stmt.setDate(4, fPub);
        stmt.setInt(5, preu);

        int count = stmt.executeUpdate();

        System.out.println("Inserted Book count: " + count);
        stmt.close();
    }

    private static void insertaPublisher(int code, String name, String address) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO publisher (code, name, address) VALUES (?,?,?)");
        stmt.setInt(1, code);
        stmt.setString(2, name);
        stmt.setString(3, address);

        int count = stmt.executeUpdate();

        System.out.println("Inserted Pub count: " + count);
        stmt.close();
    }

    private static void insertaPublisherConcat(int code, String name, String address) throws SQLException {

        String query = "INSERT INTO publisher (code, name, address) VALUES (" + code + "," + name + "," + address + ")";
        PreparedStatement stmt = conn.prepareStatement(query);
        int count = stmt.executeUpdate();

        System.out.println("Inserted Pub count: " + count);
        stmt.close();
    }

    private static void insertaChapter(String bookIsbn, int num, String title, int numPages) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO chapter (num, title, numPages, book_isbn) VALUES (?,?,?,?)");
        stmt.setInt(1, num);
        stmt.setString(2, title);
        stmt.setInt(3, numPages);
        stmt.setString(4, bookIsbn);

        int count = stmt.executeUpdate();

        System.out.println("Inserted Chapter count: " + count);
        stmt.close();
    }

    private static void esborraBook(String isbn) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM book WHERE isbn = ?");
        stmt.setString(1, isbn);

        int count = stmt.executeUpdate();

        System.out.println("Deleted count: " + count);
        stmt.close();

    }

    private static Book consultaORM(String isbn) throws SQLException {
        String query = "SELECT * FROM book left join publisher on book.publisher_code = publisher.code WHERE book.isbn = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, isbn);

        ResultSet rs = stmt.executeQuery();
        Book book = new Book();
        if (rs.next()) {
            book.setIsbn(rs.getString("isbn"));
            book.setName(rs.getString("book_name"));
            book.setPublishDate(rs.getDate("publish_date"));
            book.setPrice(rs.getDouble("price"));

            Publisher publisher = new Publisher();
            publisher.setCode(rs.getInt("code"));
            publisher.setName(rs.getString("name"));
            publisher.setAddress(rs.getString("address"));
            book.setPublisher(publisher);
        }
        rs.close();
        stmt.close();

        List<Chapter> chapters = new ArrayList<Chapter>();
        stmt = conn.prepareStatement("SELECT * FROM chapter WHERE book_isbn = ?");
        stmt.setString(1, isbn);
        rs = stmt.executeQuery();
        while (rs.next()) {
            Chapter chapter = new Chapter();
            chapter.setNum(rs.getInt("num"));
            chapter.setTitle(rs.getString("title"));
            chapter.setNumPages(rs.getInt("numpages"));
            chapters.add(chapter);
        }
        book.setChapters(chapters);
        rs.close();
        stmt.close();
        return book;
    }

}
