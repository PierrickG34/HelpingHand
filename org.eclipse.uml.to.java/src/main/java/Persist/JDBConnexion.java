/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of JDBConnexion.
 * 
 * @author pierrickgiuliani
 */
public class JDBConnexion {
	// Start of user code (user defined attributes for JDBConnexion)
	/**
	 * 
	 */
	private Connection conn;
	
	/**
	 * 
	 */
	private ResultSetMetaData resultMeta;
	
	/**
	 * 
	 */
	private ResultSet rs;
	
	/**
	 * 
	 */
	private HashMap m;
	// End of user code

	/**
	 * The constructor to connect to the database
	 * @param login
	 */
	public JDBConnexion() {
		// Start of user code constructor for JDBConnexion)
		super();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Driver O.K.");

		String url = "jdbc:postgresql://ec2-54-227-245-197.compute-1.amazonaws.com:5432/d4i5fck68498ce?sslmode=require";
		String user = "ambpfzhcrpupmx";
		String passwd = "PeSnt07zQFVWKQrsqcRd1GzW6I";

		System.out.println("Connexion sur: ");
		System.out.println("**USER = " +user);
		System.out.println("**PassWord = " +passwd);
		System.out.println("**URL = " +url);
		
		try {
			this.openConnexion(url, user, passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public HashMap getM() {
		return m;
	}


	public void setM(HashMap m) {
		this.m = m;
	}


	/**
	 * Description of the method openConnexion.
	 * @return true if the connexion is established
	 * @param url
	 * @param user
	 * @param passwd
	 * @throws SQLException 
	 */
	public Boolean openConnexion(String url, String user, String passwd) throws SQLException {
		// Start of user code for method openConnexion
		boolean isConnected = false;
		this.conn = DriverManager.getConnection(url, user, passwd);
		isConnected = true;
		System.out.println("\nConnexion effective !\n");
		return(isConnected);
		// End of user code
	}

	/**
	 * Extract the data from the database
	 * @return a map with the data
	 * @throws SQLException
	 */
	public Map extractData() throws SQLException {
		Map m = new HashMap();
		
		while(this.rs.next()){
			for(int i = 1; i <= this.resultMeta.getColumnCount(); i++) {
				m.put(this.resultMeta.getColumnName(i), this.rs.getObject(i).toString());
			}
		}
		rs.close();
		
		System.out.println("... Statement finish \n");

		return m;
	}


	/**
	 * Description of the method close.
	 */
	public void close() {
		// Start of user code for method close
		// End of user code
	}

	/**
	 * Description of the method executeRequest.
	 * @param request 
	 * @throws SQLException 
	 */
	public void executeRequest(String request) throws SQLException {
		// Start of user code for method executeRequest

		// End of user code

		java.sql.Statement stmt = null;
		System.out.println("Creating statement...");
		stmt = this.conn.createStatement();
		this.rs = stmt.executeQuery(request);
		this.resultMeta = this.rs.getMetaData();

		this.m = (HashMap) extractData();
		
		// End of user code
	}
	
	public void executeUpdate(String request) throws SQLException {
		java.sql.Statement stmt = null;
		System.out.println("Creating statement...");
		stmt = this.conn.createStatement();
		stmt.executeUpdate(request);
	}

	/**
	 * Description of the method fetchArray.
	 */
	public void fetchArray() {
		// Start of user code for method fetchArray
		// End of user code
	}

	/**
	 * Description of the method nbReponse.
	 * @return 
	 */
	public Integer nbReponse() {
		// Start of user code for method nbReponse
		Integer nbReponse = Integer.valueOf(0);
		return nbReponse;
		// End of user code
	}

	// Start of user code (user defined methods for JDBConnexion)

	// End of user code
}
