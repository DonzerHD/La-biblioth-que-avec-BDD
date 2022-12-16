package com.briefSimplon.bibliotheque;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ReservationDataBase {
	static String query = "SELECT u FROM Livre u WHERE u.titre LIKE :titre";
	static String query1 = "SELECT u FROM Reservation u WHERE u.prenom LIKE :prenom";
	static Livre util = null;
	static Reservation res = null;
	protected static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("library");
	static EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	static TypedQuery<Livre> tq = em.createQuery(query, Livre.class);
	static TypedQuery<Reservation> tr = em.createQuery(query1, Reservation.class);
	
	public void reserverLivre(String titre,String nom, String prenom, LocalDate donne) {
		tq.setParameter("titre", titre);
		util = tq.getSingleResult();
        Livre livre = Test_Bibliotheque.voirLivre(util.getId());
        
        Reservation reservation = new Reservation();
        reservation.setLivre(livre);
        reservation.setNom(nom);
        reservation.setPrenom(prenom);
        reservation.setDate_reserver(LocalDate.now());
        reservation.setDate_rendue(donne);
        faireReservation(reservation);
    }
	
	 public void faireReservation(Reservation reservation) {
	        EntityManager entityManager = ENTITY_MANAGER_FACTORY.createEntityManager();
	        entityManager.getTransaction().begin();

	        entityManager.persist(reservation);

	        entityManager.getTransaction().commit();
	        entityManager.close();
	    }
	 
	 public void rendreLivre(String titre, String nom, String prenom){
		 try {
			tq.setParameter("titre", titre);
			 util = tq.getSingleResult();
			  Livre livre = Test_Bibliotheque.voirLivre(util.getId());
			 tr.setParameter("prenom",prenom);
			 res = tr.getSingleResult();
			  
			  
			    em.getTransaction().begin();

			 // Récupération de l'entité à partir de la base de données
			    Reservation entity = em.find(Reservation.class, res.getId());

			 // Suppression de l'entité
			 em.remove(entity);
		} catch (NoResultException e) {
			// TODO Auto-generated catch block.
			System.out.println("Erreur saisie");
			Main.main(null);
		}

	     // Fin de la transaction
	     em.getTransaction().commit();

	     // Fermeture de l'EntityManager
	}	
	      
	      
	 }

