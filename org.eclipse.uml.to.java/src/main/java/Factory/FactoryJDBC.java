/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Factory;

import java.util.Date;

import Factory.AbstractFactory;
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

}
