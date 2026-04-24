# Exercicis JDBC-DAO

## Exercici 1: Gestió de cursos

### Context

L'institut vol una aplicació molt senzilla per gestionar els cursos disponibles. Cada curs té un codi, un nom i un nivell.

### Objectiu

Practicar la connexió JDBC i el CRUD complet sobre una sola taula, sense relacions.

A més, en aquest exercici farem una primera introducció al patró DAO.

Un DAO (Data Access Object) és una classe que s'encarrega de fer les operacions d'accés a la base de dades.
La idea és separar:
- les dades de l'objecte,
- el codi SQL i l'accés a la base de dades,
- i el programa principal que coordina l'execució.

No cal complicar-ho: en aquest exercici només volem començar a veure aquesta separació d'una manera senzilla.

### Estructura mínima de dades

| Taula  | Camps principals      | Observacions                        |
|-------|----------------------|--------------------------------------|
| cursos| id, codi, nom, nivell| id enter autoincremental; codi únic |

### Tasques a implementar

Cal implementar les operacions següents sobre la taula cursos:
- inserir
- buscar per id
- llistar tots
- actualitzar
- eliminar

A més, el programa ha de permetre:
- mostrar per pantalla tots els cursos ordenats per id
- cercar un curs concret a partir del seu id i mostrar les seves dades
- modificar el nom i el nivell d'un curs existent
- eliminar un curs a partir del seu id

### Organització del programa

Per començar a treballar amb una estructura més ordenada, el programa s'hauria de separar en parts:

1. **Capa de model**

   Aquí hi haurà la classe que representa les dades d'un curs.
   - `Curs`: Aquesta classe contindrà els atributs de l'objecte curs.

2. **Capa d'accés a dades**

   Aquí hi haurà la classe encarregada de comunicar-se amb la base de dades.
   - `CursDAO`: Aquesta classe ha de contenir els mètodes del CRUD de la taula cursos.

3. **Gestió de la connexió**

   Cal tenir una classe o utilitat per crear o obtenir la connexió amb MySQL.
   - `DatabaseConnection` o equivalent

   També podeu tenir una classe auxiliar per crear l'estructura de la taula si cal.

4. **Programa principal**

   La classe Main serà l'encarregada de:
   - obrir la connexió
   - crear l'objecte DAO
   - provar les operacions
   - mostrar els resultats per pantalla

   Per exemple, al main es podria fer una cosa d'aquest estil:

   ```java
   CursDAO dao = new CursDAO(conn);
   ```

### Requisits concrets del programa Java

- Creeu una classe `Curs` dins de model.
- Creeu una classe `CursDAO` per fer les operacions sobre la taula cursos.
- Creeu una classe `DatabaseConnection` o equivalent per obtenir la connexió.
- El main pot fer una demostració automàtica o bé un petit menú per consola.
- Si no es troba un curs, el mètode del DAO pot retornar null.

---

## Exercici 2: Alumnes i cursos

### Context

Ara volem gestionar alumnes matriculats en cursos. Cada alumne pertany a un únic curs, i un curs pot tenir molts alumnes.

Aquest exercici es planteja com una continuació de l'exercici 1. Per tant, es manté la classe Curs i la taula cursos amb els camps que ja s'havien treballat anteriorment.

### Objectiu

Treballar una relació 1:N, fent consultes que recuperin objectes i comprovacions bàsiques abans d'inserir o esborrar.

### Estructura mínima de dades

| Taula   | Camps principals            | Observacions                              |
|--------|-----------------------------|---------------------------------------------|
| cursos  | id, codi, nom, nivell       | Taula pare. id enter autoincremental; codi únic |
| alumnes | id, nom, cognoms, email, curs_id | curs_id és clau forana que apunta a cursos.id |

### Tasques a implementar

- Crear els DAO necessaris per treballar amb cursos i alumnes.
- Inserir un alumne nou només si el curs indicat existeix.
- Llistar tots els alumnes mostrant also el nom del curs al qual pertanyen.
- Donat l'id d'un curs, mostrar les dades del curs i el llistat dels seus alumnes.
- Actualitzar l'email d'un alumne.
- Esborrar un curs. Abans de fer-ho, comprovar si té alumnes assignats: si en té, informar que no es pot esborrar.

### Organització del programa

Per mantenir una estructura clara, el programa s'hauria d'organitzar en parts:

1. **Capa de model**

   Classes que representen les dades del programa:
   - `Curs`
   - `Alumne`: La classe Alumne ha de contenir la informació de l'alumne i la referència al curs al qual pertany.

2. **Capa d'accés a dades**

   Classes encarregades de comunicar-se amb la base de dades:
   - `CursDAO`
   - `AlumneDAO`

   Aquestes classes han d'incloure els mètodes necessaris per fer les consultes i modificacions de les taules.

3. **Gestió de la connexió**

   Cal tenir una classe o utilitat per obtenir la connexió amb MySQL:
   - `DatabaseConnection` o equivalent

   També podeu tenir una classe auxiliar per crear l'estructura de les taules si cal.

