package dao;

import java.sql.*;
import java.util.*;
import database.DatabaseConnection;
import model.Tache;

public class TacheDAOImpl implements TacheDAO {

	@Override
	public Tache get(int id) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		Tache tache = null;
		String sql = "SELECT id,titre,description,responsable,statut FROM taches WHERE id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			int Id = rs.getInt("id");
			String Titre = rs.getString("titre");
			String Description = rs.getString("description");
			String Responsable = rs.getString("responsable");
			String Statut = rs.getString("statut".toUpperCase());

			tache = new Tache(Id, Titre, Description, Responsable, Statut);
		} else {
			System.out.println("Aucune taches trouvée");
		}
		return tache;
	}

	@Override
	public List<Tache> afficherTache() throws SQLException {

		Connection connection = DatabaseConnection.getConnection();

		String sql = "SELECT * FROM taches WHERE statut = 'EN_COURS' OR statut = 'A_FAIRE'";

		PreparedStatement ps = connection.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Tache> liste = new ArrayList<>();

		int count = 0;

		while (rs.next()) {

			int id = rs.getInt("id");
			String titre = rs.getString("titre");
			String description = rs.getString("description");
			String responsable = rs.getString("responsable");
			String statut = rs.getString("statut");

			count++;

			Tache t = new Tache(id, titre, description, responsable, statut);

			liste.add(t);
		}

		rs.close();
		ps.close();
		System.out.println("Le nombre de tache non terminee est de " + count);
		connection.close();
		return liste;
	}

	@Override
	public int ajouterTache(Tache tache) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		String sql = "INSERT INTO taches(id, titre, description, responsable, statut) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, tache.getId());
		ps.setString(2, tache.getTitre());
		ps.setString(3, tache.getDescription());
		ps.setString(4, tache.getResponsable());
		ps.setString(5, tache.getStatut().toUpperCase());

		int result = ps.executeUpdate();

		DatabaseConnection.closePreparedStatement(ps);
		DatabaseConnection.closeConnection(con);

		System.out.println("Taches ajoutée avec succes!");

		return result;
	}

	@Override
	public int modifierTache(Tache tache) throws SQLException {
		Connection con = DatabaseConnection.getConnection();

		String sql = "UPDATE taches SET statut = ? WHERE id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		;
		ps.setString(1, tache.getStatut().toUpperCase());
		ps.setInt(2, tache.getId());

		int result = ps.executeUpdate();

		DatabaseConnection.closePreparedStatement(ps);
		DatabaseConnection.closeConnection(con);

		System.out.println("Taches modifiée avec succes!");

		return result;
	}

	@Override
	public int supprimerTache(Tache tache) throws SQLException {
		Connection con = DatabaseConnection.getConnection();

		String sql = "DELETE FROM taches WHERE id = ? ";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, tache.getId());

		int result = ps.executeUpdate();

		DatabaseConnection.closePreparedStatement(ps);
		DatabaseConnection.closeConnection(con);

		System.out.println("Taches suprimée avec succes!");
		return result;
	}

}
