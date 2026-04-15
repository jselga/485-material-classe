-- =========================================================
-- SCRIPT SQL PER ALS 3 EXERCICIS DE JDBC
-- Tema: Connexió a BBDD des de Java
-- 
-- Aquest fitxer crea i omple les 3 bases de dades dels exercicis:
--   1) institut_ex1 -> cursos
--   2) institut_ex2 -> cursos + alumnes (relació 1:N)
--   3) institut_ex3 -> cursos + alumnes + activitats + alumnes_activitats (relació N:M)
-- =========================================================

-- ---------------------------------------------------------
-- EXERCICI 1
-- ---------------------------------------------------------
DROP DATABASE IF EXISTS institut_ex1;
CREATE DATABASE institut_ex1 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE institut_ex1;

CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    nivell VARCHAR(20) NOT NULL
);

INSERT INTO cursos (nom, nivell) VALUES
('Programació', '1r DAM'),
('Bases de Dades', '1r DAM'),
('Desenvolupament web', '1r DAW');

-- ---------------------------------------------------------
-- EXERCICI 2
-- ---------------------------------------------------------
DROP DATABASE IF EXISTS institut_ex2;
CREATE DATABASE institut_ex2 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE institut_ex2;

CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    nivell VARCHAR(20) NOT NULL
);

CREATE TABLE alumnes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    email VARCHAR(80) NOT NULL UNIQUE,
    curs_id INT NOT NULL,
    CONSTRAINT fk_alumnes_cursos
        FOREIGN KEY (curs_id) REFERENCES cursos(id)
);

INSERT INTO cursos (nom, nivell) VALUES
('Programació', '1r DAM'),
('Bases de Dades', '1r DAM'),
('Desenvolupament web', '1r DAW');

INSERT INTO alumnes (nom, email, curs_id) VALUES
('Laia', 'laia@institut.cat', 1),
('Marc', 'marc@institut.cat', 1),
('Nora', 'nora@institut.cat', 3);

-- ---------------------------------------------------------
-- EXERCICI 3
-- ---------------------------------------------------------
DROP DATABASE IF EXISTS institut_ex3;
CREATE DATABASE institut_ex3 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE institut_ex3;

CREATE TABLE cursos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    nivell VARCHAR(20) NOT NULL
);

CREATE TABLE alumnes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    email VARCHAR(80) NOT NULL UNIQUE,
    curs_id INT NOT NULL,
    CONSTRAINT fk_alumnes_cursos
        FOREIGN KEY (curs_id) REFERENCES cursos(id)
);

CREATE TABLE activitats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(60) NOT NULL,
    places INT NOT NULL
);

CREATE TABLE alumnes_activitats (
    alumne_id INT NOT NULL,
    activitat_id INT NOT NULL,
    PRIMARY KEY (alumne_id, activitat_id),
    CONSTRAINT fk_aa_alumne
        FOREIGN KEY (alumne_id) REFERENCES alumnes(id),
    CONSTRAINT fk_aa_activitat
        FOREIGN KEY (activitat_id) REFERENCES activitats(id)
);

INSERT INTO cursos (nom, nivell) VALUES
('Programació', '1r DAM'),
('Bases de Dades', '1r DAM'),
('Desenvolupament web', '1r DAW');

INSERT INTO alumnes (nom, email, curs_id) VALUES
('Laia', 'laia@institut.cat', 1),
('Marc', 'marc@institut.cat', 1),
('Nora', 'nora@institut.cat', 3);

INSERT INTO activitats (nom, places) VALUES
('Robòtica', 2),
('Escacs', 3),
('Cinema', 1);

INSERT INTO alumnes_activitats (alumne_id, activitat_id) VALUES
(1, 1),
(2, 1),
(3, 2);
