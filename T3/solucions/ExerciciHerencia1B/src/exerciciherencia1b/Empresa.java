package exerciciherencia1b;

import java.util.ArrayList;

class Empresa {

    private String nom;
    private String cif;
    private String adreca;

    private ArrayList<Treballador> treballadors = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Persona> persones = new ArrayList<>();

    public Empresa(String nom, String cif, String adreca) {
        this.nom = nom;
        this.cif = cif;
        this.adreca = adreca;
    }
    public boolean  afegirPersona(Persona p){
        
        return persones.add(p);
    }
    public void copia(){
        persones.addAll(clients);
        persones.addAll(treballadors);
    }
    public void afegirTreballador(Treballador t) {

        if (cercarTreballadorPerDni(t.getDni()) == null) {
            if (cercarPersonaPerId(t.getId()) == null) {
                treballadors.add(t);
            } else {
                System.out.println("Id repetit!");
            }

        } else {
            System.out.println("DNI repetit!");
        }
    }

    public void afegirClient(Client c) {
        if (cercarTreballadorPerDni(c.getDni()) == null) {
            if (cercarPersonaPerId(c.getId()) == null) {
                clients.add(c);
            } else {
                System.out.println("Id repetit!");
            }

        } else {
            System.out.println("DNI repetit!");
        }

    }

    public Persona cercarPersonaPerId(int id) {

        for (Treballador t : treballadors) {
            if (t.getId() == id) {
                return t;
            }
        }
        for (Client c : clients) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;

    }

    public Treballador cercarTreballadorPerDni(String dni) {
        for (Treballador t : treballadors) {
            if (t.getDni().equalsIgnoreCase(dni)) {
                return t;
            }
        }
        return null;
    }

    public Client cercarClientPerDni(String dni) {
        for (Client c : clients) {
            if (c.getDni().equalsIgnoreCase(dni)) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminarTreballadorPerDni(String dni) {

        Treballador t = cercarTreballadorPerDni(dni);

        if (t == null) {
            System.out.println("No s'ha eliminat cap treballador");
            return false;

        } else {
            return treballadors.remove(t);

        }

    }

    public boolean eliminarClientPerDni(String dni) {

        Client t = cercarClientPerDni(dni);

        if (t == null) {
            System.out.println("No s'ha eliminat cap client");
            return false;

        } else {
            return clients.remove(t);

        }
    }

    public void mostrar() {
        System.out.println("Empresa: " + nom + " (CIF: " + cif + ")");
        System.out.println("Adreça: " + adreca);

        System.out.println("\n--- TREBALLADORS (" + treballadors.size() + ") ---");
        for (Treballador t : treballadors) {
            System.out.println(t);
        }

        System.out.println("\n--- CLIENTS (" + clients.size() + ") ---");
        for (Client c : clients) {
            System.out.println(c);
        }
    }
        public void dades() {
        System.out.println("Empresa: " + nom + " (CIF: " + cif + ")");
        System.out.println("Adreça: " + adreca);

       
        for (Persona p : persones) {
            System.out.println(p);
        }

        
    }
}
