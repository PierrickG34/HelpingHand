package Core;

import java.util.Date;
import java.util.List;

import UI.CreateActivityCategoryView;
import UI.UpdateActivityCategoryView;

/**
 * Description of ActivityCategoryFacade.
 * 
 * @author pierrickgiuliani
 */
public class ActivityCategoryFacade {

	/**
	 * Description of the property activityCategoryManager.
	 */
	public ActivityCategoryManager activityCategoryManager = new ActivityCategoryManager();
	
	public ActivityCategoryFacade(CreateActivityCategoryView createActivityCategoryView) {
		super();
	}
	
	public ActivityCategoryFacade(UpdateActivityCategoryView updateActivityCategoryView) {
		super();
	}

	public ActivityCategory createActivityCategory(String name, String shortDetail, String longDetail, int idUser) {
		return this.activityCategoryManager.createActivityCategory(name, shortDetail, longDetail, idUser);
	}

	
	public void modifyActivityCategory(int idActivityCategory, String name, String shortdetail, String longdetail) {
		this.activityCategoryManager.modifyActivityCategory(idActivityCategory, name,shortdetail,longdetail);
	}
	
	/**
	 * Maybe a suppr?
	 * @return
	 */
	public List<ActivityCategory> getAllCategories() {
		return this.activityCategoryManager.getAllCategories();
	}

}
