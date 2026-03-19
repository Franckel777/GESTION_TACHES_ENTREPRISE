package app;

import dao.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		int option = 0;
		Scanner sc = new Scanner(System.in);
		while (option != 5) {
			System.out.println("=== GESTION DES TACHES ===");
			System.out.println("1.Ajouter une tache");
			System.out.println("2.Afficher les taches");
			System.out.println("3.Modifier le statut d'une tache");
			System.out.println("4.Supprimer une tache");
			System.out.println("5.Quitter");
			System.out.println("Votre choix");
			try {
				int choix = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Entrez un choix valide!");
			}
		}
	}

}
