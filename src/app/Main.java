package app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Tache;

public class Main {

	public static void main(String[] args) throws SQLException {
		dao.TacheDAO tacheDAO = new dao.TacheDAOImpl();
		int option = 0;
		try (Scanner sc = new Scanner(System.in)) {
			while (option != 5) {

				System.out.println("=== GESTION DES TACHES ===");
				System.out.println("1.Ajouter une tache");
				System.out.println("2.Afficher les taches");
				System.out.println("3.Modifier le statut d'une tache");
				System.out.println("4.Supprimer une tache");
				System.out.println("5.Quitter");
				try {
					System.out.print("Votre choix : ");

					int choix = sc.nextInt();
					switch (choix) {

					case 1:
						try {
							System.out.print("Entrez le titre de la tache: ");
							sc.nextLine();
							String titre = sc.nextLine();

							System.out.print("Decrivez la tache: ");
							String description = sc.nextLine();

							System.out.print("Quel est le nom de celui qui s'en charge? : ");
							String responsable = sc.nextLine();

							System.out.print(
									"Quel est son status (NB : Vous n'avez que les options <<A_FAIRE>> <<EN_COURS>> <<TERMINEE>>) : ");
							String status = sc.nextLine();

							int id = 0;
							model.Tache tache = null;
							tache = new model.Tache(id, titre, description, responsable, status);
							tacheDAO.ajouterTache(tache);

						} catch (Exception e) {
							System.out.println("Une ou plusieurs information(s) saisies est/sont incorrecte!");
						}

						break;

					case 2:

						List<Tache> taches = tacheDAO.afficherTache();

						for (Tache t : taches) {
							if (taches.isEmpty()) {
								System.out.println("Il n'ya aucune tache pour l'instant");
							} else {
								System.out.println("ID : " + t.getId() + " | " + " Titre : " + t.getTitre() + " | "
										+ " Description : " + t.getDescription() + " | " + " Responsable : "
										+ t.getResponsable() + " | " + " Status : " + t.getStatut());
							}
						}
						break;

					case 3:
						try {
							System.out.print("Entrez l'ID de la tache : ");
							int id = sc.nextInt();
							sc.nextLine();
							if (tacheDAO.get(id) == null) {
								System.out.println("La tache n'existe pas!");
							} else {
								String titre = null;
								String description = null;
								String responsable = null;
								System.out.print(
										"Quel est son nouveau status (NB : Vous n'avez que les options <<A_FAIRE>> <<EN_COURS>> <<TERMINEE>>) : ");
								String status = sc.nextLine();

								model.Tache tache = new model.Tache(id, titre, description, responsable, status);
								tacheDAO.modifierTache(tache);
							}

						} catch (Exception e) {
							System.out.println("Une ou plusieurs information(s) saisies est/sont incorrecte!");
						}
						break;

					case 4:
						try {
							System.out.print("Entrez l'ID de la tache a supprimer : ");
							int id = sc.nextInt();
							if (tacheDAO.get(id) == null) {
								System.out.println("La tache n'existe pas!");
							} else {
								model.Tache tache = tacheDAO.get(id);
								tacheDAO.supprimerTache(tache);
							}

						} catch (Exception e) {
							System.out.println("Entrez un ID valide!");
						}
						break;

					case 5:
						option = 5;
						break;
					}
				} catch (Exception e) {
					System.out.println("Entrez un choix valide!");
				}

			}

			Connection con = database.DatabaseConnection.getConnection();
			if (con != null) {
				System.out.println("La base de données a ete connectée avec succes");
			} else {
				System.out.println("La base de données n'a pas ete connectée!");
			}

		} catch (Exception e) {
			System.out.println("Entrez un choix valide!");
		}
	}

}
