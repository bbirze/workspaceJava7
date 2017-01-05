package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class TryWithResources {
    private String driver   = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby:";

	private void oldCloseDB() {
    	String   dbName = "derbyDB";           
    	Properties props= new Properties();   
    	Connection conn = null;    	// must be closed
    	Statement  st   = null;    	// must be closed
    	ResultSet  rset = null;    	// must be closed
    	try  {
    		conn = DriverManager.getConnection(protocol + dbName, props);
    		st = conn.createStatement();
    		rset = st.executeQuery("SELECT * FROM location");

    		while (rset.next()) {
    			System.out.println(rset.getString(1) + ", " + rset.getString(2));
    		}
    		// can't close resources here... 
    	} catch (SQLException e) {
    		System.out.println("Got exception:" + e.getMessage());
    	}
    	finally {
    		if (rset != null)
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    		if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
    	}		
	}


	private void newCloseDB() {
    	String   dbName = "derbyDB";           
    	Properties props = new Properties();   

    	try (Connection conn = DriverManager.getConnection(protocol + dbName, props)) {

    		try (Statement st = conn.createStatement();
    			 ResultSet rset = st.executeQuery("SELECT * FROM location")){

    			while (rset.next()) {
    				System.out.println(rset.getString(1) + ", " + rset.getString(2));
    			}

    		} catch (SQLException e) {
    			System.out.println("Got exception:" + e.getMessage());
    		}
    	} catch (SQLException e) {
    		System.out.println("Got exception:" + e.getMessage());
    	}		
    }
	

	private void newCloseDB2() {
    	String   dbName = "derbyDB";           
    	Properties props = new Properties();   

    	try (Connection conn = DriverManager.getConnection(protocol + dbName, props);
    		 Statement  st   = conn.createStatement();
    		 ResultSet  rset = st.executeQuery("SELECT * FROM location")){

    		while (rset.next()) {
    			System.out.println(rset.getString(1) + ", " + rset.getString(2));
    		}
    	} catch (SQLException e) {
    		System.out.println("Got exception:" + e.getMessage());
    	}
    }
	

	
	private void loadDriver() {
        try {
           Class.forName(driver).newInstance();
       } catch (ClassNotFoundException cnfe) {
           System.err.println("\nUnable to load the JDBC driver " + driver);
           System.err.println("Please check your CLASSPATH.");
           cnfe.printStackTrace(System.err);
       } catch (InstantiationException ie) {
           System.err.println("\nUnable to instantiate the JDBC driver " + driver);
           ie.printStackTrace(System.err);
       } catch (IllegalAccessException iae) {
           System.err.println(
                       "\nNot allowed to access the JDBC driver " + driver);
           iae.printStackTrace(System.err);
       }
   }

    public static void main(String[] args)
    {
    	 TryWithResources myObj = new TryWithResources();
 
         myObj.loadDriver();

         myObj.oldCloseDB();
         myObj.newCloseDB();
         myObj.newCloseDB2();
       	 System.out.println("Exiting");
    }
    


}