4. **Programa principal**

   La classe Main coordinarà l'execució:
   - obrir la connexió
   - crear els objectes DAO
   - fer les comprovacions necessàries
   - mostrar els resultats per pantalla

   Per exemple, al main es podria fer una cosa d'aquest estil:

   ```java
   CursDAO cursDAO = new CursDAO(conn);
   AlumneDAO alumneDAO = new AlumneDAO(conn);
   ```

### Requisits concrets del programa Java

- Creeu les classes model `Curs` i `Alumne`.
- Feu servir `PreparedStatement` a totes les consultes amb paràmetres.
- Quan feu consultes de llistat, convertiu cada fila en un objecte `Alumne`.
- Com que aquest exercici continua l'anterior, la classe `Curs` i la taula cursos mantenen també el camp nivell.

### Observacions

- La relació entre les taules és d'un curs a molts alumnes.
- L'objectiu és practicar la relació 1:N amb JDBC i començar a treballar amb objectes relacionats.
- No cal fer una aplicació complexa: una demostració automàtica o un petit menú per consola és suficient.

---

## Exercici 3: Activitats i professors

### Context

L'institut organitza activitats complementàries. Cada activitat pot tenir més d'un professor assignat, i cada professor pot participar en diverses activitats.

### Objectiu

Practicar la connexió JDBC i el treball amb una relació N:M mitjançant una taula intermèdia.

Aquest exercici és la continuació natural dels anteriors: après de treballar una taula sola i una relació 1:N, ara treballarem una relació N:M.

### Estructura mínima de dades

| Taula                  | Camps principals           | Observacions                   |
|-----------------------|--------------------------|---------------------------------|
| professors            | id, nom, departament      | Taula principal                  |
| activitats            | id, titol, dia, lloc     | Taula principal                  |
| activitats_professors | activitat_id, professor_id | Taula intermèdia              |

### Tasques a implementar

Cal implementar les funcionalitats següents:
- crear els DAO necessaris per treballar amb professors i activitats
- gestionar també la relació entre activitats i professors
- llistar totes les activitats ordenades per id
- mostrar les dades d'una activitat concreta i el professorat assignat
- inserir una activitat nova i assignar-li dos professors existents
- modificar els professors assignats a una activitat concreta
- esborrar una activitat i eliminar també les seves relacions a la taula intermèdia

### Organització del programa

Per mantenir una estructura clara, el programa s'hauria de separar en parts:

1. **Capa de model**

   Aquí hi haurà les classes que representen les dades del programa.
   - `Professor`
   - `Activitat`

   Aquestes classes contindran els atributs principals de cada objecte.

2. **Capa d'accés a dades**

   Aquí hi haurà les classes encarregades de comunicar-se amb la base de dades.
   - `ProfessorDAO`
   - `ActivitatDAO`

   La gestió de la taula intermèdia es pot fer de dues maneres:
   - amb mètodes específics dins del `ActivitatDAO`
   - o bé amb un DAO propi per a la relació, si ho considereu útil

3. **Gestió de la connexió**

   Cal tenir una classe o utilitat per crear o obtenir la connexió amb MySQL.
   - `DatabaseConnection` o equivalent

   També podeu tenir una classe auxiliar per crear l'estructura de les taules si cal.

4. **Programa principal**

   La classe Main serà l'encarregada de:
   - obrir la connexió
   - crear els objectes DAO
   - provar les operacions
   - mostrar els resultats per pantalla

   Per exemple, al main es podria fer una cosa d'aquest estil:

   ```java
   ActivitatDAO activitatDAO = new ActivitatDAO(conn);
   ProfessorDAO professorDAO = new ProfessorDAO(conn);
   ```

### Requisits concrets del programa Java

- Creeu les classes model `Professor` i `Activitat`.
- Podeu gestionar la taula intermèdia amb mètodes específics del DAO d'activitats o amb un DAO propi.
- Feu servir `PreparedStatement` a les consultes amb paràmetres.
- La lògica principal de l'aplicació pot viure al main, sempre que el codi d'accés a dades estigui encapsulat als DAO.
- Es valorarà que el codi sigui clar i que les consultes quedin ben separades.

### Observacions

- En aquest exercici es treballa una relació N:M.
- L'objectiu principal és entendre com es representa aquesta relació a la base de dades i com es gestiona des de Java amb JDBC.
- No es demana una arquitectura en tres capes completa.
- L'important és separar l'accés a dades del codi principal mitjançant DAO.

---

## recordatoris finals

Podeu utilitzar una estructura mínima i funcional com aquesta:
- model
- dao
- db
- app/main

Abans de començar, reviseu bé:
- la connexió a MySQL
- les claus foranes
- els tipus de dades
- l'estructura de la taula intermèdia

Es recomana provar cada part del programa de manera incremental:
- primer la connexió
- després una consulta simple
- després la resta del CRUD i la gestió de relacions