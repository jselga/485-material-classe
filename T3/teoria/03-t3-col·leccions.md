# Tema 3: Programació Orientada a Objectes i Llibreries

## Secció 3: Col·leccions a Java
# ArrayList

`ArrayList<E>` és una implementació de `List<E>` basada en un **array redimensionable**. És la llista més usada a Java.

## Característiques

### 1) Manté ordre i permet duplicats
- Els elements es guarden en l’ordre en què queden dins la llista (posicions 0..n-1).
- Pots tenir elements repetits.

### 2) Accés per índex molt ràpid
- Pots fer `get(i)` i `set(i, valor)` de forma eficient.

### 3) Mida dinàmica
- Creix automàticament quan afegeixes elements (`add`).
- Internament, quan es queda sense espai, crea un array més gran i copia elements (això passa de tant en tant).

### 4) Inserir o esborrar al mig és poc eficient
- `add(index, element)` o `remove(index)` al mig implica **moure** (desplaçar) molts elements.
- Al final, `add(element)` sol ser ràpid (amortitzat **O(1)**).

### 5) Només pot guardar objectes (no tipus primitius)
- `ArrayList<int>` no existeix.
- Exemples: `ArrayList<Integer>`, `ArrayList<Double>`.

## Funcionalitats (mètodes més útils)

### Afegir
- `add(e)` → afegeix al final
- `add(index, e)` → insereix a una posició
- `addAll(col)` / `addAll(index, col)` → afegeix una col·lecció sencera

### Consultar
- `get(index)` → retorna l’element
- `size()` → nombre d’elements
- `isEmpty()` → buida o no
- `contains(e)` → si hi és (usa `equals`)
- `indexOf(e)` / `lastIndexOf(e)` → posició del primer/últim

### Modificar
- `set(index, e)` → substitueix l’element en aquella posició

### Eliminar
- `remove(index)` → elimina per posició
- `remove(objecte)` → elimina la primera coincidència (per `equals`)
- `clear()` → elimina tots

### Recórrer
- `for-each`
- `for` amb índex
- `iterator()` / `listIterator()` (útil per eliminar mentre recorres)

### Ordenar
- `list.sort(comparator)`
- `Collections.sort(list)` (si els elements són `Comparable`)

## Quan és la millor opció?
- Quan necessites una llista **general**, amb **consultes per índex** freqüents, i **moltes insercions al final**.
- És la “default” en molts projectes.

---


# HashSet i TreeSet: característiques i funcionalitats principals

## 1) HashSet

### Què és?
`HashSet<E>` és una implementació de `Set<E>` basada en una **taula hash**. Serveix per guardar elements **sense duplicats** i amb operacions molt ràpides.

### Característiques clau
- **No permet duplicats** (dos elements “iguals” segons `equals()` no poden coexistir).
- **No garanteix cap ordre** en iterar (pot canviar).
- Operacions típiques **molt ràpides** en mitjana: `add`, `remove`, `contains`.

> Important: perquè funcioni bé, els objectes han de tenir `equals()` i `hashCode()` ben implementats i coherents.

### Funcionalitats (mètodes més útils)
- `add(e)` → afegeix si no hi era
- `contains(e)` → comprova si hi és
- `remove(e)` → elimina si existeix
- `size()`, `isEmpty()`, `clear()`
- `iterator()` / `for-each` per recórrer

### Quan és ideal?
- Quan vols **evitar duplicats** i **no t’importa l’ordre**.
- Quan necessites fer molts `contains()` ràpids.

---

## 2) TreeSet

### Què és?
`TreeSet<E>` és una implementació de `Set<E>` basada en un **arbre ordenat**. Manté els elements **ordenats** sempre.

### Característiques clau
- **No permet duplicats**.
- **Manté els elements ordenats** automàticament (segons l’ordre: `compareTo`/`compare` considera “igual” quan retorna 0).
- Operacions típiques: `add`, `remove`, `contains` (més lent que `HashSet`, però amb ordre).

### Quan és ideal?
- Quan necessites el conjunt **sempre ordenat**.
- Quan necessites consultar **rangs** (per exemple, tots els valors entre A i B).

## Diferència ràpida (cheet sheet) 
- **HashSet**: ràpid, sense ordre.
- **TreeSet**: ordenat, permet rangs, una mica més lent.

---
# HashMap i TreeMap: característiques i funcionalitats principals

## 1) HashMap

### Què és?
`HashMap<K,V>` és una implementació de `Map<K,V>` basada en **taula hash** (hash table). Guarda parelles **clau → valor**.

### Característiques clau
- **Accés molt ràpid** en mitjana per `put`, `get`, `containsKey`, `remove` (habitualment **O(1)**).
- **No garanteix cap ordre** quan iteres (l’ordre pot variar).
- **Claus úniques**: si fas `put` amb una clau que ja existeix, **sobreescriu** el valor anterior.
- **Permet 1 clau `null`** i molts valors `null` (a `HashMap`).
- La igualtat de claus es decideix amb **`equals()`** i la posició amb **`hashCode()`** → han d’estar ben implementats.

### Mètodes típics
- `put(k, v)` / `putIfAbsent(k, v)`
- `get(k)` / `getOrDefault(k, valorDefecte)`
- `containsKey(k)` / `containsValue(v)`
- `remove(k)` / `remove(k, v)`
- `keySet()` (claus), `values()` (valors), `entrySet()` (parelles)
- `size()`, `isEmpty()`, `clear()`

### Quan és ideal?
- Quan vols un “diccionari” **ràpid** i **no necessites ordre**.

---

## 2) TreeMap

### Què és?
`TreeMap<K,V>` és un `Map<K,V>` basat en un **arbre ordenat**. Manté les **claus ordenades** sempre.

### Característiques clau
- Les claus queden **ordenades automàticament** (ordre natural o `Comparator`).
- Operacions típiques `put/get/remove/containsKey` són **O(log n)** (normalment més lent que `HashMap`, però amb ordre).
- La igualtat de claus aquí depèn del **comparador**: si `compare(a,b) == 0`, es considera la mateixa clau.
- **No permet clau `null`** (perquè no es pot comparar).
- Molt útil per **rangs** i consultes “d’ordre”.

### Com decideix l’ordre?
- Si `K` implementa `Comparable<K>` → usa `compareTo`.
- O li passes un `Comparator<K>`.

### Quan és ideal?
- Quan necessites el map **ordenat per clau**.
- Quan necessites fer **consultes per rang** (ex.: totes les claus entre A i M).

## Diferència ràpida (cheet sheet)
- **HashMap**: més ràpid, **sense ordre**.
- **TreeMap**: una mica més lent, **claus ordenades** i **rangs**.

---
