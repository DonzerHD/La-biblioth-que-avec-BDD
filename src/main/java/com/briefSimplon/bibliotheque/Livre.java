package com.briefSimplon.bibliotheque;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bibliotheque.livre")
public class Livre implements Serializable{
	 private static final long serialVersionUID = 1L;
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id", updatable = false, nullable = false)
	    private long id;
	    
	    @Column(name = "titre", nullable = false)
	    private String titre;
	    
	    @Column(name = "auteur", nullable = false)
	    private String auteur;
	    
	    @Column(name = "genre", nullable = false)
	    private String genre;
	    
	    @Column(name = "nombre_page", nullable = false)
	    private int nombre_page;
	    
	    @Column(name = "nombre_exemplaire", nullable = false)
	    private int nombre_exemplaire;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getAuteur() {
			return auteur;
		}

		public void setAuteur(String auteur) {
			this.auteur = auteur;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public int getNombre_page() {
			return nombre_page;
		}

		public void setNombre_page(int nombre_page) {
			this.nombre_page = nombre_page;
		}

		public int getNombre_exemplaire() {
			return nombre_exemplaire;
		}

		public void setNombre_exemplaire(int nombre_exemplaire) {
			this.nombre_exemplaire = nombre_exemplaire;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
}
