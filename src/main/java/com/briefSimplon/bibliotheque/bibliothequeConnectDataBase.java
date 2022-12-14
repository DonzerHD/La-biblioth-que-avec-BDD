package com.briefSimplon.bibliotheque;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.criterion.MatchMode;

public class bibliothequeConnectDataBase{
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("library");
	
	public void ajouterLivreBDD(Livre livre) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
            livre.getTitre();
			livre.getAuteur();
			livre.getGenre();
			livre.getNombre_page();
			livre.getNombre_exemplaire();
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
	
	public static void voirLivresBDD() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT a FROM Livre a WHERE a.id IS NOT NULL";
		TypedQuery<Livre> tq = em.createQuery(strQuery, Livre.class);
		List<Livre> utils;
		try {
			utils = tq.getResultList();
			StringBuilder affichageLivres = new StringBuilder();
			utils.forEach(util -> affichageLivres.append("Titre : ")
					              .append(util.getTitre())
					              .append("  Auteur : ")
					              .append(util.getAuteur() + "\r")
					);
			System.out.println(affichageLivres);
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}
	
	public static void rechercheLivresBDD(String titre) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String strQuery = "SELECT a FROM Livre a WHERE a.titre LIKE :titre";
		TypedQuery<Livre> tq = em.createQuery(strQuery, Livre.class);
		List<Livre> utils;
		try {
			tq.setParameter("titre", MatchMode.ANYWHERE.toMatchString(titre));
			utils = tq.getResultList();
			StringBuilder affichageLivres = new StringBuilder();
			utils.forEach(util -> affichageLivres.append("Titre : ")
					              .append(util.getTitre())
					              .append("  Auteur : ")
					              .append(util.getAuteur() + "\r")
					);
			System.out.println(affichageLivres);
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

	}

}
