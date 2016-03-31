package Core;

import java.util.Date;
import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;
import Persist.UserJDBC;

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
		Date dateOfBirth, String webSiteURL, String siretNumber, String address) {
		return (this.userFactorys.createUser(firstName, surName, mobile, mailAddress, password, dateOfBirth, webSiteURL, siretNumber, address));
	}
	
	public void modifyAccount(String mobile, String address, String password) {
		UserJDBC userJDBC = (UserJDBC) this.currentUser;
		userJDBC.modifyAccount(mobile,address,password);
	}
	
	public void modifyAccount(User selected, String firstname, String lastname, String mobile, String dateofbirth, String address, String siretnumber, String websiteurl, String password) {
		UserJDBC userJDBC = (UserJDBC) selected;
		userJDBC.modifyAccount(firstname, lastname, mobile, dateofbirth, address, siretnumber, websiteurl, password);
	}
	
	public void deleteAccount(User selected) {
		UserJDBC userJDBC = (UserJDBC) selected;
		userJDBC.deleteAccount();
	}
	
	public List<User> getAllUsers() {
		UserJDBC userJDBC = (UserJDBC) this.currentUser;
		return userJDBC.getAllUsers();
	}

	public void setUser(User currentUser2) {
		// TODO Auto-generated method stub
		this.currentUser = currentUser2;
	}
}
