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

/* Création table réservation */
CREATE TABLE bibliotheque.reservation
(
    id SERIAL PRIMARY KEY,
    prenom VARCHAR(50),
    nom VARCHAR(50),
    id int,
    date_reserver  DATE,
    date_rendue  DATE    
)

