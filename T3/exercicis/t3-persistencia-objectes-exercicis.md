# Exercicis Persistència d'Objectes en Java
## Exercici 1. Guardar i carregar un ArrayList des del `main`

### Enunciat

Crea un programa senzill que faci el següent:

1. Crea un `ArrayList<String>` amb almenys 4 valors.
2. Guarda la llista en un fitxer amb `ObjectOutputStream`.
3. Llegeix la llista del fitxer amb `ObjectInputStream`.
4. Mostra per pantalla els valors recuperats.

### Requisits

- Tot s’ha de fer des del `main()`.
- El fitxer pot dir-se, per exemple, `dades.dat`.
- Has de gestionar les excepcions necessàries.
- Cal mostrar un missatge quan s’hagi guardat correctament.
- Cal mostrar un missatge quan s’hagi carregat correctament.

### Pista

```java
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dades.dat"));
oos.writeObject(llista);
oos.close();
```

### Què es treballa aquí

- `ObjectOutputStream`
- `ObjectInputStream`
- `ArrayList`
- `try-catch`
- casting amb `readObject()`

---

## Exercici 2. Model + gestor + persistència

### Enunciat

Crea una petita aplicació amb aquestes tres peces:

- una classe **model**
- una classe **gestora**
- una classe **Main**

Pots fer servir la temàtica que vulguis. Per exemple:

- `Material`
- `Producte`
- `Monstre`
- `Llibre`

### Funcionament mínim

#### Classe model
La classe model ha de:

- tenir com a mínim 2 atributs
- implementar `Serializable`
- tenir constructor
- tenir `toString()`

#### Classe gestora
La classe gestora ha de tenir:

- un `ArrayList` d’objectes
- un mètode `afegir(...)`
- un mètode `mostrar()`
- un mètode `guardar()`
- un mètode `carregar()`

#### Main
Des del `main()` has de:

1. Crear un gestor
2. Afegir almenys 3 objectes
3. Guardar-los en un fitxer
4. Crear un segon gestor buit
5. Carregar el fitxer
6. Mostrar el contingut recuperat



---
