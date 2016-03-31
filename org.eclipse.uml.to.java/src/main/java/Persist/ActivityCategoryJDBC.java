package Persist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Core.ActivityCategory;
import Excpetion.AlreadyExistException;

/**
 * Description of ActivityCategoryJDBC.
 * 
 * @author Helping Hand
 */
public class ActivityCategoryJDBC extends ActivityCategory {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/**
	 * Instantiates a new activity category jdbc.
	 */
	public ActivityCategoryJDBC() {
		super();
	}

	/**
	 * Instantiates a new activity category jdbc.
	 *
	 * @param name the name
	 * @param shortDetail the short detail
	 * @param longDetail the long detail
	 * @param idUser the id user
	 */
	public ActivityCategoryJDBC(String name, String shortDetail, String longDetail, int idUser) {
		super(name, shortDetail, longDetail);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO ActivityCategory1 VALUES (DEFAULT, '"+ name + "','"+ shortDetail +"','" + longDetail + "','" + idUser + "')");
		} catch (SQLException e) {
			throw new AlreadyExistException("Your activity category is already used, please choose an other.");
		}
	}

	
	/**
	 * Instantiates a new activity category jdbc.
	 *
	 * @param nameTest the name test
	 * @param shortDetailTest the short detail test
	 * @param longDetailTest the long detail test
	 * @param Test the test
	 */
	public ActivityCategoryJDBC(String nameTest, String shortDetailTest, String longDetailTest, String Test) {
		super(nameTest, shortDetailTest, longDetailTest);
	}
	
	/**
	 * Modify activity category.
	 *
	 * @param ac the ac
	 * @param shortdetail the shortdetail
	 * @param longdetail the longdetail
	 */
	public void modifyActivityCategory(ActivityCategory ac, String shortdetail, String longdetail) {
		if (shortdetail.isEmpty()) {
			shortdetail = this.getShortDetail();
		}
		else {
			this.setShortDetail(shortdetail);
		}
		if (longdetail.isEmpty()) {
			longdetail = this.getLongDetail();
		}
		else {
			this.setLongDetail(longdetail);
		}
		try {
			this.jDBConnexions.executeUpdate("UPDATE activitycategory1 SET shortdetail = '"+shortdetail+"', longdetail = '"+longdetail+"' WHERE name = '"+ac.getName()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see Core.ActivityCategory#getAllCategories()
	 */
	@Override
	public List<ActivityCategory> getAllCategories() {
		List<ActivityCategory> list = new ArrayList<ActivityCategory>();
		list = this.jDBConnexions.getAllActivityCategory("SELECT * FROM activitycategory1");
		return list;
	}
}
