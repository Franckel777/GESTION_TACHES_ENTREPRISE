package dao;

import java.sql.*;
import java.util.*;
import database.DatabaseConnection;
import model.Tache;
import dao.*;

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
			String Statut = rs.getString("statut");

			tache = new Tache(Id, Titre, Description, Responsable, Statut);
		}else {
			System.out.println("Aucune taches trouvée");
		}
		return tache;
	}

	@Override
	public List<Tache> afficherTache() throws SQLException {

	    Connection connection = DatabaseConnection.getConnection();

	    String sql = "SELECT * FROM taches";

	    PreparedStatement ps = connection.prepareStatement(sql);

	    ResultSet rs = ps.executeQuery();

	    List<Tache> liste = new ArrayList<>();

	    while(rs.next()) {

	        int id = rs.getInt("id");
	        String titre = rs.getString("titre");
	        String description = rs.getString("description");
	        String responsable = rs.getString("responsable");
	        String statut = rs.getString("statut");

	        Tache t = new Tache(id, titre, description, responsable, statut);

	        liste.add(t);
	    }

	    rs.close();
	    ps.close();
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
		ps.setString(5, tache.getStatut());

		int result = ps.executeUpdate();
		
		DatabaseConnection.closePreparedStatement(ps);
		DatabaseConnection.closeConnection(con);
		
		return result;
	}
	

	@Override
	public int modifierTache(Tache tache) throws SQLException {
		Connection con = DatabaseConnection.getConnection();
		
		String sql = "UPDATE taches SET titre = ?, description = ?, responsable =  ?, statut = ? WHERE id = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		
		ps.setString(1, tache.getTitre());
		ps.setString(2, tache.getDescription());
		ps.setString(3, tache.getResponsable());
		ps.setString(4, tache.getStatut());  
		ps.setInt(5, tache.getId());
		
		int result = ps.executeUpdate();
		
		DatabaseConnection.closePreparedStatement(ps);
		DatabaseConnection.closeConnection(con);
		
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
		
		System.out.println("Taches suprimee avec succes!");
		return result;
	}


}
