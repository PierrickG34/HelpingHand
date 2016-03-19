package Persist;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import Core.ActivityCategory;
import Excpetion.AlreadyExistException;

/**
 * Description of ActivityCategoryJDBC.
 * 
 * @author pierrickgiuliani
 */
public class ActivityCategoryJDBC extends ActivityCategory {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	public JDBConnexion jDBConnexions = new JDBConnexion();

	public ActivityCategoryJDBC(String name, String shortDetail, String longDetail, int idUser) {
		// Start of user code constructor for UserJDBC
		super(name, shortDetail, longDetail);
		// Connexion to the database with the login
		
//		try {
//			this.jDBConnexions.executeRequest("TODO");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.setUser(login);
		System.out.println("ActivityCategoryJDBC --> REQUETE TODO");
		System.out.println("Name: " + name);
		System.out.println("shortDetail: " + shortDetail);
		System.out.println("longDetail: " + longDetail);
		System.out.println("idUser: " + idUser);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO ActivityCategory1 VALUES (DEFAULT, '"+ name + "','"+ shortDetail +"','" + longDetail + "','" + idUser + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new AlreadyExistException("Your activity category is already used, please choose an other.");
		}
		
		System.out.println("FIN");
		
	}

}
