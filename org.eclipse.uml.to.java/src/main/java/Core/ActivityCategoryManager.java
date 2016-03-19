package Core;

import java.util.Date;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;

public class ActivityCategoryManager {
	
	private ActivityCategory currentActivityCategory;
	public AbstractFactory userFactorys = new FactoryJDBC();

	/**
	 * The constructor
	 */
	public ActivityCategoryManager() {
		super();		// End of user code
	}
	
	public ActivityCategory createActivityCategory(String name, String shortDetail, String longDetail, int idUser)
	{
//		this.currentUser=this.userFactorys.createUser(login);
//		this.validatePassword(password);
//		return this.currentUser;
		System.out.println("\n\n ActivityCategoryManager --> TODO");
		System.out.println("Name: " + name);
		System.out.println("shortDetail: " + shortDetail);
		System.out.println("longDetail: " + longDetail);
		System.out.println("idUser: " + idUser);
		
		return (this.currentActivityCategory = this.userFactorys.createActivityCategory(name, shortDetail, longDetail, idUser));
	}
}
