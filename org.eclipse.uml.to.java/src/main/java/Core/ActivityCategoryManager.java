package Core;

import java.util.Date;
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
	
	public ActivityCategory[] readActivityCategory() {
		return (this.listActivityCategory = this.userFactorys.readActivityCategory());
	}
	
	public void modifyActivityCategory(int idActivityCategory, String name, String shortdetail, String longdetail) {
		System.out.println("AC"+this.currentActivityCategory);
		ActivityCategoryJDBC currentActivityCategoryJDBC = (ActivityCategoryJDBC) this.currentActivityCategory;
		System.out.println("2");
		currentActivityCategoryJDBC.modifyActivityCategory(idActivityCategory, name, shortdetail, longdetail);
	}
}
