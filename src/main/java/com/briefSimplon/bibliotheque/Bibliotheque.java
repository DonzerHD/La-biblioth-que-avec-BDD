package com.briefSimplon.bibliotheque;

import java.util.Scanner;

public class Bibliotheque {
	/**
	 * Méthode qui permet d'ajouter des livres dans la bibliothèque saisie par
	 * l'utilisateur.
	 * @return 
	 * @return 
	 */
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
		System.out.println("Recheche livre : ");
		String rechercheLivre = sc.nextLine();
		return rechercheLivre;
	}
}