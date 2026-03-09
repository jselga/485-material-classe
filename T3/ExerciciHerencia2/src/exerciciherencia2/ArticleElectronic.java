package exerciciherencia2;

public class ArticleElectronic extends Article {

    public final double IVA_ELECTRONICA = 21.0;     // %
    public final double RECARREC_ELECTRONIC = 3.0;  // %

    private int garantiaMesos;

    private ArticleElectronic(String codi, String nom, double preuBase, int garantiaMesos) {
        super(codi, nom, preuBase);
        this.garantiaMesos = garantiaMesos;
    }

    public static ArticleElectronic crear(String codi, String nom, double preuBase, int garantiaMesos) {

        if (!Article.textValid(codi)) {
            return null;
        }

        if (!Article.textValid(nom)) {
            return null;
        }

        if (!Article.preuValid(preuBase)) {
            return null;
        }

        if (garantiaMesos < 0) {
            return null;
        }

        return new ArticleElectronic(codi.trim(), nom.trim(), preuBase, garantiaMesos);
    }

    public int getGarantiaMesos() {
        return garantiaMesos;
    }

    public boolean setGarantiaMesos(int garantiaMesos) {

        if (garantiaMesos < 0) {
            return false;
        }

        this.garantiaMesos = garantiaMesos;

        return true;
    }

    @Override
    public double calcularPreuFinal() {

        return getPreuBase()
                * (1 + IVA_ELECTRONICA / 100.0)
                * (1 + RECARREC_ELECTRONIC / 100.0);
    }

    @Override
    public String toString() {
        return "ArticleElectronic{"
                + super.toString()
                + ", garantiaMesos=" + garantiaMesos
                + "}";
    }
}
