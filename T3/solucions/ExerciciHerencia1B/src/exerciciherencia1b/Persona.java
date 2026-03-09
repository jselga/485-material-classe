package exerciciherencia1b;

abstract class Persona {

    private int id;
    private String nom;
    private String cognoms;
    private String dni;
    private String telefon;

    public Persona(int id, String nom, String cognoms, String dni, String telefon) {
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.dni = dni;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public abstract String getTipus();

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nom=" + nom + ", cognoms=" + cognoms + ", dni=" + dni + ", telefon=" + telefon + '}';
    }

}
