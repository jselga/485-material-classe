package exercici2dao;

import DAO.AlumneDao;
import DAO.CursDao;
import model.Alumne;
import model.Curs;

import java.util.List;

public class Exercici2DAO {

    public static void main(String[] args) {
        CursDao cursDao = new CursDao();
        AlumneDao alumneDao = new AlumneDao();

        try {
            System.out.println("=== EXERCICI 2: ALUMNES I CURSOS ===\n");

            // Netejar taula alumnes al principi per permetre multiples execucions
            System.out.println("Netejant taula alumnes...");
            alumneDao.netejarTaula();
            System.out.println("Taula netejada.\n");
            // Inserir curs de nou;
            cursDao.inserir(new Curs("BD", "Bases de Dades", "1r DAM/DAW"));

            // 1) Inserir alumnes nous nomes si el curs indicat existeix
            System.out.println("1) Inserir alumnes nous:");

            Curs curs1 = cursDao.buscarPerCodi("PROG");
            if (curs1 != null) {
                Alumne alumne1 = new Alumne("Jordi", "Perez Garcia", "jordi@institut.cat", curs1);
                alumneDao.inserir(alumne1);
                System.out.println("   Alumne inserit: " + alumne1.getNom() + " " + alumne1.getCognoms());
            } else {
                System.out.println("   Curs 1 no trobat.");
            }

            if (curs1 != null) {
                Alumne alumne2 = new Alumne("Laia", "Garcia Lopez", "laia@institut.cat", curs1);
                alumneDao.inserir(alumne2);
                System.out.println("   Alumne inserit: " + alumne2.getNom() + " " + alumne2.getCognoms());
            } else {
                System.out.println("   Curs 1 no trobat.");
            }
            Curs curs3 = cursDao.buscarPerCodi("DW");
            if (curs3 != null) {
                Alumne alumne2 = new Alumne("Nora", "Rodriguez Torres", "nora@institut.cat", curs3);
                alumneDao.inserir(alumne2);
                System.out.println("   Alumne inserit: " + alumne2.getNom() + " " + alumne2.getCognoms());
            } else {
                System.out.println("   Curs 3 no trobat.");
            }

            // Mostrar tots els alumnes i cursos
            System.out.println("\n   --- Alumnes i cursos (despres d'inserir) ---");
            System.out.println("   CURSOS:");
            List<Curs> cursos = cursDao.llistarTots();
            for (Curs c : cursos) {
                System.out.println("   - " + c);
            }
            System.out.println("   ALUMNES:");
            List<Alumne> alumnes = alumneDao.llistarTotsAmbCurs();
            for (Alumne a : alumnes) {
                System.out.println("   - " + a);
            }

            // 2) Llistar tots els alumnes mostrant tambe el nom del curs
            System.out.println("\n2) Llistar tots els alumnes amb el nom del curs:");
            alumnes = alumneDao.llistarTotsAmbCurs();
            for (Alumne a : alumnes) {
                System.out.println("   " + a);
            }

            // 3) Donat l'id d'un curs, mostrar les dades del curs i el llistat dels seus alumnes
            System.out.println("\n3) Mostrar curs 1 i els seus alumnes:");
            Curs curs = cursDao.buscarPerId(1);
            if (curs != null) {
                System.out.println("   Curs: " + curs);
                List<Alumne> alumnesCurs = alumneDao.llistarPerCursId(1);
                System.out.println("   Alumnes del curs:");
                for (Alumne a : alumnesCurs) {
                    System.out.println("   - " + a.getNom() + " " + a.getCognoms());
                }
            } else {
                System.out.println("   Curs no trobat.");
            }

            // 4) Actualitzar l'email d'un alumne
            System.out.println("\n4) Actualitzar email de l'alumne 1:");
            boolean actualitzat = alumneDao.actualitzarEmail(1, "jordi.nou@institut.cat");
            System.out.println("   " + (actualitzat ? "Email actualitzat correctament." : "Error en actualitzar."));

            // Mostrar alumnes despres d'actualitzar
            System.out.println("\n   --- Alumnes (despres d'actualitzar email) ---");
            alumnes = alumneDao.llistarTotsAmbCurs();
            for (Alumne a : alumnes) {
                System.out.println("   - " + a);
            }

            // 5) Esborrar cursos comprovant si tenen alumnes
            System.out.println("\n5) Intentar esborrar cursos:");

            // Cas 1: Curs BD (sense alumnes → s'elimina)
            System.out.println("\n   a) Curs BD (sense alumnes):");
            Curs cursBD = cursDao.buscarPerCodi("BD");
            if (cursBD != null) {
                if (!cursDao.teAlumnes(cursBD.getId())) {
                    boolean eliminat = cursDao.eliminar(cursBD.getId());
                    System.out.println("      " + (eliminat ? "Curs eliminat correctament." : "Error en eliminar."));
                } else {
                    System.out.println("      No es pot esborrar: té alumnes assignats.");
                }
            } else {
                System.out.println("      Curs BD no trobat.");
            }

            // Cas 2: Curs PROG (amb alumnes → no s'elimina)
            System.out.println("\n   b) Curs PROG (amb alumnes):");
            Curs cursPROG = cursDao.buscarPerCodi("PROG");
            if (cursPROG != null) {
                if (cursDao.teAlumnes(cursPROG.getId())) {
                    System.out.println("      No es pot esborrar: té " + cursDao.comptarAlumnes(cursPROG.getId()) + " alumnes.");
                } else {
                    cursDao.eliminar(cursPROG.getId());
                    System.out.println("      Curs eliminat correctament.");
                }
            } else {
                System.out.println("      Curs PROG no trobat.");
            }

            System.out.println("\n=== FI DEMO ===");

        } catch (RuntimeException e) {
            System.out.println("\nS'ha produit un error: " + e.getMessage());
            if (e.getCause() != null) {
                System.out.println("Causa: " + e.getCause().getMessage());
            }
        } catch (Exception e) {
            System.out.println("\nS'ha produit un error inesperat: " + e.getMessage());
        }
    }
}
