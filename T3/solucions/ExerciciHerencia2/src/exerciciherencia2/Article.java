package exerciciherencia2;

public class Article {

    private String codi;
    private String nom;
    private double preuBase;

    protected Article(String codi, String nom, double preuBase) {
        this.codi = codi.trim();
        this.nom = nom.trim();
        this.preuBase = preuBase;
    }

    // Helpers de validació
    protected static boolean textValid(String s) {
        return s != null && !s.trim().isEmpty();
    }

    protected static boolean preuValid(double preuBase) {
        return preuBase >= 0;
    }

    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public boolean setCodi(String codi) {

        if (!textValid(codi)) {
            return false;
        }

        this.codi = codi;

        return true;
    }

    public boolean setNom(String nom) {

        if (!textValid(nom)) {
            return false;
        }

        this.nom = nom.trim();

        return true;
    }

    public boolean setPreuBase(double preuBase) {

        if (!preuValid(preuBase)) {
            return false;
        }

        this.preuBase = preuBase;

        return true;
    }

    public double calcularPreuFinal() {
        return preuBase;
    }

    @Override
    public String toString() {
        return "codi='" + codi + '\''
                + ", nom='" + nom + '\''
                + ", preuBase=" + preuBase;
    }

}
