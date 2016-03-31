/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Core;

import java.util.Date;
import java.util.List;
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
	
	// Start of user code (user defined attributes for UserFacade)
	
	/**
	 * Description of the property userManager.
	 */
	public UserManager userManager = new UserManager();
	// End of user code

	// Start of user code (user defined methods for UserFacade)
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
	
	public UserFacade(User currentUser) {
		this.userManager.setUser(currentUser);
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
							Date dateOfBirth, String webSiteURL, String siretNumber, String address) {
		return this.userManager.signUp(firstName, surName, mobile, mailAddress, password, dateOfBirth, webSiteURL, siretNumber, address);
	}
	
	
	public void modifyAccount(String mobile, String address, String password) {
		this.userManager.modifyAccount(mobile, address, password);
	}
	
	public void modifyAccount(User selected, String firstname, String lastname, String mobile, String dateofbirth, String address, String siretnumber, String websiteurl, String password) {
		this.userManager.modifyAccount(selected, firstname, lastname, mobile, dateofbirth, address, siretnumber, websiteurl, password);
	}
	
	public void deleteAccount(User selected) {
		this.userManager.deleteAccount(selected);
	}
	// End of user code
	/**
	 * Returns userManager.
	 * @return userManager 
	 */
	public UserManager getuserManager() {
		return this.userManager;
	}
	
	public List<User> getAllUsers() {
		return this.userManager.getAllUsers();
	}

	/**
	 * Sets a value to attribute userManager. 
	 * @param newuserManager 
	 */
	/*public void setuserManager(UserManager newUserManager) {
		this.userManager = newUserManager;
	}*/
}
