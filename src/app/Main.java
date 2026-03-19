package app;

import database.DatabaseConnection;
import dao.*;
import model.*;
import java.util.*;
import java.sql.*;
public class Main {

	public static void main(String[] args) throws SQLException {
		dao.TacheDAO testDAO = new dao.TacheDAOImpl();
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
			
			Connection con = database.DatabaseConnection.getConnection();
			if(con != null) {
					System.out.println("La base de données a ete connectée avec succes");
			}else {
				System.out.println("La base de données n'a pas ete connectée!");
			}
			try {
				int choix = sc.nextInt();
				sc.nextLine();
				switch(choix) {
				case 1 :

			            List<Tache> taches = testDAO.afficherTache();

			            for(Tache t : taches) {
			                System.out.println(
			                    t.getId() + " | " +
			                    t.getTitre() + " | " +
			                    t.getDescription() + " | " +
			                    t.getResponsable() + " | " +
			                    t.getStatut()
			                );
			            }
					
			} 
			}
				catch (Exception e) {
				System.out.println("Entrez un choix valide!");
			}
			
	}
		
}
	
}
