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
		super(name, shortDetail, longDetail);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO ActivityCategory1 VALUES (DEFAULT, '"+ name + "','"+ shortDetail +"','" + longDetail + "','" + idUser + "')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new AlreadyExistException("Your activity category is already used, please choose an other.");
		}
	}
	
	public ActivityCategoryJDBC() {
		super();
		try {
			this.jDBConnexions.executeRequest("select * from activitycategory1 where idactivitycategory = 1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.setName("test");
	}
}
