# Tema 4: Connexió a bases de dades des de Java

## 1. Per què volem connectar un programa a una BBDD?

Fins ara, molts programes que hem fet **començaven de zero cada vegada que els executàvem**.

Això vol dir que:

- les dades existien mentre el programa estava obert,
- però en tancar-lo es perdien,
- i en tornar-lo a executar calia tornar a escriure-ho tot.

Aquesta manera de treballar és útil per aprendre:

- variables,
- condicionals,
- bucles,
- mètodes,
- classes,
- objectes.

Però quan volem fer programes una mica més reals, apareix una necessitat nova: **guardar la informació perquè continuï existint encara que el programa es tanqui**.

Per exemple, si fem una aplicació de:

- propietaris,
- alumnes,
- llibres,
- pel·lícules,
- comandes,
- productes,

no té sentit perdre totes les dades cada cop que tanquem l'aplicació.

Aquí entra la idea de **persistència**.

### Persistència

La persistència és la capacitat d'un programa de **guardar dades de manera duradora** i recuperar-les més endavant.

En aquest tema no estudiarem el disseny de la base de dades ni l'SQL en profunditat, perquè això ja es treballa a l'assignatura de Bases de Dades. Aquí ens centrarem en una altra pregunta:

> **Com fem que un programa Java es connecti a una base de dades i hi treballi?**

Per tant, el centre del tema és el **pont entre Java i MySQL**.

---

## 2. Què necessita un programa Java per parlar amb MySQL?

Perquè un programa Java pugui treballar amb una base de dades MySQL, necessitem diverses peces.

### 2.1. El servidor de base de dades

MySQL ha d'estar instal·lat i en funcionament.

### 2.2. La base de dades i les taules

La base de dades ja ha d'existir, igual que les taules amb què treballarem. En aquest mòdul **no ens centrarem a dissenyar-les**, sinó a utilitzar-les des del programa.

### 2.3. Un usuari i una contrasenya

Java necessita credencials per poder-se connectar.

Per exemple:

- usuari: `root`
- contrasenya: `1234`

### 2.4. L'adreça de connexió

Java ha de saber **on** és la base de dades i **quina** és.

Exemple d'URL de connexió:

```java
String url = "jdbc:mysql://localhost:3306/institut";
```

Això vol dir:

- `jdbc:mysql:` -> farem servir MySQL a través de JDBC
- `localhost` -> la base de dades és al mateix ordinador
- `3306` -> port habitual de MySQL
- `institut` -> nom de la base de dades

### 2.5. El connector JDBC

Java no es pot connectar tot sol a MySQL. Necessita una llibreria que faci de connector.

Aquesta llibreria és el **driver JDBC** de MySQL.

Sense aquest connector, el programa no sabrà com parlar amb MySQL.

### 2.6. Un projecte Java preparat

El projecte ha de tenir accés al connector JDBC. Això es pot fer de diferents maneres segons l'entorn, però la teoria del tema és la mateixa.

---

## 3. Què és JDBC?

**JDBC** vol dir **Java Database Connectivity**.

És la tecnologia que permet que Java es connecti a una base de dades i executi instruccions SQL.

Dit d'una manera simple:

- **MySQL** guarda les dades
- **SQL** és el llenguatge que entén la base de dades
- **JDBC** és el pont entre Java i la base de dades

### Idea general del procés

El flux bàsic és aquest:

1. Java obre una connexió amb MySQL.
2. Java envia una instrucció SQL.
3. MySQL la processa.
4. MySQL retorna un resultat si cal.
5. Java llegeix aquest resultat i el converteix en dades útils per al programa.
6. Es tanquen els recursos.

---

## 4. Flux bàsic de treball

Quan treballem amb JDBC, normalment seguim sempre el mateix patró.

### Pas 1. Obrir connexió

```java
Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
```

### Pas 2. Preparar l'SQL

```java
String sql = "SELECT dni, nom, telefon FROM propietari WHERE dni = ?";
PreparedStatement ps = conn.prepareStatement(sql);
```

### Pas 3. Posar valors als paràmetres

```java
ps.setString(1, "12345678A");
```

### Pas 4. Executar

Si és una consulta `SELECT`, fem servir `executeQuery()`:

```java
ResultSet rs = ps.executeQuery();
```

Si és un `INSERT`, `UPDATE` o `DELETE`, fem servir `executeUpdate()`:

```java
int filesAfectades = ps.executeUpdate();
```

### Pas 5. Llegir el resultat

