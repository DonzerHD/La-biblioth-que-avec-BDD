package com.briefSimplon.bibliotheque;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Test_Bibliotheque{
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("library");
	public static void main(String[] args) {
		
		voirLivre(1);
		voirLivres();
		changeNomUtilisateur(1, "Robin");
		deleteUtilisateur(1);
		
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
	public static Livre voirLivre(long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT l FROM Livre l WHERE l.id = :id";

		TypedQuery<Livre> tq = em.createQuery(query, Livre.class);
		tq.setParameter("id", id);
		Livre util = null;
		try {
			util = tq.getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return util;
	}
	

	public static void voirLivres() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT a FROM Livre a WHERE a.id IS NOT NULL";
		TypedQuery<Livre> tq = em.createQuery(strQuery, Livre.class);
		List<Livre> utils;
		try {
			utils = tq.getResultList();
			utils.forEach(util -> System.out.println(util.getTitre() + " " + util.getAuteur()));
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}
	
	public static void changeNomUtilisateur(long id, String titre) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Livre util = null;
		try {
			et = em.getTransaction();
			et.begin();
			util = em.find(Livre.class, id);
			util.setTitre(titre);
			em.persist(util);
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
	
	public static void deleteUtilisateur(long id) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Livre util = null;
		try {
			et = em.getTransaction();
			et.begin();
			util = em.find(Livre.class, id);
			em.remove(util);
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
