package exerciciherencia1b;

import java.time.LocalDate;

class Treballador extends Persona {

    private String departament;
    private double salariAnual;
    private LocalDate dataAlta;
    private String numSeguretatSocial;

    public Treballador(int id, String nom, String cognoms, String dni, String telefon,
            String departament, double salariAnual, LocalDate dataAlta, String numSeguretatSocial) {
        super(id, nom, cognoms, dni, telefon);
        this.departament = departament;
        this.salariAnual = salariAnual;
        this.dataAlta = dataAlta;
        this.numSeguretatSocial = numSeguretatSocial;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public double getSalariAnual() {
        return salariAnual;
    }

    public void setSalariAnual(double salariAnual) {
        this.salariAnual = salariAnual;
    }

    public LocalDate getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(LocalDate dataAlta) {
        this.dataAlta = dataAlta;
    }

    public String getNumSeguretatSocial() {
        return numSeguretatSocial;
    }

    public void setNumSeguretatSocial(String numSeguretatSocial) {
        this.numSeguretatSocial = numSeguretatSocial;
    }

    @Override
    public String getTipus() {
        return "Treballador";
    }

    @Override
    public String toString() {
        return "[" + getTipus() + "] " + super.toString()
                + ", departament=" + departament
                + ", salariAnual=" + salariAnual
                + ", dataAlta=" + dataAlta
                + ", numSeguretatSocial=" + numSeguretatSocial;
    }
}
