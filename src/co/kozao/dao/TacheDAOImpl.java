package co.kozao.dao;

import java.sql.*;
import java.util.*;

import co.kozao.database.DatabaseConnection;
import co.kozao.model.Tache;
import co.kozao.enums.*;

public class TacheDAOImpl implements TacheDAO {

	static TacheDAOImpl tacheDAO;

	private TacheDAOImpl() {

	}

	public static TacheDAOImpl getInstance() {
		if (tacheDAO == null) {
			tacheDAO = new TacheDAOImpl();
		}
		return tacheDAO;
	}

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
			Statut statut = Statut.valueOf(rs.getString("statut")); // rs.getString prend la valeur du string contenu
																	// dans la variable de type enum statut,
																	// Statut.valueOf converti cela en enum

			tache = new Tache(Id, Titre, Description, Responsable, statut);
		} else {
			System.out.println("Aucune taches trouvée");
		}
		rs.close();
		DatabaseConnection.closePreparedStatement(ps);
		DatabaseConnection.closeConnection(con);

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
			Statut statut = Statut.valueOf(rs.getString("statut"));
			count++;

			Tache tache = new Tache(id, titre, description, responsable, statut);
			liste.add(tache);
		}

		rs.close();
		// ps.close();
		System.out.println("Le nombre de tache non terminee est de " + count);
		// connection.close();
		DatabaseConnection.closePreparedStatement(ps);
		DatabaseConnection.closeConnection(connection);
		return liste;
	}

	@Override
	public int ajouterTache(Tache tache) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		String sql = "INSERT INTO taches(titre, description, responsable, statut) VALUES (?, ?, ?, 'A_FAIRE')";

		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, tache.getTitre());
		ps.setString(2, tache.getDescription());
		ps.setString(3, tache.getResponsable());

		int result = ps.executeUpdate();

		DatabaseConnection.closePreparedStatement(ps);
		DatabaseConnection.closeConnection(con);

		System.out.println("Taches ajoutée avec succes!");

		return result;
	}

	public void ajouterTache(int id, String titre, String description, String responsable) throws SQLException {
		Tache tache = new Tache(id, titre, description, responsable, Statut.A_FAIRE);
		ajouterTache(tache);
	}

	@Override
	public int modifierTache(Tache tache) throws SQLException {
		Connection con = DatabaseConnection.getConnection();

		String sql = "UPDATE taches SET statut = ? WHERE id = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		;
		ps.setString(1, tache.getStatut().name().toUpperCase());
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
