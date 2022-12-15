package com.briefSimplon.bibliotheque;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ReservationDataBase {
	static String query = "SELECT u FROM Livre u WHERE u.titre LIKE :titre";
	static Livre util = null;
	protected static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("library");
	static EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	static TypedQuery<Livre> tq = em.createQuery(query, Livre.class);
	
	public void reserveBook(String titre,String nom, String prenom, LocalDate donne) {
		tq.setParameter("titre", titre);
		util = tq.getSingleResult();
        Livre livre = Test_Bibliotheque.voirLivre(util.getId());

        if (livre == null) {
            throw new IllegalArgumentException("Invalid book or user ID");
        }

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
}
