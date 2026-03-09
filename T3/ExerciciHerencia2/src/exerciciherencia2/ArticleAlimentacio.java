package exerciciherencia2;

public class ArticleAlimentacio extends Article {

    private double percentatgeIVA;

    private ArticleAlimentacio(String codi, String nom, double preuBase, double percentatgeIVA) {
        super(codi, nom, preuBase);
        this.percentatgeIVA = percentatgeIVA;
    }

    public static ArticleAlimentacio crear(String codi, String nom, double preuBase, double percentatgeIVA) {

        if (!textValid(codi)) {
            return null;
        }

        if (!Article.textValid(nom)) {
            return null;
        }

        if (!Article.preuValid(preuBase)) {
            return null;
        }

        if (percentatgeIVA < 0) {
            return null;
        }

        return new ArticleAlimentacio(codi, nom, preuBase, percentatgeIVA);
    }

    public double getPercentatgeIVA() {

        return percentatgeIVA;
    }

    public boolean setPercentatgeIVA(double percentatgeIVA) {

        if (percentatgeIVA < 0) {
            return false;
        }

        this.percentatgeIVA = percentatgeIVA;

        return true;
    }

    @Override
    public double calcularPreuFinal() {

        return getPreuBase() * (1 + percentatgeIVA / 100.0);
    }

    @Override
    public String toString() {
        return "ArticleAlimentacio{"
                + super.toString()
                + ", percentatgeIVA=" + percentatgeIVA
                + "}";
    }
}