```java
while (rs.next()) {
    String dni = rs.getString("dni");
    String nom = rs.getString("nom");
    String telefon = rs.getString("telefon");

    System.out.println(dni + " - " + nom + " - " + telefon);
}
```

### Pas 6. Tancar recursos

És molt important tancar tot el que hem obert:

- `ResultSet`
- `PreparedStatement`
- `Connection`

La manera més recomanable és fer servir **try-with-resources**.

---

## 5. Peces principals de JDBC

## `Connection`

Representa la connexió oberta amb la base de dades.

És l'objecte que permet al programa començar a treballar amb MySQL.

```java
Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
```

## `PreparedStatement`

Representa una instrucció SQL preparada.

Serveix per executar SQL amb valors variables.

```java
String sql = "SELECT * FROM propietari WHERE dni = ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, dni);
```

### Per què és millor que concatenar textos?

Perquè:

- el codi queda més net,
- evita molts errors de format,
- és més segur,
- i és la manera habitual de treballar.

No és recomanable fer això:

```java
String sql = "SELECT * FROM propietari WHERE dni = '" + dni + "'";
```

És millor fer això:

```java
String sql = "SELECT * FROM propietari WHERE dni = ?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, dni);
```

## `ResultSet`

Representa el resultat d'una consulta `SELECT`.

Un `ResultSet` es recorre fila a fila.

```java
ResultSet rs = ps.executeQuery();

while (rs.next()) {
    System.out.println(rs.getString("nom"));
}
```

### `rs.next()`

Aquest mètode mou el cursor a la següent fila.

- si existeix una fila, retorna `true`
- si ja no n'hi ha més, retorna `false`

## `SQLException`

És l'excepció que apareix quan hi ha problemes relacionats amb la base de dades.

Per exemple:

- credencials incorrectes,
- base de dades inexistent,
- taula inexistent,
- error en l'SQL,
- problema de connexió.

```java
try {
    Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
} catch (SQLException e) {
    System.out.println("Error de base de dades: " + e.getMessage());
}
```

---

## 6. Exemple complet mínim de connexió i consulta

Suposem que tenim una taula `propietari` amb aquestes columnes:

- `dni`
- `nom`
- `telefon`

