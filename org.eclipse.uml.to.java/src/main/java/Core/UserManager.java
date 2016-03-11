package Core;

import java.util.Date;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;

public class UserManager {

	private User currentUser;
	public AbstractFactory userFactorys = new FactoryJDBC();
	
	public UserManager() {
		super();		// End of user code
	}
	
	public User login(String login, String password)
	{
		this.currentUser=this.userFactorys.createUser(login);
		this.validatePassword(password);
		return this.currentUser;
	}
	
	private boolean validatePassword(String password) {
		return this.currentUser.validatePassword(password);
	}
	
	public User getCurrentUser() {
		return this.currentUser;
	}
	
	public User signUp(String firstName, String surName, String mobile, String mailAddress, String password,
			Date dateOfBirth, String profilePicture, String webSiteURL, String siretNumber, String address) {
			return (this.userFactorys.createUser(firstName, surName, mobile, mailAddress, password, dateOfBirth, profilePicture, webSiteURL, siretNumber, address));
	}
}