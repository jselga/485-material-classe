package exercici1dao;

import dao.CursDao;
import model.Curs;
import utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private final CursDao cursDao = new CursDao();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new App().executar();
    }

    private void executar() {
        boolean sortir = false;
        while (!sortir) {
            System.out.println("\n===== EXERCICI 1 · CURSOS =====");
            System.out.println("1. Llistar cursos");
            System.out.println("2. Veure curs per id");
            System.out.println("3. Inserir curs");
            System.out.println("4. Actualitzar curs");
            System.out.println("5. Eliminar curs");
            System.out.println("0. Sortir");

            int opcio = Utils.llegirEnter(scanner, "Opció: ");
            try {
                switch (opcio) {
                    case 1 ->
                        llistarCursos();
                    case 2 ->
                        veureCurs();
                    case 3 ->
                        inserirCurs();
                    case 4 ->
                        actualitzarCurs();
                    case 5 ->
                        eliminarCurs();
                    case 0 ->
                        sortir = true;
                    default ->
                        System.out.println("Opció no vàlida.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Operació no vàlida: " + e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Error tècnic: " + e.getMessage());
            }
        }
    }

    private void llistarCursos() {
        ArrayList<Curs> cursos = cursDao.llistarTots();
        for (Curs curs : cursos) {
            System.out.println(curs);
        }

    }

    private void veureCurs() {
        int id = Utils.llegirEnter(scanner, "Id del curs: ");
        Utils.validarId(id, "L'id del curs ha de ser positiu.");
        Curs curs = cursDao.buscarPerId(id);
        System.out.println(curs == null ? "No s'ha trobat cap curs." : curs);
    }

    private void inserirCurs() {
        String nom = Utils.llegirText(scanner, "Nom: ");
        String nivell = Utils.llegirText(scanner, "Nivell: ");
        Utils.validarNom(nom);
        Utils.validarNivell(nivell);
        cursDao.inserir(new Curs(nom.trim(), nivell.trim()));
        System.out.println("Curs inserit correctament.");
    }

    private void actualitzarCurs() {
        int id = Utils.llegirEnter(scanner, "Id del curs: ");
        Utils.validarId(id, "L'id del curs ha de ser positiu.");
        // Busco si existeix la id introduïda per l'usuari
        Curs curs = cursDao.buscarPerId(id);
        if (curs == null) {
            throw new IllegalArgumentException("No existeix cap curs amb id " + id + ".");
        }
        //Demano la resta de dades si exiteix id
        String nom = Utils.llegirText(scanner, "Nou nom: ");
        Utils.validarNom(nom);
        String nivell = Utils.llegirText(scanner, "Nou nivell: ");
        Utils.validarNivell(nivell);
        //Preparo l'objecte per actualitzar
        curs.setNom(nom.trim());
        curs.setNivell(nivell.trim());
        cursDao.actualitzar(curs);
        System.out.println("Curs actualitzat correctament.");
    }

    private void eliminarCurs() {
        int id = Utils.llegirEnter(scanner, "Id del curs: ");
        Utils.validarId(id, "L'id del curs ha de ser positiu.");

        Curs curs = cursDao.buscarPerId(id);
        if (curs == null) {
            throw new IllegalArgumentException("No existeix cap curs amb id " + id + ".");
        }

        cursDao.eliminar(id);
        System.out.println("Curs eliminat correctament.");
    }

}
