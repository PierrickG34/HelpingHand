package Core;

import java.util.Date;
import java.util.List;

import Persist.ActivityCategoryJDBC;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;

public class ActivityCategoryManager {
	
	private ActivityCategory currentActivityCategory;
	private ActivityCategory[] listActivityCategory;
	public AbstractFactory userFactorys = new FactoryJDBC();

	/**
	 * The constructor
	 */
	public ActivityCategoryManager() {
		super();		// End of user code
	}
	
	public ActivityCategory createActivityCategory(String name, String shortDetail, String longDetail, int idUser)
	{		
		return (this.currentActivityCategory = this.userFactorys.createActivityCategory(name, shortDetail, longDetail, idUser));
	}

	public void modifyActivityCategory(ActivityCategory ac, String shortdetail, String longdetail) {
		this.currentActivityCategory = ac;
		ActivityCategoryJDBC currentActivityCategoryJDBC = (ActivityCategoryJDBC) this.currentActivityCategory;
		currentActivityCategoryJDBC.modifyActivityCategory(ac, shortdetail, longdetail);
	}

	public List<ActivityCategory> getAllCategories() {
		ActivityCategory activityCategory = this.userFactorys.createCategory();
		return activityCategory.getAllCategories();
	}

}
