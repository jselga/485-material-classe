# Projecte Tema 3: Ludoteca digital

## Descripció

Una ludoteca vol començar a digitalitzar part del seu catàleg amb una aplicació feta en **Java** i executada per **consola**.

L'objectiu és disposar d'un programa senzill que permeti gestionar diferents recursos de la ludoteca, guardar la informació en fitxer i recuperar-la més endavant.

---

## Objectiu general

Has de desenvolupar una aplicació de consola que permeti gestionar una col·lecció de recursos d'una ludoteca.

L'aplicació ha de permetre treballar amb:

- diferents tipus de recursos
- una estructura principal per emmagatzemar-los
- un conjunt d'etiquetes per a cada recurs
- operacions CRUD (Create Read Update Delete)
- persistència d'objectes en fitxer
- control d'excepcions bàsic

---

## Recursos de la Ludoteca

El programa ha de gestionar **com a mínim dos tipus de recursos**:

- **Videojoc**
- **Joc de taula**

Tots dos comparteixen una informació comuna, però cadascun també ha de tenir dades específiques.

### Informació comuna mínima

Cada recurs ha de tenir com a mínim:

- codi
- títol
- any
- disponibilitat
- conjunt d'etiquetes

### Informació específica

Cada subtipus ha d'afegir informació pròpia.

Per exemple:

#### Videojoc

- plataforma
- PEGI

#### Joc de taula

- nombre mínim de jugadors
- nombre màxim de jugadors
- durada aproximada

> No es tracta només de guardar dades: has de modelar correctament el problema amb classes.

---

## Requisits obligatoris

### 1. Herència

### 2. Estructura principal amb `Map`

Els recursos s'han d'emmagatzemar en una estructura basada en `Map`.
Aquesta estructura serà la base del CRUD.

Has de decidir com aplicar-la i com organitzar la classe que la gestiona.

---

### 3. Ús d'un `Set` amb una classe pròpia

Cada recurs ha de tenir un conjunt d'etiquetes.

Per a aquesta pràctica:

- les etiquetes **no** s'han de representar amb `String`
- cal crear una **classe pròpia** per representar una etiqueta
- aquesta classe ha d'implementar un criteri d'ordre natural

Això implica que hauràs de pensar:

- quins atributs té una etiqueta
- quin ordre natural tindrà
- com evitar duplicats
- com mostrar-les

> L'objectiu és aplicar correctament `Set` sobre una classe del domini i no sobre tipus simples.

---

### 4. CRUD funcional

L'aplicació ha de permetre fer, com a mínim, aquestes operacions:

- afegir un videojoc
- afegir un joc de taula
- mostrar tots els recursos
- cercar un recurs a partir del seu codi
- modificar alguna dada d'un recurs existent
- eliminar un recurs

A més, hi ha d'haver almenys una operació relacionada amb les etiquetes.

Per exemple:

- afegir una etiqueta a un recurs
- mostrar les etiquetes d'un recurs
- cercar recursos per una etiqueta concreta

---

### 5. Persistència d'objectes

El programa ha de poder:

- guardar la informació en fitxer
- carregar la informació des del fitxer

La persistència ha de ser amb **objectes**, no en text pla.

Per tant, hauràs de decidir:

- quines classes han de ser serialitzables
- què es guarda exactament
- des d'on es fa el procés de guardar i carregar

---

### 6. Excepcions

Has de gestionar situacions d'error habituals del programa.

Com a mínim, cal controlar casos com:

- codis repetits
- cerca d'un element inexistent
- problemes en carregar o guardar el fitxer

No n'hi ha prou amb deixar que el programa falli.

Cal mostrar missatges clars i evitar que l'aplicació es tanqui de manera brusca.

---

## Funcionament mínim esperat

L'aplicació ha de tenir un menú per consola amb opcions semblants a aquestes:

```text
--- LUDOTECA DIGITAL ---
1. Afegir videojoc
2. Afegir joc de taula
3. Mostrar tots els recursos
4. Cercar recurs per codi
5. Modificar recurs
6. Afegir etiqueta a un recurs
7. Eliminar recurs
8. Cercar recursos per etiqueta
9. Guardar dades
10. Carregar dades
11. Sortir
```

L'ordre exacte pot variar, però aquestes funcionalitats mínimes hi han de ser.

---

## Sortides esperades

No es demana una sortida única exacta, però el programa ha de ser clar i entenedor.

### Exemple: alta d'un recurs

```text
Opció: 1
Introdueix el codi: V001
Introdueix el títol: Zelda Breath of the Wild
Introdueix l'any: 2017
Disponible? (true/false): true
Introdueix la plataforma: Switch
Introdueix el PEGI: 12

Recurs afegit correctament.
```

### Exemple: mostrar recursos

```text
--- LLISTAT DE RECURSOS ---
[V001] Zelda Breath of the Wild - 2017 - Disponible
Tipus: Videojoc
Plataforma: Switch
PEGI: 12
Etiquetes: aventura, món obert
```

```text
[J003] Catan - 1995 - Disponible
Tipus: Joc de taula
Jugadors: 3-4
Durada: 90 minuts
Etiquetes: estratègia, familiar
```

### Exemple: error

```text
Error: ja existeix un recurs amb aquest codi.
```



---






## Què s'entregarà

L'entrega ha d'incloure:

- el projecte complet
- totes les classes necessàries
- el codi font funcional
- un `main` amb menú per interactuar amb l'aplicació
- un altre `main` o una prova equivalent per comprovar directament les opcions principals de la classe gestora sense passar pel menú

---
