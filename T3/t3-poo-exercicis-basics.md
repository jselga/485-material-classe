# Tema 3: Programació Orientada a Objectes i Llibreries

## Secció 1: Programació Orientada a Objectes (POO)

> **Objectiu**: 
> Aquests exercicis treballen de manera progressiva els **fonaments de la POO**: definició de classes, encapsulació, modificadors (`public`, `private`, `static`, `final`), interacció entre objectes i composició.\
> Els exercicis **estan enllaçats**: cal reaprofitar classes creades en exercicis anteriors quan s’indiqui explícitament.  
> Tots els exercicis han de tenir una classe Principal on hi hagi un mètode main per comprovar que tot funciona correctament.  
> Per una millor organització podeu crear un *package* per cada exercici. 
---
![alt text](image.png)
## Bloc A · Classes, encapsulació i sobrecàrrega

### Exercici 1 · Classe `Estudiant`

Crea una classe **Estudiant** que representi un alumne.

**Atributs:**

- `nom`
- `curs`
- `nota`

**Requisits:**

- Els atributs han de ser **privats**.
- Implementa:
  - Constructor
  - Getters i setters
  - Un mètode `mostrar()` que mostri **nom i curs**
  - Un mètode `mostrar(boolean ambNota)` que, si és `true`, mostri també la nota

Crea una classe `Principal` on:

- Es creï un estudiant
- Es modifiquin alguns atributs
- Es mostrin les dades amb i sense nota

---

### Exercici 2 · Classe `Llibre`

Crea una classe **Llibre**.

**Atributs:**

- `autor`
- `titol`
- `numPagines`
- `isbn`
- `prestat` (boolean)

**Requisits:**

- Atributs privats
- Constructor complet
- Getters i setters
- Mètode `dades()` que mostri tota la informació del llibre

Crea una classe `Principal` per comprovar el funcionament.

---

## Bloc B · Membres estàtics i constants

### Exercici 3 · Classe `Calculadora`

Crea una classe **Calculadora** amb mètodes `static` per realitzar:

- Suma
- Resta
- Multiplicació
- Divisió

No s’ha de crear cap objecte per utilitzar-la.

---

### Exercici 4 · Conversor de moneda

Crea una classe que permeti convertir:

- D’euros a dòlars
- De dòlars a euros

**Requisits:**

- Utilitza una constant `static final double E_TO_D = 1.20`
- Els mètodes han de ser estàtics

---

### Exercici 5 · Comptador d’estudiants

Modifica la classe **Estudiant** de l’exercici 1 per:

- Afegir un atribut estàtic que compti quants estudiants s’han creat
- Incrementar-lo cada vegada que s’executi el constructor

Mostra el nombre total d’estudiants creats des del `main`.

---

## Bloc C · Interacció entre objectes

### Exercici 6 · Classe `Professor`

Amplia l’exercici 1 afegint una classe **Professor**.

**Requisits:**

- Almenys 3 atributs (ex: nom, especialitat, departament)
- Getters i setters
- Un mètode que permeti **assignar una nota** a un objecte `Estudiant`

Demostra al `main` la interacció entre professor i estudiant.

---

### Exercici 7 · Vols i passatgers

Crea les classes següents:

**Passatger**

- `dni`, `nom`, `vol`

**Vol**

- `numeroVol`, `origen`, `desti`

**Agent**

- `dni`, `nom`
- Mètode que assigni un `Vol` a un `Passatger`

Crea un `Principal` per provar:

- Creació de vols
- Creació de passatgers
- Assignació de vols

---

### Exercici 8 · Biblioteca (nivell bàsic)

Amplia l’exercici 2 afegint:

**Classe** `Soci`:

- `dni`, `nom`, `llibre`
- Mètode que mostri el títol del llibre prestat o el missatge:
  > "No ha agafat cap llibre"

**Classe** `Bibliotecari`:

- `dni`, `nom`
- Mètode `prestec(Soci, Llibre)`

Crea un `main` per provar els préstecs.

---

## Bloc D · Composició i col·leccions

### Exercici 9 · Bloc de notes

Crea una classe **BlocNotes** que gestioni notes de text.

**Requisits:**

- Les notes són `String`
- Utilitza un `ArrayList<String>`
- Implementa:
  - `afegirNota(String nota)`
  - `numeroNotes()`
  - `llistatNotes()`

---

### Exercici 10 · Classe `Curs`

Amplia l’exercici 1 afegint una classe **Curs**.

**Atributs:**

- `nomCurs`
- `llistaEstudiants` (ArrayList)

**Funcionalitats:**

- Afegir estudiant
- Eliminar estudiant
- Cercar estudiant pel nom
- Mostrar el llistat complet

---

### Exercici 11 · Classe `Biblioteca` (nivell avançat)

Amplia l’exercici 8 creant una classe **Biblioteca** amb:

- Llista de socis
- Llista de llibres

Per a **cada funcionalitat** crea **dos mètodes** (per exemple: per objecte i per identificador):

- Afegir
- Eliminar
- Cercar
- Mostrar

---

### Exercici 12 · Gestió d’empresa

Crea una classe **Empresa** que permeti gestionar treballadors.

**Treballador:**

- `dni`, `nom`, `adreca`, `souMensual`

**Funcionalitats de l’empresa:**

- Donar d’alta un treballador
- Donar de baixa (pel DNI)
- Mostrar dades d’un treballador
- Mostrar tots els treballadors
- Calcular despeses mensuals
- Assignar sou
- Mostrar el nombre total de treballadors

Aplica correctament els principis de la **POO**.

---
