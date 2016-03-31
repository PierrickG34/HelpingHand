package Core;

import java.util.List;

import UI.CreateActivityCategoryView;
import UI.CreatePlanSellerView;
import UI.CreatePlanUserView;
import UI.CreatePlanView;
import UI.UpdateActivityCategoryView;

/**
 * Description of ActivityCategoryFacade.
 * 
 * @author HelpingHand
 */
public class ActivityCategoryFacade {

	/**
	 * Description of the property activityCategoryManager.
	 */
	public ActivityCategoryManager activityCategoryManager = new ActivityCategoryManager();
	
	/**
	 * Instantiates a new activity category facade.
	 *
	 * @param createActivityCategoryView the create activity category view
	 */
	public ActivityCategoryFacade(CreateActivityCategoryView createActivityCategoryView) {
		super();
	}
	
	/**
	 * Instantiates a new activity category facade.
	 *
	 * @param updateActivityCategoryView the update activity category view
	 */
	public ActivityCategoryFacade(UpdateActivityCategoryView updateActivityCategoryView) {
		super();
	}

	/**
	 * Instantiates a new activity category facade.
	 *
	 * @param createPlanView the create plan view
	 */
	public ActivityCategoryFacade(CreatePlanView createPlanView) {
		super();
	}

	/**
	 * Instantiates a new activity category facade.
	 *
	 * @param createPlanUserView the create plan user view
	 */
	public ActivityCategoryFacade(CreatePlanUserView createPlanUserView) {
		super();
	}

	/**
	 * Instantiates a new activity category facade.
	 *
	 * @param createPlanSellerView the create plan seller view
	 */
	public ActivityCategoryFacade(CreatePlanSellerView createPlanSellerView) {
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
	public ActivityCategory createActivityCategory(String name, String shortDetail, String longDetail, int idUser) {
		return this.activityCategoryManager.createActivityCategory(name, shortDetail, longDetail, idUser);
	}

	
	/**
	 * Modify activity category.
	 *
	 * @param ac the ac
	 * @param shortdetail the shortdetail
	 * @param longdetail the longdetail
	 */
	public void modifyActivityCategory(ActivityCategory ac, String shortdetail, String longdetail) {
		this.activityCategoryManager.modifyActivityCategory(ac,shortdetail,longdetail);
	}
	
	/**
	 * Gets the all categories.
	 *
	 * @return the all categories
	 */
	public List<ActivityCategory> getAllCategories() {
		return this.activityCategoryManager.getAllCategories();
	}

}
