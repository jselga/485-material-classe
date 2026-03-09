# Tema 3: Programació Orientada a Objectes i Llibreries

## Secció 2: Herència en Java

### Introducció

L’**herència** és un mecanisme de la POO que permet crear una classe nova a partir d’una altra classe existent.

La classe nova **hereta atributs i mètodes** de la classe pare i pot:

- Afegir nou comportament
- Modificar comportament existent

Terminologia:

- **Superclasse** (classe pare o classe base)
- **Subclasse** (classe filla o classe derivada)

En Java, l’herència s’implementa amb la paraula clau `extends`.

---

### 1. Per què serveix l’herència?

- **Reutilització de codi**: evitar duplicacions
- **Organització jeràrquica** del model
- Permet aplicar millor el **polimorfisme**

---

### 2. Exemple bàsic amb `extends`

```java
class Animal {
    private String nom;

    public Animal(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void ferSo() {
        System.out.println("So d'animal");
    }
}

class Gos extends Animal {

    public Gos(String nom) {
        super(nom); // crida al constructor del pare
    }

    @Override
    public void ferSo() {
        System.out.println("Bup bup!");
    }
}

public class Main {
    public static void main(String[] args) {
        Gos g = new Gos("Rex");

        System.out.println(g.getNom()); // mètode heretat
        g.ferSo();                      // mètode sobreescrit
    }
}
```

En aquest exemple:

- `Gos` **hereta** de `Animal`
- Utilitza `super()` per cridar el constructor del pare
- Sobreescriu el mètode `ferSo()`

---

### 3. La paraula clau `super`

Serveix per accedir a elements de la classe pare.

#### Cridar el constructor del pare

```java
super(nom);
```

#### Cridar un mètode del pare (si està sobreescrit)

```java
super.ferSo();
```

---

### 4. Sobreescriptura de mètodes (`@Override`)

Quan una subclasse defineix un mètode amb el **mateix nom i mateixa signatura** que el de la superclasse, està fent **override**.

És recomanable utilitzar l’anotació `@Override` perquè:

- El compilador detecta errors
- Millora la llegibilitat del codi

```java
@Override
public void ferSo() {
    System.out.println("Bup bup!");
}
```

---

### 5. Modificadors i herència

- `private` → No accessible directament des de la subclasse. **Només** accessible dins la mateixa classe
- `protected` → Accessible des de **subclasses**
- `public` → Accessible des de qualsevol lloc

Tot i que hi hagi herència, és habitual mantenir atributs `private` i exposar-los amb getters/setters.

---

### 6. `final` i herència

- Una classe `final` **no es pot heretar**
- Un mètode `final` **no es pot sobreescriure**

```java
final class Utilitats {
}
```

---

### 7. Classes abstractes

Una classe `abstract`:

- No es pot instanciar
- Serveix com a base comuna
- Pot contenir mètodes abstractes (sense implementació)

```java
abstract class Figura {

    public abstract double area();
}

class Quadrat extends Figura {

    private double costat;

    public Quadrat(double costat) {
        this.costat = costat;
    }

    @Override
    public double area() {
        return costat * costat;
    }
}
class Cercle extends Figura {

    private double radi;

    public Quadrat(double radi) {
        this.radi = radi;
    }

    @Override
    public double area() {
        return Math.PI *radi * radi;
    }
}
```

Les subclasses estan obligades a implementar els mètodes abstractes.

---

### Idees clau sobre herència

- L’herència expressa una relació **"és un"** (Gos és un Animal)
- No s’ha d’utilitzar per reutilitzar codi sense sentit conceptual
- Facilita el polimorfisme
- Cal mantenir encapsulació encara que hi hagi herència


