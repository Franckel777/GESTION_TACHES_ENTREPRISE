package co.kozao.database;

import java.sql.*;

public class DatabaseConnection {

	private static String url = "jdbc:mysql://localhost:3306/gestion_projet";
	private static String user = "root";
	private static String password = "";
 
	private DatabaseConnection() {

	}

	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(url, user, password);
		return connection; 
	}

	public static void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
