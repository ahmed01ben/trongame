package Model;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Main.Main;
import View.GameWindow;

/**
 * <h1>The Class LorannBDDConnector.</h1>
 *
 * @author BEN MBAREK Ahmed 
 * @version 1.0
 */
public final class LorannBDDConnector {

	// This attribute is necessary to execute a SQL stored procedures
	private CallableStatement cStmt;
	
	/**
	 * The LoranBDDConnector() method.
	 *
	 * This Method allows a link to the database and create a table with the winner and the time of the game.
	 * This Method recreate a new table after all games.
	 * 
	 * @param no
	 *            parameters
	 */
	public LorannBDDConnector() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "");
			Statement stmt = cnx.createStatement();
			cStmt = cnx.prepareCall("{CALL del}");
			cStmt.execute();
			cStmt = cnx.prepareCall("{CALL creatte}");
			cStmt.execute();
			if (GameWindow.WinnerP1) {
				stmt.executeUpdate("INSERT INTO information(Temps, Gagnant) VALUES(" + Main.countTime  + ",\"Orange\")");
			}
			else if (!GameWindow.WinnerP1) {
				stmt.executeUpdate("INSERT INTO information(Temps, Gagnant) VALUES(" + Main.countTime  + ",\"Bleu\")");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}