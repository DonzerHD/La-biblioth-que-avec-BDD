package com.briefSimplon.bibliotheque;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe représentant un livre dans une bibliothèque.
 *
 * @author Thomas.L
 */
@Entity
@Table(name = "bibliotheque.livre")
public class Livre implements Serializable{
	 private static final long serialVersionUID = 1L;
	    
	 /**
	  * L'identifiant unique du livre.
	  */
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id", updatable = false, nullable = false)
	 private long id;

	 /**
	  * Le titre du livre.
	  */
	 @Column(name = "titre", nullable = false)
	 private String titre;

	 /**
	  * L'auteur du livre.
	  */
	 @Column(name = "auteur", nullable = false)
	 private String auteur;

	 /**
	  * Le genre du livre.
	  */
	 @Column(name = "genre", nullable = false)
	 private String genre;

	 /**
	  * Le nombre de pages du livre.
	  */
	 @Column(name = "nombre_page", nullable = false)
	 private int nombre_page;

	 /**
	  * Le nombre d'exemplaires du livre dans la bibliothèque.
	  */
	 @Column(name = "nombre_exemplaire", nullable = false)
	 private int nombre_exemplaire; 
   
	 /**
	  * Retourne l'identifiant unique du livre.
	  *
	  * @return l'identifiant unique du livre
	  */
	 public long getId() {
	     return id;
	 }

	 /**
	  * Modifie l'identifiant unique du livre.
	  *
	  * @param id le nouvel identifiant unique du livre
	  */
	 public void setId(long id) {
	     this.id = id;
	 }
	 
	 /**
	  * Retourne le titre du livre.
	  *
	  * @return le titre du livre
	  */
	 public String getTitre() {
	     return titre;
	 }

	 /**
	  * Modifie le titre du livre.
	  *
	  * @param titre le nouveau titre du livre
	  */
	 public void setTitre(String titre) {
	     this.titre = titre;
	 }
	 
	 /**
	  * Retourne l'auteur du livre.
	  *
	  * @return l'auteur du livre
	  */
	 public String getAuteur() {
	     return auteur;
	 }

	 
	 /**
	  * Modifie l'auteur du livre.
	  *
	  * @param auteur le nouvel auteur du livre
	  */
	 public void setAuteur(String auteur) {
	     this.auteur = auteur;
	 }

	 /**
	  * Retourne le genre du livre.
	  *
	  * @return le genre du livre
	  */
	 public String getGenre() {
	     return genre;
	 }

	 /**
	  * Modifie le genre du livre.
	  *
	  * @param genre le nouveau genre du livre
	  */
	 public void setGenre(String genre) {
	     this.genre = genre;
	 }

	 /**
	  * Retourne le nombre de pages du livre.
	  *
	  * @return le nombre de pages du livre
	  */
	 public int getNombre_page() {
	     return nombre_page;
	 }

	 /**
	  * Modifie le nombre de pages du livre.
	  *
	  * @param nombre_page le nouveau nombre de pages du livre
	  */
	 public void setNombre_page(int nombre_page) {
	     this.nombre_page = nombre_page;
	 }

	 /**
	  * Retourne le nombre d'exemplaires du livre dans la bibliothèque.
	  *
	  * @return le nombre d'exemplaires du livre dans la bibliothèque
	  */
	 public int getNombre_exemplaire() {
	     return nombre_exemplaire;
	 }

	 /**
	  * Modifie le nombre d'exemplaires du livre dans la bibliothèque.
	  *
	  * @param nombre_exemplaire le nouveau nombre d'exemplaires du livre dans la bibliothèque
	  */
	 public void setNombre_exemplaire(int nombre_exemplaire) {
	     this.nombre_exemplaire = nombre_exemplaire;
	 }

	 
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
}
