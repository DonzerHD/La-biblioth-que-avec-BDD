package com.briefSimplon.bibliotheque;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.NoResultException;

public class Bibliotheque {

	public Livre ajouterUnLivre() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Titre du livre : ");
		String titre = sc.nextLine();
		System.out.print("Auteur du livre : ");
		String auteur = sc.nextLine();
		System.out.print("Genre du livre : ");
		String genre = sc.nextLine();
		System.out.print("Nombre de pages : ");
		int nombrePage = sc.nextInt();
		System.out.print("Nombre d'exemplaires : ");
		int nombreEx = sc.nextInt();
		
		Livre livre = new Livre();
	    livre.setTitre(titre);
	    livre.setAuteur(auteur);
	    livre.setGenre(genre);
	    livre.setNombre_page(nombrePage);
	    livre.setNombre_exemplaire(nombreEx);
	    return livre;
	}
	
	public String rechercheLivre() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel livre voulez vous rechercher: ");
		String rechercheLivre = sc.nextLine();
		return rechercheLivre;
	}
	
	public void modifierLivre(){
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel livre voulez vous rechercher: ");
		String rechercheLivre = sc.nextLine();
		ModifierLivreInTheBase.livreExiste(rechercheLivre);
		ModifierLivreInTheBase.menuModif();
		int choix = sc.nextInt();
	    sc.nextLine();
		switch(choix) {
		  case 1:
			 System.out.println("Nouveau titre :");
			 String titreNew = sc.nextLine();
			 ModifierLivreInTheBase.modifierTitre(rechercheLivre, titreNew);
		    break;
		  case 2:
			  System.out.println("Nouveau auteur:");
			  String auteurNew = sc.nextLine();
			  ModifierLivreInTheBase.modifierAuteur(rechercheLivre, auteurNew);
		    break;
		  case 3:
			  System.out.println("Nouveau genre :");
			  String genreNew = sc.nextLine();
			  ModifierLivreInTheBase.modifierGenre(rechercheLivre, genreNew);
			    break;
		  case 4:
			  System.out.println("Nouveau genre :");
			  int nPNew = sc.nextInt();
			  ModifierLivreInTheBase.modifierNombrePage(rechercheLivre, nPNew);// code block
			    break;
		  case 5:
			  System.out.println("Nouveau genre :");
			  int nENew = sc.nextInt();
			  ModifierLivreInTheBase.modifierNombreExemplaire(rechercheLivre, nENew);// code block
			    break;
		  default:
			  System.out.println("Mauvais chiffre");
		}
		}catch (NoResultException ex) {
			System.out.println("Le livre n'existe pas");
		}catch (InputMismatchException e) {
			System.out.println("chiffre seulement autorisée");
		}
	}
}
