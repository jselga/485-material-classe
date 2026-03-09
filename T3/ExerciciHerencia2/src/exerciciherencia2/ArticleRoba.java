package exerciciherencia2;

public class ArticleRoba extends Article {

    public static final String REBAIXES = "REBAIXES";
    public static final String FI_TEMPORADA = "FI_TEMPORADA";
    public static final String NOVA_TEMPORADA = "NOVA_TEMPORADA";

    private String temporada;

    private ArticleRoba(String codi, String nom, double preuBase, String temporada) {
        super(codi, nom, preuBase);
        this.temporada = temporada;
    }

    public static ArticleRoba crear(String codi, String nom, double preuBase, String temporada) {

        if (!Article.textValid(codi)) {
            return null;
        }

        if (!Article.textValid(nom)) {
            return null;
        }

        if (!Article.preuValid(preuBase)) {
            return null;
        }

        if (!temporadaValida(temporada)) {
            return null;
        }

        return new ArticleRoba(codi.trim(), nom.trim(), preuBase, temporada.trim().toUpperCase());
    }

    public String getTemporada() {
        return temporada;
    }

    public boolean setTemporada(String temporada) {

        if (!temporadaValida(temporada)) {
            return false;
        }

        this.temporada = temporada.trim().toUpperCase();

        return true;
    }

    private static boolean temporadaValida(String temporada) {

        if (temporada == null || temporada.trim().isEmpty()) {

            return false;
        }

        String t = temporada.trim().toUpperCase();

        return t.equals(REBAIXES) || t.equals(FI_TEMPORADA) || t.equals(NOVA_TEMPORADA);
    }

    private double obtenirDescompte() {

        switch (temporada) {

            case REBAIXES:
                return 0.30;

            case FI_TEMPORADA:
                return 0.15;

            case NOVA_TEMPORADA:

            default:
                return 0.0;
        }
    }

    @Override
    public double calcularPreuFinal() {
        double descompte = obtenirDescompte();
        return getPreuBase() * (1 - descompte);
    }

    @Override
    public String toString() {
        return "ArticleRoba{"
                + super.toString()
                + ", temporada='" + temporada + '\''
                + "}";
    }
}
