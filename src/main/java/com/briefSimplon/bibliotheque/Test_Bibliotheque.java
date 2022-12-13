package com.briefSimplon.bibliotheque;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test_Bibliotheque {
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("library");
	public static void main(String[] args) {
		
		ajouterLivre("Art de la guerre", "Thomas Lemay", "Histoire", 500, 1);
		
		ENTITY_MANAGER_FACTORY.close();
	}
	
	public static void ajouterLivre(String titre, String auteur, String genre, int nombre_page , int nombre_exemplaire) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Livre livre = new Livre();
			livre.setTitre(titre);
			livre.setAuteur(auteur);
			livre.setGenre(genre);
			livre.setNombre_page(nombre_page);
			livre.setNombre_exemplaire(nombre_exemplaire);
			em.persist(livre);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}
}
