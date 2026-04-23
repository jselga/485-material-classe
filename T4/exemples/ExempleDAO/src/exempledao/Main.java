package exempledao;

import dao.BookDao;
import dao.PublisherDao;
import dao.ChapterDao;
import dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Book;
import model.Publisher;
import model.Chapter;

public class Main {

    public static void main(String[] args) {
        System.out.println("===Exemple DAO===");

        provaConnexio();
        provaPublisher();
        provaBook();
    }

    private static void provaConnexio() {
        System.out.println("\n--- Test connexio ---");
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Connexio OK: " + !conn.isClosed());
        } catch (SQLException e) {
            System.out.println("Error connexio: " + e.getMessage());
        }
    }

    private static void provaPublisher() {
        System.out.println("\n--- Test Publisher DAO ---");
        PublisherDao dao = new PublisherDao();

        Publisher p1 = new Publisher(3, "Editorial Nova", "Carrer Major 10");
        dao.insertar(p1);

        Publisher cercat = dao.buscarPerCodi(1);
        System.out.println("Buscar: " + cercat);

        ArrayList<Publisher> tots = dao.llistarTots();
        System.out.println("Llistar: " + tots);

        p1.setName("Editorial Actualitzada");
        dao.actualitzar(p1);

        dao.eliminar(1);
    }

    private static void provaBook() {
        System.out.println("\n--- Test Book DAO ---");
        BookDao bookDao = new BookDao();
        PublisherDao publisherDao = new PublisherDao();

        Publisher p2 = new Publisher(5, "Segona Editorial", "Carrer Nou 5");
        publisherDao.insertar(p2);

        Book llibre = new Book();
        llibre.setIsbn("978-84-12345");
        llibre.setName("Llibre d'Exemple");
        llibre.setPublisher(p2);
        llibre.setPublishDate(Date.valueOf(LocalDate.now()));
        llibre.setPrice(25.99);

        bookDao.insertar(llibre);

        Book cercat = bookDao.buscarPerIsbn("978-84-12345");
        System.out.println("Buscar: " + cercat);

        ArrayList<Book> tots = bookDao.llistarTots();
        System.out.println("Llistar: " + tots);

        ChapterDao chapterDao = new ChapterDao();
        Chapter cap1 = new Chapter();
        cap1.setNum(5);
        cap1.setTitle("Capitol 3");
        cap1.setNumPages(10);
        chapterDao.insertar(cap1, "978-84-12345");

        Chapter cap2 = new Chapter();
        cap2.setNum(6);
        cap2.setTitle("Capitol 4");
        cap2.setNumPages(25);
        chapterDao.insertar(cap2, "978-84-12345");

        ArrayList<Chapter> caps = chapterDao.buscarPerBookIsbn("978-84-12345");
        System.out.println("Chapters: " + caps);

        chapterDao.eliminar("978-84-12345");
        bookDao.eliminar("978-84-12345");
        publisherDao.eliminar(2);
    }
}
