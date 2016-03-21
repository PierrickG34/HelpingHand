/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Factory;

import java.util.Date;

import Core.ActivityCategory;
import Factory.AbstractFactory;
import Persist.ActivityCategoryJDBC;
import Persist.ProductJDBC;
// Start of user code (user defined imports)
import Persist.UserJDBC;

// End of user code

/**
 * Description of UserFactory.
 * 
 * @author pierrickgiuliani
 */
public class FactoryJDBC extends AbstractFactory {
	
	/**
	 * Description of the property users.
	 */
	public UserJDBC userJDBC = null;
	
	/**
	 * Description of the property activityCategoryJDBC.
	 */
	public ActivityCategoryJDBC activityCategoryJDBC = null;
	

	// Start of user code (user defined attributes for UserFactory)

	// End of user code

	/**
	 * The constructor.
	 */
	public FactoryJDBC() {
		// Start of user code constructor for UserFactory)
		super();
		// End of user code
	}

	/**
	 * Description of the method createUser.
	 * @param login 
	 */
	public UserJDBC createUser(String login) {
		// Start of user code for method createUser
		return new UserJDBC(login);
		// End of user code
	}
	
	public UserJDBC createUser(String firstName, String surName, String mobile, String mailAddress, String password, Date dateOfBirth, String profilePicture, String webSiteURL, String siretNumber, String address) {
		return new UserJDBC(firstName, surName, mobile, mailAddress, password, dateOfBirth, profilePicture, webSiteURL, siretNumber, address);
	}
	
	public ProductJDBC createProduct(String name, float price, int quantity, String category, int idVendeur)
	{ 
		return new ProductJDBC(name,price,quantity,category,idVendeur);
	}
	
	

	// Start of user code (user defined methods for UserFactory)

	// End of user code
	/**
	 * Returns users.
	 * @return users 
	 */
	public UserJDBC getUsers() {
		return this.userJDBC;
	}

	/**
	 * Sets a value to attribute users. 
	 * @param newUsers 
	 */
	public void setUsers(UserJDBC newUsers) {
		this.userJDBC = newUsers;
	}

	@Override
	public ActivityCategoryJDBC createActivityCategory(String name, String shortDetail, String longDetail, int idUser) {
		return new ActivityCategoryJDBC(name, shortDetail, longDetail, idUser);
	}

	@Override
	public ActivityCategory createCategory() {
		return new ActivityCategoryJDBC();
	}
	
	

}
