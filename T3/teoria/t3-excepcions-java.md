# Tema 3: Programació Orientada a Objectes i Llibreries

## Secció 4: Execepcions en Java

## Idea clau

Una **excepció** és un error o situació inesperada que es produeix durant l'execució del programa.

És interessant distingir dues idees:

- **detectar què ha passat**
- **decidir si ho capturem o ho deleguem**

---

## 1. Què és una excepció?

Quan el programa troba una situació incorrecta, Java pot:

- **llençar** una excepció (`throw`)
- **propagar-la** cap amunt per la pila de crides (`stack trace`)
- **capturar-la** amb `try-catch`

Exemple senzill:

```java
String[] paraules = {"Hola", "Adeu", "Fins dema"};
System.out.println(paraules[3]);
```

Aquí es produeix una `ArrayIndexOutOfBoundsException`, perquè la darrera posició vàlida és la `2`.

---

## 2. RuntimeException vs checked exceptions

### RuntimeException

Són errors que normalment indiquen un **problema de programació**.
No és obligatori capturar-los.

Exemples típics:

- `ArrayIndexOutOfBoundsException`
- `NullPointerException`
- `ArithmeticException`

Petit exemple:

```java
int[] numeros = {1, 2, 3};
System.out.println(numeros[5]);
```

### Checked exceptions

Són excepcions de **gestió obligatòria**.
El compilador obliga a:

- capturar-les amb `try-catch`, o bé
- delegar-les amb `throws`

Exemple típic relacionat amb fitxers:

```java
FileOutputStream fitxer = new FileOutputStream("sortida.txt");
fitxer.close();
```

Aquí poden aparèixer excepcions com `FileNotFoundException` o `IOException`.

---

## 3. Estructura bàsica: try-catch-finally

```java
try {
    // codi que pot fallar
} catch (TipusExcepcio e) {
    // tractament de l'error
} finally {
    // codi que s'executa sempre
}
```

### `try`
Conté el codi que pot generar l'error.

### `catch`
Captura una excepció concreta.

### `finally`
S'executa sempre, hi hagi excepció o no.
És útil per tancar recursos o mostrar missatges finals.

---

## 4. Capturar o delegar?

### Capturar
Quan el mètode sap què fer amb l'error.

```java
try {
    servei.crearFitxerBuit("sortida.txt");
} catch (IOException e) {
    System.out.println("No s'ha pogut crear el fitxer.");
}
```

### Delegar
Quan el mètode no resol el problema i el passa al mètode superior.

```java
public void crearFitxerBuit(String nomFitxer) throws IOException {
    FileOutputStream fitxer = new FileOutputStream(nomFitxer);
    fitxer.close();
}
```

---

## 5. Propagació d'excepcions

Si un mètode no captura l'excepció, aquesta puja al mètode que l'ha cridat.

```java
public static void met01() {
    met02();
}

public static void met02() {
    String[] dades = {"A", "B"};
    System.out.println(dades[2]);
}
```

Si `met02()` falla i no hi ha `catch`, l'error puja a `met01()` i després a `main()`.

---

## 6. Informació útil d'una excepció

Quan capturem una excepció, l'objecte `e` ens dona informació valuosa.

```java
catch (ArrayIndexOutOfBoundsException e) {
    System.out.println(e.getMessage());
    System.out.println(e.toString());
    e.printStackTrace();
}
```

### Mètodes habituals

- `getMessage()` → missatge concret
- `toString()` → tipus + missatge
- `printStackTrace()` → rastre complet de l'error (el que ens sol sortir quan un programa falla i no hem capturat cap excepció)
#### Exemple Stack Trace
```bash
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at exemplesexcepcions.Exemple01_NoCapturada.main(Exemple01_NoCapturada.java:10)
/home/jordi/snap/netbeans/common/142/executor-snippets/run.xml:111: The following error occurred while executing this line:
/home/jordi/snap/netbeans/common/142/executor-snippets/run.xml:68: Java returned: 1
```  

---

## 7. Llançar excepcions amb `throw`

Podem decidir que un mètode llanci una excepció si es compleix una condició incorrecta.

### Exemple checked

```java
public static void verificarLongitud(String[] dades, int esperada) throws Exception {
    if (dades.length != esperada) {
        throw new Exception("Longitud incorrecta");
    }
}
```

### Exemple runtime

```java
public static void verificarLongitud(String[] dades, int esperada) {
    if (dades.length != esperada) {
        throw new RuntimeException("Longitud incorrecta");
    }
}
```

---

## 8. Crear excepcions pròpies

Quan volem donar més significat al domini del problema, podem crear una excepció personalitzada.

```java
public class ValidacioException extends Exception {
    public ValidacioException(String missatge) {
        super(missatge);
    }
}
```

I usar-la així:

```java
if (edat < 0) {
    throw new ValidacioException("L'edat no pot ser negativa");
}
```

Això és molt útil quan el missatge d'error ha de ser més proper al problema real de l'aplicació.

---

## 9. Idees a tenir en compte

### Error de programació
Quan el problema no hauria d'haver passat mai si el codi estava ben fet.

Exemple:

```java
for (int i = 0; i <= array.length; i++) {
    System.out.println(array[i]);
}
```

El problema és el `<=` en comptes de `<`.

### El `catch` ha de correspondre amb l'excepció real

```java
catch (StringIndexOutOfBoundsException e)
```

Això **no captura** una `ArrayIndexOutOfBoundsException`.

### `finally` no evita l'error
`finally` s'executa, però si l'excepció no queda capturada correctament, el programa igualment acaba petant.

---

## 10. Resum

- Una excepció és un error en temps d'execució.
- Les `RuntimeException` solen indicar errors de programació.
- Les checked exceptions s'han de **capturar o delegar**.
- `try-catch-finally` permet tractar errors i assegurar codi final.
- `throw` serveix per llançar excepcions.
- `throws` serveix per delegar-les.
- Es poden crear excepcions pròpies per donar més significat al problema.

---
## 11. Exemples

1. [Exemple no capturat](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple01_NoCapturada.java)
2. [Exemple capturat](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple02_Capturada.java)
3. [Exemple amb `finally`](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple03_CatchIncorrecteIFinally.java)
4. [Propagació](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple04_PropagacioFinsMain.java)
5. [Captura en mètode superior](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple05_CapturaEnMetodeSuperior.java)
6. [Informació de l'excepció](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple06_InfoExcepcio.java)
7. [Checked exceptions de fitxers](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple07_CheckedSenseGestionar.java)
8. Delegació amb `throws`
   1. [No gestionada](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple08_Prova1_NoCompila.java)
   2. [Gestió parcial](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple08_Prova2_GestioParcial.java)
   3. [Gestió completa](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple08_Prova3_GestioCompleta.java)
9.  [`throw` amb checked](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple09_ThrowsChecked.java)
10. [`throw` amb runtime](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple10_ThrowsRuntime.java)
11. [Excepció personalitzada](../exemples/ExemplesExcepcions/src/exemplesexcepcions/Exemple11_ExcepcioPersonalitzada.java)




