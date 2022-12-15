package com.briefSimplon.bibliotheque;



import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


public class ModifierLivreInTheBase extends BibliothequeConnectDataBase{
	static EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
	static EntityTransaction et = null;
	static String query = "SELECT u FROM Livre u WHERE u.titre LIKE :titre";
	static TypedQuery<Livre> tq = em.createQuery(query, Livre.class);
	static Livre util = null;
	
	public static void menuModif() {
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
		tq.setParameter("titre", titre);
		try {
			util = tq.getSingleResult();
			System.out.println("Le livre est bien la");
		} catch (NoResultException ex) {
			System.out.println("Le livre n'existe pas");
			Main.main(null);
		}
	}
	
	
	public static void modifierTitre(final String titre, final String titreM) {
		tq.setParameter("titre", titre);
		try {
			util = tq.getSingleResult();
			et = em.getTransaction();
			et.begin();
			util = em.find(Livre.class, util.getId());
			util.setTitre(titreM);
			em.persist(util);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
	}
	public static void modifierAuteur(final String titre , final String genreM ) {

		tq.setParameter("titre", titre);
		try {
			util = tq.getSingleResult();
			et = em.getTransaction();
			et.begin();
			util = em.find(Livre.class, util.getId());
			util.setAuteur(genreM);
			em.persist(util);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} 

	}
	public static void modifierGenre(final String titre , final String genreM ) {

		tq.setParameter("titre", titre);
		try {
			util = tq.getSingleResult();
			et = em.getTransaction();
			et.begin();
			util = em.find(Livre.class, util.getId());
			util.setGenre(genreM);
			em.persist(util);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		} 

	}
	public static void modifierNombrePage(final String titre, final int genreM) {

		tq.setParameter("titre", titre);
		try {
			util = tq.getSingleResult();
			et = em.getTransaction();
			et.begin();
			util = em.find(Livre.class, util.getId());
			util.setNombre_page(genreM);
			em.persist(util);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
	}
	public static void modifierNombreExemplaire(final String titre, final int genreM) {

		tq.setParameter("titre", titre);
		try {
			util = tq.getSingleResult();
			et = em.getTransaction();
			et.begin();
			util = em.find(Livre.class, util.getId());
			util.setNombre_exemplaire(genreM);
			em.persist(util);
			et.commit();
		} catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
		}
		
	}
}
