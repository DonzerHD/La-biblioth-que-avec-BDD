/* Création table livre */
CREATE TABLE bibliotheque.livre
(
    id SERIAL PRIMARY KEY,
    titre VARCHAR(50),
    auteur VARCHAR(50),
    genre VARCHAR(50),
    nombre_page INT,
    nombre_exemplaire INT
)
