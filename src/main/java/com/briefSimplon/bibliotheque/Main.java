package com.briefSimplon.bibliotheque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Bibliotheque bibliotheque1 = new Bibliotheque();
		BibliothequeConnectDataBase bibliotheque1Connect = new BibliothequeConnectDataBase();

		try {
			menu();
			int selection = sc.nextInt();
			switch (selection) {
			case 1:
				System.out.println("Option 1 sélectionnée. : ");
			    bibliotheque1Connect.ajouterLivreBDD(bibliotheque1.ajouterUnLivre());
				main(null);
				break;
			case 2:
				sc.nextLine();
				System.out.println("Option 2 sélectionnée.");
			    bibliotheque1.modifierLivre();
				main(null);
				break;
			case 3:
				System.out.println("Option 3 sélectionnée.");
				BibliothequeConnectDataBase.voirLivresBDD();
				main(null);
				break;
			case 4:
				System.out.println("Option 4 sélectionnée.");
				BibliothequeConnectDataBase.rechercheLivresBDD(bibliotheque1.rechercheLivre());
				main(null);
				break;
			default:
				throw new IllegalArgumentException("L'option sélectionnée n'est pas valable : " + selection);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Ce nombre correspond à aucun du menu !");
			e.printStackTrace();
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			main(null);
		} catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("saisie invalide");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			main(null);
		} finally {
			sc.close();
		}

	}

	/**
	 * Fonction qui affiche le menu.
	 */
	public static void menu() {

		System.out.println("-------------------------");
		System.out.println("    |Bibliothèque|");
		System.out.println("-------------------------");
		System.out.println("1 - Saisir un livre");
		System.out.println("2 - Modifier un livre");
		System.out.println("3 - Afficher la liste des livres ");
		System.out.println("4 - Rechercher un livre");
		System.out.println("-------------------------");
		System.out.print("Veuillez sélectionner une option : ");
	}

}
