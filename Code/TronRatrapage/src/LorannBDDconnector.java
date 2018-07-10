
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <h1>The Class BoulderDashBDDConnector.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
final class LorannBDDConnector {

	private CallableStatement cStmt;
	public LorannBDDConnector() {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root", "");
			Statement stmt = cnx.createStatement();
			cStmt = cnx.prepareCall("{CALL delete}");
			cStmt.execute();
			cStmt = cnx.prepareCall("{CALL create}");
			cStmt.execute();
			if (GameWindow.WinnerP1) {
				stmt.executeUpdate("INSERT INTO information(Temps, Gagnant) VALUES(" + Main.countTime  + ","  +  EndGame.p1 + ")");
			}
			else if (!GameWindow.WinnerP1) {
				stmt.executeUpdate("INSERT INTO information(Temps, Gagnant) VALUES(" + Main.countTime  + ","  +  EndGame.p2 + ")");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}