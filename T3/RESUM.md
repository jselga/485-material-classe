# Resum Tema 3 - Java

Punts clau per a l'examen de Programació Orientada a Objectes.

> **Nota**: Aquest resum fa referència als fitxers de teoria originals. Consulta'ls per més detall.

---

## 1. Fonaments POO

📄 Fitxer: [teoria/01-t3-fonaments-poo-resum.md](./teoria/01-t3-fonaments-poo-resum.md)

- **Abstracció**: representar entitats del món real amb informació rellevant
- **Encapsulació**: ocultar detalls interns; atributs `private` + getters/setters
- **Herència**: crear classes a partir d'altres (relació "és un")
- **Polimorfisme**: mateix mètode, comportaments diferents (sobrecàrrega + sobreescriptura)
- **Modificadors d'accés**: `public`, `private`, `protected`, (paquet)
- **this**: referència a l'objecte actual
- **Constructors**: mateix nom que la classe, sense tipus de retorn

---

## 2. Herència

📄 Fitxer: [teoria/02-t3-herencia-poo-resum.md](./teoria/02-t3-herencia-poo-resum.md)

- `extends` per heretar
- `super()` per cridar constructor pare
- `@Override` per sobreescriure mètodes (obligatori si implementar mètode abstracte)
- Classes `abstract`: no instanciables, poden tenir mètodes abstractes
- Classes `final`: no es poden heretar
- Modificadors amb herència:
  - `private`: no accessible des de subclasse (cal getters)
  - `protected`: accessible des de subclasses
  - `public`: accessible des de qualsevol lloc

---

## 3. Col·leccions

📄 Fitxer: [teoria/03-t3-col·leccions.md](./teoria/03-t3-col·leccions.md)

### Taula comparativa

| Col·lecció | Duplicats | Ordre | Ús principal |
|------------|-----------|-------|---------------|
| **ArrayList** | Sí | Sí (índex) | Llistes, accés per posició |
| **HashSet** | No | No | Eliminar duplicats, cerca ràpida |
| **TreeSet** | No | Sí (compareTo) | Conjunt ordenat, rangs |
| **HashMap** | Claus úniques | No | Diccionari ràpid |
| **TreeMap** | Claus úniques | Sí (compareTo) | Diccionari ordenat |

### Punts clau

#### HashSet/HashMap
- Requereixen `equals()` i `hashCode()` coherents
- Si redefines `equals()`, cal redefinir `hashCode()`

#### TreeSet/TreeMap ⚠️ IMPORTANT
- **La classe de la clau (Key) ha d'implementar `Comparable`**
- Classes natives com `String` i `Integer` ja implementen `Comparable`
- Per objectes propis, cal:

```java
public class Alumne implements Comparable<Alumne> {
    private String nom;

    @Override
    public int compareTo(Alumne other) {
        return this.nom.compareTo(other.nom);
    }
}
```

- Si `compareTo()` retorna 0, es considera "duplicat" i no s'afegeix

#### ArrayList
- Només guarda objectes (no tipus primitius)
- Usa `ArrayList<Integer>`, no `ArrayList<int>`
- Inserir/eliminar al mig és inefficient

---

## 4. Excepcions

📄 Fitxer: [teoria/04-t3-excepcions-java-resum.md](./teoria/04-t3-excepcions-java-resum.md)

### Tipus d'excepcions

| Tipus | Exemple | Obligatori capturar? |
|-------|---------|----------------------|
| **RuntimeException** | NullPointerException, ArrayIndexOutOfBoundsException | No |
| **Checked Exception** | IOException, FileNotFoundException | Sí (try-catch o throws) |

### Estructura

```java
try {
    // codi que pot fallar
} catch (TipusExcepcio e) {
    // tractament
} finally {
    // sempre s'executa
}
```

### Conceptes clau

- **throw**: llançar una excepció manualment
- **throws**: delegar l'excepció al mètode superior
- **try-catch**: capturar i tractar l'excepció
- **finally**: codi que s'executa sempre (tancar recursos)

### Crear excepció pròpia

```java
public class ValidacioException extends Exception {
    public ValidacioException(String missatge) {
        super(missatge);
    }
}
```

---

## 5. Persistència (ObjectStream)

📄 Fitxer: [teoria/05-t3-persistencia-objectes-java-resum.md](./teoria/05-t3-persistencia-objectes-java-resum.md)

### Requisit indispensable

```java
public class Alumne implements Serializable {
    // ...
}
```

### Estructura bàsica

```java
// Escriure
ObjectOutputStream oos = new ObjectOutputStream(
    new FileOutputStream("alumnes.dat")
);
oos.writeObject(alumne);
oos.close();

// Llegir
ObjectInputStream ois = new ObjectInputStream(
    new FileInputStream("alumnes.dat")
);
Alumne a = (Alumne) ois.readObject();  // cal casting
ois.close();
```

### Problemes habituals

- Oblidar `Serializable` → `NotSerializableException`
- No fer cast → error de compilació
- Fitxer buit → `EOFException`

---

## Exercicis resolts

Troba els exercicis resolts a: `solucions/`

- `ExerciciHerencia1B/` - Herència bàsica
- `ExerciciHerencia2/` - Herència amb classes abstractes
- `ExercicisCollections/` - Col·leccions (ArrayList, HashSet, TreeSet, HashMap, TreeMap)
- `ExercicisExcepcions/` - Gestió d'excepcions
- `ExercicisFitxers/` - Persistència d'objectes

---

## Checklist'examen

- [ ] Encapsulació: private + getters/setters
- [ ] Herència: extends, super(), @Override
- [ ] Classes abstractes: implementar tots els mètodes abstractes
- [ ] Col·leccions: triar la correcta segons necessitat
- [ ] TreeSet/TreeMap: la Key ha d'implementar Comparable
- [ ] Excepcions: try-catch-finally, throws
- [ ] Serializable: implementat a les classes a guardar