Exemple senzill:

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExempleConnexio {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/institut";
        String usuari = "root";
        String contrasenya = "1234";

        String sql = "SELECT dni, nom, telefon FROM propietari";

        try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String dni = rs.getString("dni");
                String nom = rs.getString("nom");
                String telefon = rs.getString("telefon");

                System.out.println(dni + " - " + nom + " - " + telefon);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### Què s'ha fet aquí?

1. S'ha definit la informació de connexió.
2. S'ha escrit l'SQL.
3. S'ha obert la connexió.
4. S'ha preparat la instrucció.
5. S'ha executat la consulta.
6. S'han llegit les files del resultat.
7. S'han tancat els recursos automàticament.

---

## 7. CRUD des de Java

Recordem que CRUD vol dir:

- **Create** -> inserir
- **Read** -> consultar
- **Update** -> actualitzar
- **Delete** -> esborrar

Aquí no explicarem l'SQL des de zero. El que ens interessa és **com executar aquestes operacions des de Java**.

## 7.1. Create - inserir

```java
String sql = "INSERT INTO propietari (dni, nom, telefon) VALUES (?, ?, ?)";

try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
     PreparedStatement ps = conn.prepareStatement(sql)) {

    ps.setString(1, "12345678A");
    ps.setString(2, "Anna Puig");
    ps.setString(3, "600111222");

    int filesAfectades = ps.executeUpdate();
    System.out.println("Files inserides: " + filesAfectades);

} catch (SQLException e) {
    System.out.println(e.getMessage());
}
```

## 7.2. Read - consultar un registre

```java
String sql = "SELECT dni, nom, telefon FROM propietari WHERE dni = ?";

try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
     PreparedStatement ps = conn.prepareStatement(sql)) {

    ps.setString(1, "12345678A");

    try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
            System.out.println(rs.getString("nom"));
        } else {
            System.out.println("No s'ha trobat cap propietari");
        }
    }

} catch (SQLException e) {
    System.out.println(e.getMessage());
}
```

## 7.3. Read - llistar diversos registres

```java
String sql = "SELECT dni, nom, telefon FROM propietari";

try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
     PreparedStatement ps = conn.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {

    while (rs.next()) {
        System.out.println(rs.getString("dni") + " - " + rs.getString("nom"));
    }

} catch (SQLException e) {
    System.out.println(e.getMessage());
}
```

## 7.4. Update - modificar

```java
String sql = "UPDATE propietari SET telefon = ? WHERE dni = ?";

try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
     PreparedStatement ps = conn.prepareStatement(sql)) {

    ps.setString(1, "699888777");
    ps.setString(2, "12345678A");

    int filesAfectades = ps.executeUpdate();
    System.out.println("Files modificades: " + filesAfectades);

} catch (SQLException e) {
    System.out.println(e.getMessage());
}
```

## 7.5. Delete - esborrar

```java
String sql = "DELETE FROM propietari WHERE dni = ?";

try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
     PreparedStatement ps = conn.prepareStatement(sql)) {

    ps.setString(1, "12345678A");

    int filesAfectades = ps.executeUpdate();
    System.out.println("Files eliminades: " + filesAfectades);

} catch (SQLException e) {
    System.out.println(e.getMessage());
}
```

---

## 8. Passar de resultats de la BBDD a objectes Java

A Programació, el més important no és només recuperar dades, sinó **integrar-les dins del nostre codi orientat a objectes**.

Una idea clau és aquesta:

- **una fila d'una taula** pot convertir-se en **un objecte Java**
- **diverses files** poden convertir-se en **una llista d'objectes**

## 8.1. Classe model

```java
public class Propietari {

    private String dni;
    private String nom;
    private String telefon;

    public Propietari() {
    }

    public Propietari(String dni, String nom, String telefon) {
        this.dni = dni;
        this.nom = nom;
        this.telefon = telefon;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
```

## 8.2. Transformar una fila en un objecte

```java
String sql = "SELECT dni, nom, telefon FROM propietari WHERE dni = ?";
Propietari propietari = null;

try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
     PreparedStatement ps = conn.prepareStatement(sql)) {

    ps.setString(1, "12345678A");

    try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
            propietari = new Propietari(
                rs.getString("dni"),
                rs.getString("nom"),
                rs.getString("telefon")
            );
        }
    }

} catch (SQLException e) {
    System.out.println(e.getMessage());
}
```

Aquí hem fet una cosa molt important: **agafar una fila de la base de dades i convertir-la en un objecte Java**.

## 8.3. Transformar diverses files en una llista

```java
import java.util.ArrayList;

String sql = "SELECT dni, nom, telefon FROM propietari";
ArrayList<Propietari> propietaris = new ArrayList<>();

try (Connection conn = DriverManager.getConnection(url, usuari, contrasenya);
     PreparedStatement ps = conn.prepareStatement(sql);
     ResultSet rs = ps.executeQuery()) {

    while (rs.next()) {
        Propietari p = new Propietari(
            rs.getString("dni"),
            rs.getString("nom"),
            rs.getString("telefon")
        );

        propietaris.add(p);
    }

} catch (SQLException e) {
    System.out.println(e.getMessage());
}
```

Això és el que farem molt sovint en programes reals.

---

## 9. Organització del projecte i bones pràctiques

Quan el programa és petit, podem posar molt codi dins del `main`. Però quan comencem a treballar amb base de dades, això es torna difícil de mantenir.

No és una bona idea barrejar en un únic lloc:

- lectura per teclat,
- missatges per pantalla,
- connexió a la BBDD,
- SQL,
- creació d'objectes,
- validacions,
- lògica del programa.

### Estructura bàsica recomanada

```text
src
└── main
    └── java
        ├── app
        │   └── App.java
        ├── model
        │   └── Propietari.java
        ├── dao
        │   └── PropietariDao.java
        ├── service
        │   └── PropietariService.java
        └── util
            └── DatabaseConnection.java
```

## `model`

Conté les classes del domini del problema.

Exemple:

- `Propietari`
- `Alumne`
- `Llibre`

## `dao`

DAO vol dir **Data Access Object**.

Són les classes que s'encarreguen de parlar amb la base de dades.

Exemple:

- `insertarPropietari()`
- `buscarPerDni()`
- `llistarTots()`
- `actualitzar()`
- `eliminar()`

## `service`

És una capa intermèdia on posem la lògica del programa.

Per exemple:

- comprovar si un propietari ja existeix,
- validar dades abans de guardar,
- decidir què fer si una consulta no retorna res.

## `app`

És el punt d'entrada del programa.

Exemple:

- `main`
- menú de consola
- proves del funcionament

## `util`

Hi podem posar utilitats comunes, com la classe que obre connexions.

### Exemple de classe de connexió

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/institut";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
```

Així evitem repetir les dades de connexió a tot arreu.

---

## 10. Arquitectura en tres capes

La idea de l'arquitectura en tres capes és **separar responsabilitats**.

Això fa que el programa sigui més fàcil d'entendre, modificar i ampliar.

## 10.1. Capa de presentació

És la capa que parla amb l'usuari.

Exemples:

- missatges per consola,
- lectura per teclat,
- menús,
- finestres si en féssim.

Pregunta típica d'aquesta capa:

> Què veu i què fa l'usuari?

## 10.2. Capa de lògica o negoci

És la capa on posem les decisions del programa.

Exemples:

- comprovar si una dada és correcta,
- decidir si es pot inserir un registre,
- validar abans de desar,
- combinar diferents operacions.

Pregunta típica d'aquesta capa:

> Quines regles segueix el programa?

## 10.3. Capa d'accés a dades

És la capa que parla amb la base de dades.

Aquí hi trobem:

- connexions,
- `PreparedStatement`,
- `ResultSet`,
- consultes i actualitzacions.

Pregunta típica d'aquesta capa:

> Com es guarden i es recuperen les dades?

### Exemple mental

Si l'usuari vol buscar un propietari:

1. la capa de presentació rep el DNI,
2. la capa de lògica decideix què fer,
3. la capa d'accés a dades consulta la BBDD,
4. el resultat torna cap amunt.

### Per què ens interessa aquesta separació?

Perquè evita programes desordenats i ajuda a:

- trobar errors,
- reaprofitar codi,
- fer canvis sense trencar-ho tot,
- entendre millor què fa cada part.

---

## 11. Exemple simple de DAO

```java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PropietariDao {

    public void inserir(Propietari propietari) {
        String sql = "INSERT INTO propietari (dni, nom, telefon) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, propietari.getDni());
            ps.setString(2, propietari.getNom());
            ps.setString(3, propietari.getTelefon());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error en inserir: " + e.getMessage());
        }
    }

    public Propietari buscarPerDni(String dni) {
        String sql = "SELECT dni, nom, telefon FROM propietari WHERE dni = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Propietari(
                        rs.getString("dni"),
                        rs.getString("nom"),
                        rs.getString("telefon")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en buscar: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<Propietari> llistarTots() {
        String sql = "SELECT dni, nom, telefon FROM propietari";
        ArrayList<Propietari> llista = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                llista.add(new Propietari(
                    rs.getString("dni"),
                    rs.getString("nom"),
                    rs.getString("telefon")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error en llistar: " + e.getMessage());
        }

        return llista;
    }
}
```

Aquest exemple ja mostra una estructura molt més ordenada que posar-ho tot dins del `main`.

---

## 12. Errors habituals

Quan es comença a treballar amb JDBC, hi ha uns errors que apareixen molt sovint.

## 12.1. El connector JDBC no està ben afegit al projecte

Símptoma habitual:

- el programa no troba el driver,
- o directament no es pot connectar.

## 12.2. URL incorrecta

Per exemple:

- nom de base de dades mal escrit,
- port incorrecte,
- servidor incorrecte.

Exemple:

```java
jdbc:mysql://localhost:3306/institut
```

Si `institut` no existeix, la connexió fallarà.

## 12.3. Usuari o contrasenya incorrectes

És un dels errors més habituals.

## 12.4. La base de dades o la taula no existeixen

El programa es connecta, però falla quan intenta executar la instrucció SQL.

## 12.5. No tancar recursos

Si no tanquem connexions, `PreparedStatement` o `ResultSet`, podem acabar tenint problemes de funcionament.

Per això és millor fer servir **try-with-resources**.

## 12.6. Llegir malament el `ResultSet`

Errors típics:

- oblidar fer `rs.next()`,
- escriure malament el nom d'una columna,
- demanar un tipus que no correspon.

## 12.7. Barrejar massa responsabilitats al `main`

Aquest no és un error tècnic immediat, però sí un error de disseny molt habitual.

Quan tot està barrejat:

- costa provar el codi,
- costa trobar errors,
- costa reutilitzar-lo,
- i el programa creix malament.

## 12.8. Concatenar valors dins de l'SQL

No és una bona pràctica. És preferible usar `PreparedStatement` amb paràmetres.

---

## 13. Com llegir un error de `SQLException`

Quan hi ha una `SQLException`, no n'hi ha prou amb dir "ha fallat". Cal mirar el missatge.

```java
catch (SQLException e) {
    System.out.println("Missatge: " + e.getMessage());
}
```

La pregunta que ens hem de fer és:

> El problema és de connexió, de credencials, de taula, de columna o de sintaxi SQL?

Aprendre a llegir el missatge d'error és una part important de treballar amb bases de dades des de Java.

---
