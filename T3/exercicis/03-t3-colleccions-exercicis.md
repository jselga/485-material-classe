# Exercicis col·leccions

## 1) Exercici `ArrayList` — Gestor de tasques

Volem gestionar una llista de tasques d’estudi.

### Requisits
1. Crea una classe `Tasca` amb:
   - `String titol`
   - `int prioritat` (1..5)
   - `boolean completada`
2. Crea una classe `GestorTasques` amb un `ArrayList<Tasca>` i mètodes:
   - `void afegir(Tasca t)`
   - `boolean eliminarPerTitol(String titol)` (elimina la primera coincidència)
   - `void marcarCompletada(String titol)`
   - `List<Tasca> pendents()` (retorna les no completades)
   - `void ordenarPerPrioritatDesc()` (usant `Comparator`)
   - `void mostrar()`

### Prova (`main`)
- Afegeix 6 tasques.
- Inserta una tasca “al mig” amb `add(index, ...)`.
- Ordena per prioritat i mostra el resultat.
- Elimina una tasca i torna a mostrar.

## 2) Exercici `HashSet` — Control d’inscripcions (sense duplicats)

Un esdeveniment permet inscriure participants, però **no es poden repetir** emails.

### Requisits
1. Crea una classe `Participant` amb:
   - `String nom`
   - `String email`
2. Implementa `equals()` i `hashCode()` perquè **dos participants siguin iguals si tenen el mateix email**.

3. Crea una classe `Inscripcions` amb un `HashSet<Participant>` i mètodes:
   - `boolean inscriure(Participant p)` (retorna `false` si ja existeix)
   - `boolean donarDeBaixaPerEmail(String email)`
   - `boolean estaInscrit(String email)`
   - `int total()`
   - `void mostrar()`

### Prova (`main`)
- Inscriu 5 participants, repetint 1 email a propòsit.
- Mostra el total i comprova que **no** s’ha duplicat.
- Dona de baixa un email i torna a mostrar.


## 3) Exercici `TreeSet` — Rànquing automàtic (ordenació + navegació)

Volem un rànquing de jugadors ordenat automàticament.

### Requisits
1. Crea una classe `Jugador` amb:
   - `String nick`
   - `int punts`
2. Defineix un ordre al `TreeSet` (tria **una**):
   - **Opció A:** `Jugador implements Comparable<Jugador>` (ordre per `punts desc` i després `nick asc`)
   - **Opció B:** `TreeSet<Jugador>` amb un `Comparator` equivalent
3. Crea una classe `Ranking` amb un `TreeSet<Jugador>` i mètodes:
   - `void afegir(Jugador j)`
   - `void mostrarTopN(int n)`
   - `Jugador primer()` i `Jugador ultim()`
   - `void mostrarEntrePunts(int min, int max)` (pots fer-ho amb recorregut o amb un “set auxiliar”)

### Prova (`main`)
- Afegeix 8 jugadors (amb punts repetits).
- Mostra `first()` i `last()`.
- Mostra el Top 3.
- Mostra els jugadors entre 50 i 100 punts.

## 4) Exercici `HashMap` — Catàleg per codi (accés per clau)

Tenim un catàleg de productes i volem consultar-los pel seu codi.

### Requisits
1. Crea una classe `Producte` amb:
   - `String codi` (únic)
   - `String nom`
   - `double preu`
2. Crea una classe `Cataleg` amb un `HashMap<String, Producte>` i mètodes:
   - `boolean afegir(Producte p)` (si el codi existeix, no l’afegeix)
   - `Producte cercar(String codi)`
   - `boolean actualitzarPreu(String codi, double nouPreu)`
   - `boolean eliminar(String codi)`
   - `void mostrarCodis()` (amb `keySet()`)
   - `void mostrarTot()` (amb `entrySet()`)

### Prova (`main`)
- Afegeix 5 productes.
- Cerca’n 2 per codi.
- Prova d’afegir un producte amb codi repetit.
- Actualitza un preu i mostra tot.

## 5) Exercici `TreeMap` — Estadístiques ordenades (rangs)

Volem guardar vendes per **data** (o per **mes**) i consultar rangs.

### Requisits
1. Fes servir `TreeMap<String, Integer>` (o `TreeMap<LocalDate, Integer>` si vols) per guardar:
   - clau: data (format `YYYY-MM-DD`) o mes (`YYYY-MM`)
   - valor: quantitat venuda
2. Crea una classe `EstadistiquesVendes` amb un `TreeMap` i mètodes:
   - `void registrarVenda(String data, int quantitat)` (acumula)
   - `int totalEntre(String dataInici, String dataFi)` (rang inclòs)
   - `String primeraData()` i `String ultimaData()`
   - `void mostrar()` (ha de sortir ordenat)

### Prova (`main`)
- Registra vendes de 8 dates (algunes repetides).
- Mostra primera i última data.
- Calcula el total entre dues dates.
- Mostra tot (comprova que surt ordenat).