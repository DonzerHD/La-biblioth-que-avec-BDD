package com.briefSimplon.bibliotheque;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.criterion.MatchMode;

public class ModifierLivre extends BibliothequeConnectDataBase{
	
	public void menuModif(String recherche) {
		System.out.println("-------------------------");
		System.out.println("Vous avez choisi de modifier le livre : " + recherche);
		System.out.println("-------------------------");
		System.out.println("    |Modifier|");
		System.out.println("-------------------------");
		System.out.println("1 - Titre");
		System.out.println("2 - Auteur");
		System.out.println("3 - Genre");
		System.out.println("4 - Nombre de pages");
		System.out.println("5 - Nombre d'exemplaires");
		System.out.println("-------------------------");
		System.out.print("Veuillez sélectionner une option : ");

	}

	
	public static void livreExiste(final String titre) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		String query = "SELECT u FROM Livre u WHERE u.titre LIKE :titre";

		TypedQuery<Livre> tq = em.createQuery(query, Livre.class);
		tq.setParameter("titre", titre);
		Livre util = null;
		try {
			util = tq.getSingleResult();
			System.out.println("Le livre est bien la");
		} catch (NoResultException ex) {
			System.out.println("Le livre n'existe pas");
		} finally {
			em.close();
		}
	}
	
	public static void modifierLivreTitre(long id, String titreM) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Livre util = null;
		try {
			et = em.getTransaction();
			et.begin();
			util = em.find(Livre.class, id);
			util.setTitre(titreM);
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

}
