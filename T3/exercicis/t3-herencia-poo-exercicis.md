# Exercicis · Herència en Java

---

# 1 · Empresa (Classe abstracta base comuna)

## Objectiu
Modelar una empresa que gestiona **Treballadors** i **Clients** utilitzant una classe abstracta comuna `Persona`.

---

## 1.1 Classe abstracta `Persona`

### Atributs mínims
- `id` (int)
- `nom` (String)
- `cognoms` (String)
- `dni` (String)
- `telefon` (String)

### Requisits
- Ha de ser `abstract`
- Constructor amb els camps principals
- Getters i setters
- `toString()` amb la informació comuna
- Mètode abstracte:

```java
public abstract String getTipus();
```

---

## 1.2 Classe `Treballador` (extends Persona)

### Atributs
- `departament` (String)
- `salariAnual` (double)
- `dataAlta` (LocalDate o String)
- `codiEmpleat` (String)

### Requisits
- Constructor amb `super(...)`
- Getters i setters propis
- Sobreescriure:
  - `getTipus()` → retorna "Treballador"
  - `toString()` → afegeix informació pròpia

---

## 1.3 Classe `Client` (extends Persona)

### Atributs
- `email` (String)
- `categoria` (String)
- `dataAltaClient` (LocalDate o String)
- `totalComprat` (double)

### Requisits
- Constructor amb `super(...)`
- Getters i setters propis
- Sobreescriure:
  - `getTipus()` → retorna "Client"
  - `toString()` → afegeix informació pròpia

---

## 1.4 Classe `Empresa`

### Atributs
- `nom`
- `cif`
- `adreca`
- `ArrayList<Treballador>`
- `ArrayList<Client>`

### Funcionalitats
- Afegir / cercar / eliminar treballadors
- Afegir / cercar / eliminar clients
- `mostrar()` que imprimeixi:

```
Empresa: Nom (CIF: ...)
--- TREBALLADORS (n) ---
...
--- CLIENTS (m) ---
...
```

---

## Execució mínima
- Crear 1 Empresa
- Crear 2 Treballadors
- Crear 2 Clients
- Afegir-los
- Cridar `empresa.mostrar()`

---

# 2 · Articles en venda (Override sense abstract)

## Objectiu
Practicar herència amb mètodes **sobreescrits** que calculin imports diferents segons el tipus d’article.

---

## Classe base `Article`

### Atributs
- `codi`
- `nom`
- `preuBase`

### Mètodes
- Constructor
- Getters
- `double calcularPreuFinal()`

>Aquest mètode **NO és abstracte**. Per defecte retorna `preuBase`.

---

## Subclasses

### `ArticleAlimentacio`
- Afegeix `percentatgeIVA`
- Sobreescriu `calcularPreuFinal()` aplicant IVA

### `ArticleElectronic`
- Afegeix `garantiaMesos`
- Sobreescriu `calcularPreuFinal()` aplicant IVA + recàrrec electrònic

### `ArticleRoba`
- Afegeix `temporada`
- Sobreescriu `calcularPreuFinal()` aplicant descompte segons temporada (p.e. si està fora de temporada té un descompte del 10%)

---

## Requisits
- Crear diversos articles de cada tipus
- Guardar-los en una `ArrayList<Article>`
- Recórrer la llista i mostrar el preu final de cadascun

>Aquí es treballa **polimorfisme real sense abstract**.

---


