package dao;

import model.Tache;
import java.sql.SQLException;
import java.util.List;

public interface DAO<Tache> {

	model.Tache get(int id) throws SQLException;

	List<model.Tache> afficherTache(model.Tache tache) throws SQLException;

	int ajouterTache(model.Tache tache) throws SQLException;

	int modifierTache(model.Tache tache) throws SQLException;

	int supprimerTache(model.Tache tache) throws SQLException;

}
