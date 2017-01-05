package whats.newin.j2se7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class JDBCUpdates {
	
	private void createNPrintRowSets(RowSetFactory rsFact) throws SQLException {
		JdbcRowSet     jdbcRs = rsFact.createJdbcRowSet();
		CachedRowSet   cachRs = rsFact.createCachedRowSet();  
		FilteredRowSet filtRs = rsFact.createFilteredRowSet(); 
		JoinRowSet 	   joinRs = rsFact.createJoinRowSet();        
		WebRowSet      webRs  = rsFact.createWebRowSet();         
		System.out.println("Got RowSetFactory " + rsFact.getClass() + " which produced: \n\t" +
							"JdbcRowSet    : " + jdbcRs.getClass() + "\n\t" +
							"CachedRowSet  : " + cachRs.getClass() + "\n\t" +
							"FilteredRowSet: " + filtRs.getClass() + "\n\t" +
							"JoinRowSet    : " + joinRs.getClass() + "\n\t" +
							"WebRowSet     : " + webRs.getClass());
	}

	private void rowSetUpdates(Connection conn) {
		RowSetFactory rsFact = null;
		try {
			System.setProperty("javax.sql.rowset.RowSetProvider.debug", "true");
			
			rsFact = RowSetProvider.newFactory();
			createNPrintRowSets(rsFact);
		
			pauseConsole("To Explicitly use MyRowSetFactory");	  
			
			rsFact = RowSetProvider.newFactory("whats.newin.j2se7.MyRowSetFactory", null);
			createNPrintRowSets(rsFact);
			
			pauseConsole("To Implicitly use MyRowSetFactory");	  
			
			System.setProperty("javax.sql.rowset.RowSetFactory", 
							   "whats.newin.j2se7.MyRowSetFactory");
			rsFact = RowSetProvider.newFactory();
			createNPrintRowSets(rsFact);
						
		} catch (SQLException e) {
			System.out.println("Caught SQL Exception " + e.getMessage());
			e.printStackTrace();
			return;
		}
	}






	private void callableStmUpdate(Connection conn) {
 
		try (CallableStatement cs = conn.prepareCall("{call GET_PLANT_BY_ID(?, ?)}")) {
	    	long id = 1;
			cs.setLong(1, id);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.execute();

			String plant = cs.getObject(2, String.class);
			System.out.println("Got String plant " + plant);
	
		} catch (SQLException e) {
			System.out.println("Caught SQL Exception " + e.getMessage());
			e.printStackTrace();
			return;
		}
		pauseConsole("To retrieve Object from ResultSet");	  
		try (Statement st = conn.createStatement();
			 ResultSet rs = st.executeQuery("SELECT * FROM location WHERE id = 1")) {
			while (rs.next()) {
				int id = rs.getInt(1);
				Integer addr  = rs.getObject("ADDR", Integer.class);
				String street = rs.getObject(3, String.class);
				
				System.out.println("Location for " + id + ": " + addr +" " + street);
				
				pauseConsole("To retrieve add in a different type");	  
				
				Float addr2  = rs.getObject("ADDR", Float.class);
				System.out.println("Location for " + id + ": " + addr2 +" " + street);
			}		
		} catch (SQLException e) {
			System.out.println("Caught SQL Exception " + e.getMessage());
			e.printStackTrace();
			return;
		}
	}


	
	
	private void createProcedure(Connection conn)  throws SQLException {
		String queryDropGetPlantById = "DROP PROCEDURE GET_PLANT_BY_ID";
		String queryGetPlantById =
				"CREATE PROCEDURE GET_PLANT_BY_ID(IN plantID BIGINT, OUT plantName VARCHAR(255)) " +
						"PARAMETER STYLE JAVA " +
						"LANGUAGE JAVA " +
						"DYNAMIC RESULT SETS 0 " +
						"EXTERNAL NAME 'whats.newin.j2se7.PlantProcedure.getPlantById'";
		
		System.out.println("Calling DROP PROCEDURE");
		try (Statement stmtDropGetPlantById = conn.createStatement()){
			stmtDropGetPlantById.execute(queryDropGetPlantById);
		} catch (SQLException e) {
	   		System.out.println("Caught SQL Exception " + e.getMessage());
			e.printStackTrace();
		}

		System.out.println("Calling CREATE PROCEDURE");
		try (Statement stmtCreateGetPlantById = conn.createStatement()){
			stmtCreateGetPlantById.execute(queryGetPlantById);
		} catch (SQLException e) {
	   		System.out.println("Caught SQL Exception " + e.getMessage());
			e.printStackTrace();
			return;
		}

	    System.out.println("\nCalling the stored procedure GET_PLANT_BY_ID");
	    try (CallableStatement cs = conn.prepareCall("{call GET_PLANT_BY_ID(?, ?)}")) {
	    	long id = 2;
			cs.setLong(1, id);
			cs.registerOutParameter(2,  Types.VARCHAR);
			cs.execute();
	           
			String plantName = cs.getString(2);
	      
			if (plantName != null) {
				System.out.println("\nPlant at ID " + id + ": " + plantName);          
			} else {
				System.out.println("\nUnable to find the Plant for ID " + id);        
			}

	    } catch (SQLException e) {
	   		System.out.println("Caught SQL Exception " + e.getMessage());
			e.printStackTrace();
	    } 
	}


	
	
	private void createTable(Connection conn) {

		try (Statement st = conn.createStatement()) {
			st.execute("drop table Plants");
			System.out.println("Dropped table Plants");
			st.execute("create table Plants(Id BIGINT, Plant VARCHAR(255), Type VARCHAR(255))");
			System.out.println("Created table Plants");

			st.execute("drop table Location");
			System.out.println("Dropped table Location");
			st.execute("create table Location(id int, addr int, street varchar(40))");
			try (PreparedStatement ps = conn.prepareStatement("insert into Plants values (?, ?, ?)"))  {
				// parameter 1 is id (long), 2 is plant (varchar), 3 is type (varchar)
			System.out.println("Created table Location");

				ps.setLong(1, 1);
				ps.setString(2, "Holly");
				ps.setString(3, "Bush");
				ps.executeUpdate();
				System.out.println("Inserted Holly");

				ps.setLong(1, 2);
				ps.setString(2, "Purple Heart");
				ps.setString(3, "Perenial");
				ps.executeUpdate();
				System.out.println("Inserted Purple Heart");

				ps.setLong(1, 3);
				ps.setString(2, "Parsley");
				ps.setString(3, "Herb");
				ps.executeUpdate();
				System.out.println("Inserted Parsley");

				ps.setLong(1, 4);
				ps.setString(2, "Tulip");
				ps.setString(3, "Blub");
				ps.executeUpdate();
				System.out.println("Inserted Tulip");

				ps.setLong(1, 5);
				ps.setString(2, "Petunia");
				ps.setString(3, "Annual");
				ps.executeUpdate();
				System.out.println("Inserted Petunia");

			} catch (SQLException e) {
				System.out.println("populate plant Caught SQL Exception " + e.getMessage());
				e.printStackTrace();
			}			
			try (PreparedStatement ps = conn.prepareStatement("insert into location values (?, ?, ?)"))  {
				// parameter 1 is id (int), 2 is addr (int), 3 is street (varchar) 
	            ps.setInt(1, 1);
	            ps.setInt(2, 1956);
	            ps.setString(3, "Webster St.");
	            ps.executeUpdate();
	            System.out.println("Inserted 1956 Webster");

	            ps.setInt(1, 2);
	            ps.setInt(2, 1910);
	            ps.setString(3, "Union St.");
	            ps.executeUpdate();
	            System.out.println("Inserted 1910 Union");
	            
			} catch (SQLException e) {
				System.out.println("populate location Table Statement Caught SQL Exception " + e.getMessage());
				e.printStackTrace();
			}			
		} catch (SQLException e) {
			System.out.println("Create Table Statement Caught SQL Exception " + e.getMessage());
			e.printStackTrace();
		}			
	}

	private void controlOutParmType(Connection conn) {
//		createTable(conn);           // create plants table
//        try {
//			createProcedure(conn);
//		} catch (SQLException e) {
//			System.out.println("Create Table Statement Caught SQL Exception " + e.getMessage());
//			e.printStackTrace();
//		}        // create stored procedures
		callableStmUpdate(conn);
	}




	private void statementUpdates(Connection conn) {
        Statement st;
        ResultSet rset;
		try {
		  st = conn.createStatement();
		  System.out.println("Will Statement Close On Result Set Close? =>"+ st.isCloseOnCompletion());

		  pauseConsole("To set close on completion");	  

		  st.closeOnCompletion();
		  System.out.println("Now will Statement Close On Result Set Close? =>"+ st.isCloseOnCompletion());

		  pauseConsole("To get a result set");	  

		  rset = st.executeQuery("SELECT * FROM location");
		  while (rset.next()) {
			  System.out.println(rset.getString(1) + ", " + rset.getString(2));
		  }
		  System.out.println("\nIs Statement Closed? =>" + st.isClosed());
			 
		  pauseConsole("To close resultSet and implicitly close Statement");	  
	        
		  rset.close();
		  System.out.println("Is Statement Closed? =>" + st.isClosed());

		} catch (SQLException e) {
	   		System.out.println("Caught SQL Exception " + e.getMessage());
			e.printStackTrace();
		}	
	}


    private void dbMetaDataUpdates(Connection conn) {
    	ResultSet resSet = null;
    	try {
		 DatabaseMetaData meta = conn.getMetaData();
			 System.out.println("DatabaseMetaData Values\n\t" +
					 "Database Product: " + meta.getDatabaseProductName() + " " + meta.getDatabaseProductVersion() + "\n\t" +
					 "Database Driver : " + meta.getDriverName() + " " + meta.getDriverVersion() + "\n\t" +
					 "Supports Get Generated Keys?  " + meta.supportsGetGeneratedKeys() + "\n\t" +
					 "Generated Keys Always Return? " + meta.generatedKeyAlwaysReturned() +"\n\t" +
					 "Supporteds Stored Procedures? " + meta.supportsStoredProcedures()
					 );
			 
			 pauseConsole("To retrieve tables and columns");

			 resSet = meta.getTables(null, null, null, null);
			 System.out.println("Tables: <Catalog, Schema, Name, Type> ");
			 while (resSet.next()) {
				 String catalog = resSet.getString(1);
				 String schema  = resSet.getString(2);
				 String table = resSet.getString(3);
				 String ttype = resSet.getString(4);
				 System.out.println(catalog + ", " + schema + ", " + table + ", " + ttype);
				 ResultSet rr = meta.getColumns(null, schema, table, null);
				 while (rr.next())  {
					 String column   = rr.getString(4);
					 String dataType = rr.getString(6);
					 String generatedColumn = rr.getString(24);
					 int size = rr.getInt(7);
					 System.out.println("\t " + column + "(" + dataType + ", " + 
							 			size +", generated? "+ generatedColumn+")");
				 }
			 }
			 
			 pauseConsole("To see getPseudoColumns method");

			 resSet = meta.getPseudoColumns(null, "USER1", "LOCATION", null);
			 System.out.println("Pseudo Columns: <Column Name, Data Type, size, is Nullable> ");
			 while (resSet.next()) {
				 String column= resSet.getString(4);
				 int dataType = resSet.getInt(5);
				 int colSize  = resSet.getInt(6);
				 String isNullable = resSet.getString(12);
				 System.out.println(column + "(" + dataType + ", " + colSize + ", "
				 					+ "	nullable?" + isNullable + ")");
			 }
    	} catch (SQLException e) {
    		System.out.println("Caught SQL Exception " + e.getMessage());
    		e.printStackTrace();
    	}
    }
    
      private void connectionUpdates(Connection conn) {
    	try {
			System.out.println("Schema name is " + conn.getSchema() + "\n");
			conn.setSchema("APP");
			System.out.println("New Schema name is " + conn.getSchema() + "\n");
	         
			pauseConsole("To see Connection NetworkTimeout methods");
			int numThreads = 5;
			Executor exec = Executors.newFixedThreadPool(numThreads);

			try {
	        	 System.out.println("NetworkTimeout is " + conn.getNetworkTimeout() + " mlliseconds");
	        	 conn.setNetworkTimeout(exec, 1000000);
	         
	        	 System.out.println("NetworkTimeout is now " + conn.getNetworkTimeout() + " mlliseconds");
			
			} catch (SQLFeatureNotSupportedException e) {
				System.out.println("Caught Unsupported Exception " + e.getMessage());
				e.printStackTrace();
			}
	        
			Thread.sleep(1000);
			pauseConsole("To see Connection.abort(Executor) methods");
			System.out.println("Calling Connection.abort(Executor)");
			conn.abort(exec);
	     	
    	} catch (SQLException | InterruptedException e) {
    		System.out.println("Caught SQL Exception " + e.getMessage());
    		e.printStackTrace();
    	}

    }

 

    /**
     * Reports a data verification failure to System.err with the given message.
     *
     * @param message A message describing what failed.
     */
    private void reportFailure(String message) {
        System.err.println("\nData verification failed:");
        System.err.println('\t' + message);
    }

    /**
     * Prints details of an SQLException chain to <code>System.err</code>.
     * Details included are SQL State, Error code, Exception message.
     *
     * @param e the SQLException from which to print details.
     */
    public static void printSQLException(SQLException e)
    {
        // Unwraps the entire exception chain to unveil the real cause of the
        // Exception.
        while (e != null)
        {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            // for stack traces, refer to derby.log or uncomment this:
            //e.printStackTrace(System.err);
            e = e.getNextException();
        }
    }

    private String framework = "embedded";
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby:";

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
    	 JDBCUpdates myObj = new JDBCUpdates();
    	 String   dbName = "derbyDB";           // the name of the database
         Properties props = new Properties();   // connection properties
         props.put("user", "user1");
         props.put("password", "user1");

       	 myObj.loadDriver();
       	 try (Connection conn = DriverManager.getConnection(myObj.protocol + dbName, props)) {
          	 // myObj.tryWithResources(conn);
          	 // myObj.statementUpdates(conn);
          	 // myObj.connectionUpdates(conn);
	         // myObj.dbMetaDataUpdates(conn);
       		 //myObj.controlOutParmType(conn); 
       		 myObj.rowSetUpdates(conn);
 		} catch (SQLException e) {
	         System.out.println("Got exception:" + e.getMessage());
			e.printStackTrace();
		}
         System.out.println("Exiting");
    }
    

	private static void pauseConsole(String doNext) {
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			System.out.println("\nHit Enter to "+ doNext +":>");
			cin.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}
