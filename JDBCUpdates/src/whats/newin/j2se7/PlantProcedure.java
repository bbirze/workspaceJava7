package whats.newin.j2se7;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Stored Procedure External Class
   Using database credentials
      framework = "derbyclient";
      driver    = "org.apache.derby.jdbc.ClientDriver";
      protocol  = "jdbc:derby://localhost:1527/";
 */
public class PlantProcedure {
 
	/*  This method is registered with the Derby database and
	 *  will be invoked as a stored procedure.  Using the default JDBC
	 *  connection on getConnection so will use the existing JDBC connection.
	 *  To work: method Must be declared public static
	 *           OUT paramters must be declared as arrays
	 *           Do NOT close statement or ResultsSet will be closed
	 */
	public static void getPlantById(long     plantId   /* IN Parameter */,
									String[] plantName /* OUT parameter */)	throws SQLException {
		ResultSet res = null;

		try(Connection conn = DriverManager.getConnection("jdbc:default:connection");
			PreparedStatement stmt = conn.prepareStatement("SELECT Plant FROM Plants WHERE Id = ?")) {
		
			stmt.setLong(1,  plantId);
			res = stmt.executeQuery();
			plantName[0] = (res.next()) ? res.getString(1) : "Plant not Found.";
		} finally {
			if (res != null)  {
				res.close();
			}
		}
	}
}
