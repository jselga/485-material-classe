CREATE TABLE IF NOT EXISTS cursos (
    id INT NOT NULL AUTO_INCREMENT,
    codi VARCHAR(20) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    nivell VARCHAR(50) NOT NULL,
    CONSTRAINT cursos_pkey PRIMARY KEY (id),
    CONSTRAINT cursos_codi_unique UNIQUE (codi)
);
