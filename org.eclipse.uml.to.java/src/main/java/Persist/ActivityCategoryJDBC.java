package Persist;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
	//public JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	public ActivityCategoryJDBC() {
		super();
	}

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

	
	public ActivityCategoryJDBC(String nameTest, String shortDetailTest, String longDetailTest, String Test) {
		super(nameTest, shortDetailTest, longDetailTest);
	}
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ActivityCategory> getAllCategories() {
		List<ActivityCategory> list = new ArrayList<ActivityCategory>();
		list = this.jDBConnexions.getAllActivityCategory("SELECT * FROM activitycategory1");
		return list;
	}
}
