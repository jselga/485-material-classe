package exerciciherencia2;

public class Main {

    public static void main(String[] args) {
        Botiga botiga = new Botiga("Botiga Exemple");

        // Crea 2 articles de cada tipus
        Article a1 = ArticleAlimentacio.crear("A001", "Poma", 1.00, 4.0);
        Article a2 = ArticleAlimentacio.crear("A002", "Llet", 0.90, 10.0);

        Article e1 = ArticleElectronic.crear("E001", "Auriculars", 30.00, 24);
        Article e2 = ArticleElectronic.crear("E002", "Portatil", 700.00, 36);

        Article r1 = ArticleRoba.crear("R001", "Samarreta", 20.00, ArticleRoba.REBAIXES);
        Article r2 = ArticleRoba.crear("R002", "Jaqueta", 80.00, ArticleRoba.NOVA_TEMPORADA);

        // 2) Afegeix-los i mostra inventari
        botiga.afegirArticle(a1);
        botiga.afegirArticle(a2);
        botiga.afegirArticle(e1);
        botiga.afegirArticle(e2);
        botiga.afegirArticle(r1);
        botiga.afegirArticle(r2);

        botiga.mostrarInventari();

        // Prova de dades invàlides
        Article invalid = ArticleAlimentacio.crear("   ", "Sense codi", 1.20, 4.0);
        System.out.println("\nCreació article invàlid (codi buit): " + (invalid == null ? "NULL (OK)" : "CREAT (ERROR)"));

        // Intenta afegir un article amb codi repetit
        Article repetit = ArticleAlimentacio.crear("A001", "Poma BIO (repetit)", 1.20, 4.0);
        boolean afegit = botiga.afegirArticle(repetit);
        System.out.println("\nIntent d'afegir codi repetit (A001): " + (afegit ? "AFEGIT (ERROR)" : "NO afegit (OK)"));

        // Elimina un article per codi i torna a mostrar
        boolean eliminat = botiga.eliminarPerCodi("E001");
        System.out.println("\nEliminació E001: " + (eliminat ? "OK" : "No trobat"));
        botiga.mostrarInventari();

        // Modifica un article per codi
        boolean modificat = botiga.modificarArticle("R002", "Jaquetaaaaaa impermeable", 75.00);
        System.out.println("\nModificació R002: " + (modificat ? "OK" : "Dades invàlides o no trobat"));
        botiga.mostrarInventari();

        // Mostra per tipus
        botiga.mostrarArticlesPerTipus("alimentacio");
        botiga.mostrarArticlesPerTipus("electronica");
        botiga.mostrarArticlesPerTipus("roba");
    }

    private static void afegirMostrantResultat(Botiga b, Article a) {
        if (a == null) {
            System.out.println("No s'ha creat l'article (dades invàlides).");
            return;
        }
        boolean ok = b.afegirArticle(a);
        if (!ok) {
            System.out.println("No s'ha pogut afegir l'article amb codi " + a.getCodi() + " (duplicat o invàlid).");
        }
    }
}
