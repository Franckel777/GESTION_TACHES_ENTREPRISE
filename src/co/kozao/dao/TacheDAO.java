package co.kozao.dao;

import java.sql.SQLException;
import java.util.List;

import co.kozao.model.Tache;

public interface TacheDAO  {
	Tache get(int id) throws SQLException;

	List<Tache> afficherTache() throws SQLException;

	int ajouterTache(Tache tache) throws SQLException;

	int modifierTache(Tache tache) throws SQLException;

	int supprimerTache(Tache tache) throws SQLException;
} 
