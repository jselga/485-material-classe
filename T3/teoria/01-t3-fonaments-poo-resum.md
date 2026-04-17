
# Tema 3: Programació Orientada a Objectes i Llibreries

- [Secció 1: Programació Orientada a Objectes (POO)](#secció-1-programació-orientada-a-objectes-poo)
  - [Introducció](#introducció)
- [Característiques de la POO](#característiques-de-la-poo)
  - [Abstracció](#abstracció)
  - [Encapsulació (i ocultació)](#encapsulació-i-ocultació)
  - [Herència](#herència)
  - [Polimorfisme](#polimorfisme)
- [Classes i Objectes](#classes-i-objectes)
- [Atributs i Mètodes](#atributs-i-mètodes)
  - [D’instància](#dinstància)
  - [De classe (estàtics)](#de-classe-estàtics)
- [Modificadors d’accés](#modificadors-daccés)
- [La clàusula `this`](#la-clàusula-this)
- [Constructors](#constructors)
- [Getters i Setters](#getters-i-setters)
- [Polimorfisme: sobrecàrrega de mètodes](#polimorfisme-sobrecàrrega-de-mètodes)
## Secció 1: Programació Orientada a Objectes (POO)

### Introducció

La **programació orientada a objectes (POO)** entén un programa com una **simulació del món real**. Aquest món està format per **objectes** que interactuen entre ells per resoldre un problema concret.

Cada objecte té:

- **Estat** → representat pels **atributs**
- **Comportament** → definit pels **mètodes**

Els principis bàsics comuns a tots els llenguatges orientats a objectes són:

- Un programa és un conjunt d’objectes que **interactuen**.
- Tot és un **objecte**, amb una identitat pròpia.
- Un objecte pot estar format per altres objectes (**composició**).
- Cada objecte pertany a una **classe**.
- Els objectes de la mateixa classe comparteixen comportament.

---

## Característiques de la POO

### Abstracció

Els objectes representen entitats del món real, quedant-nos només amb la informació rellevant.

### Encapsulació (i ocultació)

Cada objecte encapsula dades i mètodes. Els detalls interns poden quedar ocults a l’exterior.

### Herència

Permet definir noves classes a partir d’altres ja existents.

### Polimorfisme

Un mateix mètode pot tenir **comportaments diferents** segons el context o els paràmetres.

---

## Classes i Objectes

Una **classe** és una plantilla que defineix:

- Atributs (propietats)
- Mètodes (comportament)

Un **objecte** és una instància concreta d’una classe creada amb l’operador `new`.

```java
public class Vehicle {
    String model;
    int velocitat;

    public void mostra() {
        System.out.printf("%s: %d\n", model, velocitat);
    }
}

Vehicle c1 = new Vehicle();
c1.model = "Ford Focus";
c1.velocitat = 100;
c1.mostra();
```

---

## Atributs i Mètodes

Els membres d’una classe poden ser:

### D’instància

- Cada objecte té la seva pròpia còpia.
- Defineixen l’estat de l’objecte.

### De classe (estàtics)

- Es comparteixen entre tots els objectes.
- No cal instanciar la classe per accedir-hi.

```java
public static final int VEL_MAX = 200;
```

---

## Modificadors d’accés

Controlen la visibilitat dels membres:

- `public` → accessible des de qualsevol lloc
- `private` → només dins la mateixa classe
- `protected` → mateix paquet o subclasses
- *(sense modificador)* → mateix paquet

També es pot usar `final` per evitar modificacions.

---

## La clàusula `this`

La paraula clau `this` fa referència a l’**objecte actual**.

S’utilitza especialment en constructors quan els paràmetres tenen el mateix nom que els atributs.

```java
this.model = model;
```

---

## Constructors

Els **constructors** són mètodes especials que creen i inicialitzen objectes.

Característiques:

- Tenen el mateix nom que la classe
- No tenen tipus de retorn
- S’executen amb `new`

```java
public Vehicle(String model, int velocitat) {
    this.model = model;
    this.velocitat = velocitat;
}
```

---

## Getters i Setters

Per aplicar el principi d’encapsulació, els atributs solen ser **privats**.

Els **getters** i **setters** permeten:

- Accedir a l’estat de l’objecte
- Controlar i validar les modificacions

```java
public int getVelocitat() {
    return velocitat;
}

public void setVelocitat(int velocitat) {
    this.velocitat = velocitat;
}
```

---

## Polimorfisme: sobrecàrrega de mètodes

La **sobrecàrrega** permet definir diversos mètodes amb el mateix nom però diferents paràmetres.

Normes:

- Mateix nom
- Signatura diferent
- El tipus de retorn pot variar

```java
public void mostra() {
    System.out.println(model + ": " + velocitat);
}

public void mostra(boolean detall) {
    if (detall) {
        System.out.println("Model: " + model);
        System.out.println("Velocitat: " + velocitat);
    } else {
        mostra();
    }
}
```
---


