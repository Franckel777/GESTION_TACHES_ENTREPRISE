package dao;

import java.sql.*;
import java.util.*;
public interface TacheDAO<Tache> {
	
	Tache get(int id) throws SQLException;
	
	List<Tache> afficherTache() throws SQLException;
	
	int ajouterTache() throws SQLException;
	
	int modifierTache() throws SQLException;
	
	int supprimerTache() throws SQLException;
}
