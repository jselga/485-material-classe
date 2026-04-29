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
('PROG', 'Programació', '1r DAM/DAW'),
('BD', 'Bases de Dades', '1r DAM/DAW'),
('DW', 'Desenvolupament web entorn Client', '2n DAW');

INSERT INTO alumnes (nom, cognoms, email, curs_id) VALUES
('Laia', 'Garcia Lopez', 'laia@institut.cat', 1),
('Marc', 'Martinez Sanchez', 'marc@institut.cat', 1),
('Nora', 'Rodriguez Torres', 'nora@institut.cat', 3);
