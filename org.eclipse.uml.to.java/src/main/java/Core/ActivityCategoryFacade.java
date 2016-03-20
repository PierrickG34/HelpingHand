package Core;

import java.util.Date;

import UI.CreateActivityCategoryView;

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
	
	public ActivityCategory createActivityCategory(String name, String shortDetail, String longDetail, int idUser) {
//		System.out.println("\n\n ActivityCategoryFacade: ");
//		System.out.println("Name: " + name);
//		System.out.println("shortDetail: " + shortDetail);
//		System.out.println("longDetail: " + longDetail);
//		System.out.println("idUser: " + idUser);
		return this.activityCategoryManager.createActivityCategory(name, shortDetail, longDetail, idUser);
}

}
