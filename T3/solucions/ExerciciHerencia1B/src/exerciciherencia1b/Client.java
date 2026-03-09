package exerciciherencia1b;

import java.time.LocalDate;

class Client extends Persona {

    private String email;
    private String categoria;
    private LocalDate dataAltaClient;
    private double totalComprat;

    public Client(int id, String nom, String cognoms, String dni, String telefon,
            String email, String categoria, LocalDate dataAltaClient, double totalComprat) {
        super(id, nom, cognoms, dni, telefon);
        this.email = email;
        this.categoria = categoria;
        this.dataAltaClient = dataAltaClient;
        this.totalComprat = totalComprat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataAltaClient() {
        return dataAltaClient;
    }

    public void setDataAltaClient(LocalDate dataAltaClient) {
        this.dataAltaClient = dataAltaClient;
    }

    public double getTotalComprat() {
        return totalComprat;
    }

    public void setTotalComprat(double totalComprat) {
        this.totalComprat = totalComprat;
    }

    @Override
    public String getTipus() {
        return "Client";
    }

    @Override
    public String toString() {
        return "[" + getTipus() + "] " + super.toString()
                + ", email=" + email
                + ", categoria=" + categoria
                + ", dataAltaClient=" + dataAltaClient
                + ", totalComprat=" + totalComprat;
    }
}
