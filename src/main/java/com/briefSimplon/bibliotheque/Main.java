package com.briefSimplon.bibliotheque;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import org.hibernate.type.LocalDateType;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Bibliotheque bibliotheque1 = new Bibliotheque();
		BibliothequeConnectDataBase bibliotheque1Connect = new BibliothequeConnectDataBase();
		ReservationDataBase reserv = new ReservationDataBase();

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
			case 5:
				System.out.println("Option 5 sélectionnée.");
				System.out.println("Quel livre voulez vous réserver ?");
				sc.nextLine();
			    String livre = sc.nextLine();
			    System.out.println("Votre nom : ");
			    String nom = sc.nextLine();
			    System.out.println("Votre prénom  :");
			    String prenom = sc.nextLine();
			    System.out.println("Date rendue : ");
			    String dateE = sc.nextLine();
				DateTimeFormatter formatEntree = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
				LocalDate date = LocalDate.parse(dateE, formatEntree);
				reserv.reserverLivre(livre, nom , prenom , date);
				main(null);
				break;
			case 6:
				System.out.println("Option 5 sélectionnée.");
				System.out.println("Quel livre voulez vous rendre ?");
				sc.nextLine();
			    String livreR = sc.nextLine();
			    System.out.println("Votre nom : ");
			    String nomR = sc.nextLine();
			    System.out.println("Votre prénom  :");
			    String prenomR = sc.nextLine();
			    reserv.rendreLivre(livreR, nomR, prenomR);
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
		System.out.println("5 - Réserver un livre");
		System.out.println("6 - Ré");
		System.out.println("-------------------------");
		System.out.print("Veuillez sélectionner une option : ");
	}

}
