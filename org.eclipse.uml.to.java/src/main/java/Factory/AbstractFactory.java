/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Factory;

import java.util.Date;

import Core.ActivityCategory;
import Core.User;
import Persist.ProductJDBC;
import Persist.UserJDBC;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of AbstractUserFactory.
 * 
 * @author pierrickgiuliani
 */
public abstract class AbstractFactory {
	// Start of user code (user defined attributes for AbstractUserFactory)

	// End of user code

	/**
	 * The constructor.
	 */
	public AbstractFactory() {
		// Start of user code constructor for AbstractUserFactory)
		super();
		// End of user code
	}

	/**
	 * Description of the method createUser.
	 * @param login 
	 * @return 
	 */
	public abstract User createUser(String login);
	
	public abstract User createUser(String firstName, String surName, String mobile, String mailAddress, String password, 
			Date dateOfBirth, String profilePicture, String webSiteURL, String siretNumber, String address);

	public abstract ActivityCategory createActivityCategory(String name, String shortDetail, String longDetail ,int idUser);
	
	public abstract ProductJDBC createProduct(String name, float price, int quantity, String category, int idVendeur);
	
	// Start of user code (user defined methods for AbstractUserFactory)

	public abstract ActivityCategory createCategory();

	// End of user code

}
