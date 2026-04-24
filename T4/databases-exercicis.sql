-- =========================================================
-- SCRIPT SQL PER ALS 3 EXERCICIS DE JDBC
-- Tema: Connexió a BBDD des de Java
-- 
-- Aquest fitxer crea i omple les 3 bases de dades dels exercicis:
--   1) institut_ex1 -> cursos
--   2) institut_ex2 -> cursos + alumnes (relació 1:N)
--   3) institut_ex3 -> professors + activitats + activitats_professors (relació N:M)
-- =========================================================

-- ---------------------------------------------------------
-- EXERCICI 1: Gestió de cursos
-- ---------------------------------------------------------
DROP DATABASE IF EXISTS institut_ex1;
CREATE DATABASE institut_ex1 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE institut_ex1;

CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codi VARCHAR(10) NOT NULL UNIQUE,
    nom VARCHAR(60) NOT NULL,
    nivell VARCHAR(20) NOT NULL
);

INSERT INTO cursos (codi, nom, nivell) VALUES
('PROG', 'Programació', '1r DAM'),
('BD', 'Bases de Dades', '1r DAM'),
('DW', 'Desenvolupament web', '1r DAW');

-- ---------------------------------------------------------
-- EXERCICI 2: Alumnes i cursos (relació 1:N)
-- ---------------------------------------------------------
DROP DATABASE IF EXISTS institut_ex2;
CREATE DATABASE institut_ex2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE institut_ex2;

CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codi VARCHAR(10) NOT NULL UNIQUE,
    nom VARCHAR(60) NOT NULL,
    nivell VARCHAR(20) NOT NULL
);

CREATE TABLE alumnes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    cognoms VARCHAR(100) NOT NULL,
    email VARCHAR(80) NOT NULL UNIQUE,
    curs_id INT NOT NULL,
    CONSTRAINT fk_alumnes_cursos
        FOREIGN KEY (curs_id) REFERENCES cursos(id)
);

INSERT INTO cursos (codi, nom, nivell) VALUES
('PROG', 'Programació', '1r DAM'),
('BD', 'Bases de Dades', '1r DAM'),
('DW', 'Desenvolupament web', '1r DAW');

INSERT INTO alumnes (nom, cognoms, email, curs_id) VALUES
('Laia', 'Garcia Lopez', 'laia@institut.cat', 1),
('Marc', 'Martinez Sanchez', 'marc@institut.cat', 1),
('Nora', 'Rodriguez Torres', 'nora@institut.cat', 3);

-- ---------------------------------------------------------
-- EXERCICI 3: Activitats i professors (relació N:M)
-- ---------------------------------------------------------
DROP DATABASE IF EXISTS institut_ex3;
CREATE DATABASE institut_ex3 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE institut_ex3;

CREATE TABLE professors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    departament VARCHAR(60) NOT NULL
);

CREATE TABLE activitats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titol VARCHAR(100) NOT NULL,
    dia VARCHAR(20) NOT NULL,
    lloc VARCHAR(60) NOT NULL
);

CREATE TABLE activitats_professors (
    activitat_id INT NOT NULL,
    professor_id INT NOT NULL,
    PRIMARY KEY (activitat_id, professor_id),
    CONSTRAINT fk_ap_activitat
        FOREIGN KEY (activitat_id) REFERENCES activitats(id),
    CONSTRAINT fk_ap_professor
        FOREIGN KEY (professor_id) REFERENCES professors(id)
);

INSERT INTO professors (nom, departament) VALUES
('Anna Bosch', 'Informàtica'),
('Jordi Miller', 'Informàtica'),
('Maria Costa', 'Matemàtiques');

INSERT INTO activitats (titol, dia, lloc) VALUES
('Robòtica', 'Dijous', 'Lab 201'),
('Escacs', 'Dimarts', 'Biblioteca'),
('Cinema', 'Divendres', 'Auditori');

INSERT INTO activitats_professors (activitat_id, professor_id) VALUES
(1, 1),
(1, 2),
(2, 3);