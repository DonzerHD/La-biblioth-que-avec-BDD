package com.briefSimplon.bibliotheque;

import java.awt.print.Book;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe représentant une réservation dans la bibliothèque.
 * 
 * @author Simplon
 */
@Entity
@Table(name = "bibliotheque.reservation")
public class Reservation {
	
	/**
	 * Identifiant unique de la réservation.
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reservation", updatable = false, nullable = false)
    private long id;
	
	/**
	 * Prénom de la personne qui a réservé le livre.
	 */
	@Column(name = "prenom", nullable = false)
    private String prenom;
    
    /**
     * Nom de la personne qui a réservé le livre.
     */
    @Column(name = "nom", nullable = false)
    private String nom;
    
    /**
     * Date à laquelle le livre a été réservé.
     */
    @Column(name = "date_reserver", nullable = false)
    private LocalDate date_reserver;
    
    /**
     * Date à laquelle le livre doit être rendu.
     */
    @Column(name = "date_rendue", nullable = false)
    private LocalDate date_rendue;

    /**
     * Id du livre
     */
	    @ManyToOne
	    @JoinColumn(name = "id")
	    private Livre livre;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public Livre getLivre() {
			return livre;
		}

		public void setLivre(Livre livre) {
			this.livre = livre;
		}

		public LocalDate getDate_reserver() {
			return date_reserver;
		}

		public void setDate_reserver(LocalDate date_reserver) {
			this.date_reserver = date_reserver;
		}

		public LocalDate getDate_rendue() {
			return date_rendue;
		}

		public void setDate_rendue(LocalDate date_rendue) {
			this.date_rendue = date_rendue;
		}

		public void setId(long id) {
			this.id = id;
		}

}

