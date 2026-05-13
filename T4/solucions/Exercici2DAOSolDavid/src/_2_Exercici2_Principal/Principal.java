package _2_Exercici2_Principal;

import _2_Exercici2_DAO.AlumneDAO;
import _2_Exercici2_DAO.CursDAO;
import _2_Exercici2_Model.Alumne;
import _1_Execici1_Model.Curs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Principal {

    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/";
    static final String dbName = "0485_tema4_exercici2";
    static final String userName = "jordi";
    static final String password = "jordi1234";

    private static Connection conn = null;

    public static void main(String[] args) {

        try {
            Class.forName(driver);

            conn = DriverManager.getConnection(url + dbName, userName, password);

            if (!conn.isClosed()) {
                System.out.println("Database connection is working using TCP/IP ...");
            } else {
                System.out.println("Error");
                System.exit(0);
            }

            BDUtil.createEstructuraMysql(conn);
            BDUtil.netejarTaulaAlumnes(conn);

            CursDAO cursDAO = new CursDAO(conn);
            AlumneDAO alumneDAO = new AlumneDAO(conn);

            Curs cursDaw = cursDAO.buscarPerCodi("DAW1");
            if (cursDaw == null) {
                cursDAO.inserir(new Curs("DAW1", "Desenvolupament d'aplicacions web", "GS"));
                cursDaw = cursDAO.buscarPerCodi("DAW1");
            }

            Curs cursSmx = cursDAO.buscarPerCodi("SMX1");
            if (cursSmx == null) {
                cursDAO.inserir(new Curs("SMX1", "Sistemes microinformàtics", "GM"));
                cursSmx = cursDAO.buscarPerCodi("SMX1");
            }

            if (cursDaw != null) {
                Alumne alumne1 = new Alumne("Anna", "Puig Serra", "anna@institut.cat", cursDaw);
                alumneDAO.inserir(alumne1);
                System.out.println("Alumne inserit correctament.");
            } else {
                System.out.println("No es pot inserir l'alumne perquè el curs no existeix.");
            }

            if (cursSmx != null) {
                Alumne alumne2 = new Alumne("Marc", "Riera Costa", "marc@institut.cat", cursSmx);
                alumneDAO.inserir(alumne2);
                System.out.println("Alumne inserit correctament.");
            } else {
                System.out.println("No es pot inserir l'alumne perquè el curs no existeix.");
            }

            System.out.println("\n--- LLISTAT DE TOTS ELS ALUMNES ---");
            List<Alumne> alumnes = alumneDAO.llistarTots();
            for (Alumne a : alumnes) {
                System.out.println(a);
            }

            if (cursDaw != null) {
                System.out.println("\n--- DADES DEL CURS I ELS SEUS ALUMNES ---");
                Curs cursBuscat = cursDAO.buscarPerId(cursDaw.getId());

                if (cursBuscat != null) {
                    System.out.println(cursBuscat);

                    List<Alumne> alumnesDelCurs = alumneDAO.llistarPerCurs(cursBuscat.getId());

                    if (alumnesDelCurs.isEmpty()) {
                        System.out.println("Aquest curs no té alumnes.");
                    } else {
                        for (Alumne a : alumnesDelCurs) {
                            System.out.println(a);
                        }
                    }
                }
            }

            System.out.println("\n--- ACTUALITZAR EMAIL ---");
            boolean actualitzat = alumneDAO.actualitzarEmail(1, "anna.puig@institut.cat");
            System.out.println("Email actualitzat: " + actualitzat);

            System.out.println("\n--- ESBORRAR CURS ---");
            if (cursSmx != null) {
                if (cursDAO.teAlumnes(cursSmx.getId())) {
                    System.out.println("No es pot esborrar el curs perquè té alumnes assignats.");
                } else {
                    boolean eliminat = cursDAO.eliminar(cursSmx.getId());
                    System.out.println("Curs eliminat: " + eliminat);
                }
            }

            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("No s'ha trobat el driver JDBC");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error SQL");
            e.printStackTrace();
        }
    }
}


