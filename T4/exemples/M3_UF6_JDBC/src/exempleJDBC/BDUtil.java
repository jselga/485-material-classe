/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exempleJDBC;

import static exempleJDBC.ExempleJDBC.conn;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author alfredo
 */
public class BDUtil {

//    public static void createBDMysql(String db) throws SQLException {
//        PreparedStatement stmt;
//
//        String query = "CREATE DATABASE IF NOT EXISTS " + db;
//        stmt = conn2.prepareStatement(query);
//        stmt.executeUpdate();
//        stmt.close();
//    }
    public static void createEstructuraMysql() throws SQLException {
        PreparedStatement stmt;

        String query = "CREATE TABLE publisher "
                + "(code integer NOT NULL, "
                + " name text,"
                + " address text, "
                + " CONSTRAINT publisher_pkey PRIMARY KEY (code)"
                + ")";
        stmt = conn.prepareStatement(query);

        stmt.executeUpdate();
        stmt.close();
        query = "CREATE TABLE book "
                + "(isbn varchar(10),"
                + " book_name text,"
                + " publisher_code integer, publish_date date, price integer,"
                + " CONSTRAINT book_pkey PRIMARY KEY (isbn),"
                + " CONSTRAINT book_publisher_code_fkey FOREIGN KEY (publisher_code)"
                + " REFERENCES publisher (code) MATCH SIMPLE"
                + " ON UPDATE NO ACTION ON DELETE NO ACTION"
                + ")";

        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();

        query = "CREATE TABLE chapter "
                + "(num integer NOT NULL,"
                + "  title text, numpages integer, "
                + "  book_isbn varchar(10), "
                + " CONSTRAINT chapter_pkey PRIMARY KEY (num), "
                + " CONSTRAINT chapter_book_isbn_fkey FOREIGN KEY (book_isbn) "
                + " REFERENCES book (isbn) MATCH SIMPLE "
                + " ON UPDATE NO ACTION ON DELETE NO ACTION"
                + ")";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
    }

    public static void netejaTaules() {
        PreparedStatement stmt;
        try {
            String query = "delete from chapter";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            stmt = conn.prepareStatement("delete from book");
            stmt.executeUpdate();
            stmt = conn.prepareStatement("delete from publisher");
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createEstructuraPosgreSql() throws SQLException {
        PreparedStatement stmt;
        String query = "CREATE TABLE public.publisher "
                + "(code integer NOT NULL, "
                + " name text COLLATE pg_catalog.\"default\","
                + " address text COLLATE pg_catalog.\"default\", "
                + " CONSTRAINT publisher_pkey PRIMARY KEY (code)"
                + ")";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
        query = "CREATE TABLE public.book "
                + "(isbn text COLLATE pg_catalog.\"default\" NOT NULL,"
                + " book_name text COLLATE pg_catalog.\"default\","
                + " publisher_code integer, publish_date date, price integer,"
                + " CONSTRAINT book_pkey PRIMARY KEY (isbn),"
                + " CONSTRAINT book_publisher_code_fkey FOREIGN KEY (publisher_code)"
                + " REFERENCES public.publisher (code) MATCH SIMPLE"
                + " ON UPDATE NO ACTION ON DELETE NO ACTION"
                + ")";

        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();

        query = "CREATE TABLE public.chapter"
                + "( num integer NOT NULL,"
                + "  title text COLLATE pg_catalog.\"default\", numpages integer, "
                + "  book_isbn text COLLATE pg_catalog.\"default\", "
                + " CONSTRAINT chapter_pkey PRIMARY KEY (num), "
                + " CONSTRAINT chapter_book_isbn_fkey FOREIGN KEY (book_isbn) "
                + " REFERENCES public.book (isbn) MATCH SIMPLE "
                + " ON UPDATE NO ACTION ON DELETE NO ACTION"
                + ")";
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
    }
}
