# Tema 3: Programació Orientada a Objectes i Llibreries

## Secció 5: Persistència d’objectes en Java (ObjectStream)

## Idea clau

La persistència permet **guardar objectes a disc** i recuperar-los posteriorment.

En Java ho fem habitualment amb:

- `ObjectOutputStream` → escriure objectes
- `ObjectInputStream` → llegir objectes

---

## 1. Requisit imprescindible: Serializable

Per poder guardar un objecte, la classe ha d’implementar:

```java
implements Serializable
```

Exemple:

```java
import java.io.Serializable;

public class Alumne implements Serializable {
    private String nom;
    private int edat;
}
```

> Si no ho fem, obtindrem una excepció: `NotSerializableException`

---

## 2. Escriure objectes a fitxer

### Estructura bàsica

```java
ObjectOutputStream oos = new ObjectOutputStream(
    new FileOutputStream("alumnes.dat")
);

oos.writeObject(alumne);
oos.close();
```

> Això serialitza l’objecte i el guarda al fitxer.

---

## 3. Llegir objectes d’un fitxer

```java
ObjectInputStream ois = new ObjectInputStream(
    new FileInputStream("alumnes.dat")
);

Alumne a = (Alumne) ois.readObject();
ois.close();
```

> Cal fer **casting**, ja que `readObject()` retorna `Object`.

---

## 4. Guardar col·leccions d’objectes

És molt habitual guardar una llista sencera:

```java
ArrayList<Alumne> alumnes = new ArrayList<>();

// guardar
 oos.writeObject(alumnes);

// recuperar
ArrayList<Alumne> recuperats = (ArrayList<Alumne>) ois.readObject();
```

> Molt útil per treballar amb dades reals.

---

## 5. Gestió d’excepcions

Quan treballem amb fitxers, apareixen checked exceptions:

- `IOException`
- `ClassNotFoundException`

Exemple típic:

```java
try {
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("alumnes.dat"));
    ArrayList<Alumne> llista = (ArrayList<Alumne>) ois.readObject();
    ois.close();
} catch (IOException | ClassNotFoundException e) {
    System.out.println("Error en la lectura del fitxer");
}
```

---

## 6. Sobreescriptura del fitxer

Cada cop que escrivim amb `FileOutputStream`, el fitxer es **sobreescriu**.

> Si volem afegir informació, caldria una gestió més avançada.

---

## 7. Problemes habituals

### ❌ Oblidar Serializable
→ `NotSerializableException`

### ❌ No fer cast
→ error de compilació

### ❌ Llegir un fitxer buit
→ `EOFException`

### ❌ No tancar streams
→ problemes de recursos

---

## 8. Idea didàctica important

- No estem guardant "text" sinó **objectes complets**
- Java s’encarrega de convertir-los a bytes (serialització)
- I de reconstruir-los després (deserialització)

---

## 9. Estructura típica de projecte

- Classe model (`Alumne`)
- Classe gestora (`GestorAlumnes`)
- Classe principal (`Main`)

---

## 10. Resum

- Implementar `Serializable`
- Escriure amb `ObjectOutputStream`
- Llegir amb `ObjectInputStream`
- Gestionar excepcions
- Ús habitual amb col·leccions

---
