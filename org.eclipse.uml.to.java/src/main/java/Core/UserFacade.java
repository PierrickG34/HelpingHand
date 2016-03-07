/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Core;

import java.util.Date;
import java.util.Observable;

import Factory.FactoryJDBC;
import UI.LoginView;
import UI.ProfileUserModifyView;
import UI.SignUpView;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of UserFacade.
 * 
 * @author pierrickgiuliani
 */
public class UserFacade {
	
	/**
	 * Description of the property userManager.
	 */
	public UserManager userManager = new UserManager();

	// Start of user code (user defined attributes for UserFacade)

	// End of user code

	/**
	 * The constructor.
	 * @param LoginView correspond a user
	 */
	public UserFacade(LoginView user) {
		// Start of user code constructor for UserFacade)
		super();
		// End of user code
	}

	public UserFacade(SignUpView signUpView) {
		super();
	}

	public UserFacade(ProfileUserModifyView profileUserModifyView) {
		super();
	}

	/**
	 * Description of the method login.
	 * @param login 
	 * @param password 
	 */
	public User login(String login, String password) {
		// Start of user code for method login
		return this.userManager.login(login, password);
		// End of user code
	}

	/**
	 * 
	 */
	public User signUp(String firstName, String surName, String mobile, String mailAddress, String password, 
							Date dateOfBirth, String profilePicture, String webSiteURL, String siretNumber, String address) {
		return this.userManager.signUp(firstName, surName, mobile, mailAddress, password, dateOfBirth, profilePicture, webSiteURL, siretNumber, address);
	}
	// Start of user code (user defined methods for UserFacade)

	// End of user code
	/**
	 * Returns userManager.
	 * @return userManager 
	 */
	public UserManager getuserManager() {
		return this.userManager;
	}

	/**
	 * Sets a value to attribute userManager. 
	 * @param newuserManager 
	 */
	public void setuserManager(UserManager newUserManager) {
		this.userManager = newUserManager;
	}
}
