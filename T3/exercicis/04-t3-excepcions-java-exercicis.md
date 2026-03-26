# Exercicis Excepcions en Java
## Exercici 1. Excepcions habituals

### Enunciat

Crea un programa amb **4 mètodes independents**, cadascun provocant i capturant una excepció diferent.

Has d’utilitzar aquestes excepcions:

- `ArrayIndexOutOfBoundsException`
- `NumberFormatException`
- `NullPointerException`
- Cerca'n una diferent a les anteriors

### Requisits

Cada mètode ha de:

- Provocar l’excepció
- Capturar-lo amb `try-catch`
- Mostrar un missatge clar per pantalla
- Mostrar el tipus d’excepció

### Exemple d’estructura

```java
public static void exempleArithmetic() {
    try {
        int resultat = 10 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Error: divisió per zero");
        System.out.println("Excepció: " + e.getClass().getSimpleName());
    }
}
```

>Des de `main()` has de cridar els 4 mètodes.

---

##  Exercici 2. Propagació d’excepcions

### Enunciat

Crea un programa amb aquesta estructura:

- `main()`
- `metode1()`
- `metode2()`

### Funcionament

- L’error s’ha de produir dins de `metode2()`
- **NO** s’ha de capturar a `metode2()`
- S’ha de propagar a `metode1()`
- A `metode1()` sí que s’ha de capturar

Després de capturar l’excepció, el programa ha de continuar i mostrar un missatge final.

### Pista

Pots utilitzar un array i accedir a una posició incorrecta.

### Exemple d’idea

```java
public static void metode2() {
    int[] dades = {1, 2, 3};
    System.out.println(dades[5]);
}
```

---

## Exercici 3. Excepció pròpia i validació

### Enunciat

Crea una excepció pròpia i utilitza-la dins d’un mètode de validació.

### Part 1: Excepció pròpia

Crea una classe d’excepció que hereti de `Exception`.

Exemple:

```java
public class CorreuInvalidException extends Exception {
    public CorreuInvalidException(String missatge) {
        super(missatge);
    }
}
```


### Part 2: Mètode de validació

Crea un mètode, per exemple `validarUsuari(...)`, que comprovi:

- Nom no pot ser `null`
- Edat ha de ser positiva
- Correu ha de contenir `@`

### Requisits

- Has de provocar com a mínim:
  - una excepció estàndard de Java
  - la teva excepció pròpia
- Has d’utilitzar `throw`
- Has d’utilitzar `throws` (delegació)
- Les excepcions s’han de capturar i mostrar per pantalla



---


## 💡 Consells

- Fes servir noms de mètodes clars (`exempleArithmetic`, `metode1`, etc.)
- No copiïs codi: intenta entendre què provoca cada excepció
- Llegeix bé els missatges d’error
- Prova també què passa si **no captures** l’excepció.

---

