package Core;

import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;
import Persist.ActivityCategoryJDBC;

/**
 * The Class ActivityCategoryManager.
 * 
 * @author HelpingHand
 */
 
public class ActivityCategoryManager {
	
	/** The current activity category. */
	private ActivityCategory currentActivityCategory;
	
	/** The user factory. */
	public AbstractFactory userFactorys = new FactoryJDBC();

	/**
	 * The constructor.
	 */
	public ActivityCategoryManager() {
		super();
	}
	
	/**
	 * Creates the activity category.
	 *
	 * @param name the name
	 * @param shortDetail the short detail
	 * @param longDetail the long detail
	 * @param idUser the id user
	 * @return the activity category
	 */
	public ActivityCategory createActivityCategory(String name, String shortDetail, String longDetail, int idUser)
	{		
		return (this.currentActivityCategory = this.userFactorys.createActivityCategory(name, shortDetail, longDetail, idUser));
	}

	/**
	 * Modify activity category.
	 *
	 * @param ac the ac
	 * @param shortdetail the shortdetail
	 * @param longdetail the longdetail
	 */
	public void modifyActivityCategory(ActivityCategory ac, String shortdetail, String longdetail) {
		this.currentActivityCategory = ac;
		ActivityCategoryJDBC currentActivityCategoryJDBC = (ActivityCategoryJDBC) this.currentActivityCategory;
		currentActivityCategoryJDBC.modifyActivityCategory(ac, shortdetail, longdetail);
	}

	/**
	 * Gets the all categories.
	 *
	 * @return the all categories
	 */
	public List<ActivityCategory> getAllCategories() {
		ActivityCategory activityCategory = this.userFactorys.createCategory();
		return activityCategory.getAllCategories();
	}

}
