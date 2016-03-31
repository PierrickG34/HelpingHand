/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Core;

import java.util.Date;
import java.util.List;

import UI.LoginView;
import UI.ProfileUserModifyView;
import UI.SignUpView;


/**
 * Description of UserFacade.
 * 
 * @author HelpingHand
 */
public class UserFacade {
	
	
	/**
	 * Description of the property userManager.
	 */
	public UserManager userManager = new UserManager();

	/**
	 * The constructor.
	 *
	 * @param user the user
	 */
	public UserFacade(LoginView user) {
		super();
	}

	/**
	 * Instantiates a new user facade.
	 *
	 * @param signUpView the sign up view
	 */
	public UserFacade(SignUpView signUpView) {
		super();
	}

	/**
	 * Instantiates a new user facade.
	 *
	 * @param profileUserModifyView the profile user modify view
	 */
	public UserFacade(ProfileUserModifyView profileUserModifyView) {
		super();
	}
	
	/**
	 * Instantiates a new user facade.
	 *
	 * @param currentUser the current user
	 */
	public UserFacade(User currentUser) {
		this.userManager.setUser(currentUser);
	}

	/**
	 * Description of the method login.
	 *
	 * @param login the login
	 * @param password the password
	 * @return the user
	 */
	public User login(String login, String password) {
		return this.userManager.login(login, password);
	}

	/**
	 * Sign up.
	 *
	 * @param firstName the firstname
	 * @param surName the surname
	 * @param mobile the mobile
	 * @param mailAddress the mail address
	 * @param password the password
	 * @param dateOfBirth the date of birth
	 * @param webSiteURL the web site url
	 * @param siretNumber the siret number
	 * @param address the address
	 * @return the user
	 */
	public User signUp(String firstName, String surName, String mobile, String mailAddress, String password, 
							Date dateOfBirth, String webSiteURL, String siretNumber, String address) {
		return this.userManager.signUp(firstName, surName, mobile, mailAddress, password, dateOfBirth, webSiteURL, siretNumber, address);
	}
	
	
	/**
	 * Modify account.
	 *
	 * @param mobile the mobile
	 * @param address the address
	 * @param password the password
	 */
	public void modifyAccount(String mobile, String address, String password) {
		this.userManager.modifyAccount(mobile, address, password);
	}
	
	/**
	 * Modify account.
	 *
	 * @param selected the selected
	 * @param firstname the firstname
	 * @param lastname the lastname
	 * @param mobile the mobile
	 * @param dateofbirth the dateofbirth
	 * @param address the address
	 * @param siretnumber the siretnumber
	 * @param websiteurl the websiteurl
	 * @param password the password
	 */
	public void modifyAccount(User selected, String firstname, String lastname, String mobile, String dateofbirth, String address, String siretnumber, String websiteurl, String password) {
		this.userManager.modifyAccount(selected, firstname, lastname, mobile, dateofbirth, address, siretnumber, websiteurl, password);
	}
	
	/**
	 * Delete account.
	 *
	 * @param selected the selected
	 */
	public void deleteAccount(User selected) {
		this.userManager.deleteAccount(selected);
	}
	/**
	 * Returns userManager.
	 * @return userManager 
	 */
	public UserManager getuserManager() {
		return this.userManager;
	}
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
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
