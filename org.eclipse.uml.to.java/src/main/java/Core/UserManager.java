package Core;

import java.util.Date;
import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;
import Persist.UserJDBC;

// TODO: Auto-generated Javadoc
/**
 * The Class UserManager.
 */
public class UserManager {

	/** The current user. */
	private User currentUser;
	
	/** The user factorys. */
	public AbstractFactory userFactorys = new FactoryJDBC();
	
	/**
	 * Instantiates a new user manager.
	 */
	public UserManager() {
		super();		// End of user code
	}
	
	/**
	 * Login.
	 *
	 * @param login the login
	 * @param password the password
	 * @return the user
	 */
	public User login(String login, String password)
	{
		this.currentUser=this.userFactorys.createUser(login);
		this.validatePassword(password);
		return this.currentUser;
	}
	
	/**
	 * Validate password.
	 *
	 * @param password the password
	 * @return true, if successful
	 */
	private boolean validatePassword(String password) {
		return this.currentUser.validatePassword(password);
	}
	
	/**
	 * Gets the current user.
	 *
	 * @return the current user
	 */
	public User getCurrentUser() {
		return this.currentUser;
	}
	
	/**
	 * Sign up.
	 *
	 * @param firstName the first name
	 * @param surName the sur name
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
		return (this.userFactorys.createUser(firstName, surName, mobile, mailAddress, password, dateOfBirth, webSiteURL, siretNumber, address));
	}
	
	/**
	 * Modify account.
	 *
	 * @param mobile the mobile
	 * @param address the address
	 * @param password the password
	 */
	public void modifyAccount(String mobile, String address, String password) {
		UserJDBC userJDBC = (UserJDBC) this.currentUser;
		userJDBC.modifyAccount(mobile,address,password);
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
		UserJDBC userJDBC = (UserJDBC) selected;
		userJDBC.modifyAccount(firstname, lastname, mobile, dateofbirth, address, siretnumber, websiteurl, password);
	}
	
	/**
	 * Delete account.
	 *
	 * @param selected the selected
	 */
	public void deleteAccount(User selected) {
		UserJDBC userJDBC = (UserJDBC) selected;
		userJDBC.deleteAccount();
	}
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public List<User> getAllUsers() {
		UserJDBC userJDBC = (UserJDBC) this.currentUser;
		return userJDBC.getAllUsers();
	}

	/**
	 * Sets the user.
	 *
	 * @param currentUser2 the new user
	 */
	public void setUser(User currentUser2) {
		// TODO Auto-generated method stub
		this.currentUser = currentUser2;
	}
}
