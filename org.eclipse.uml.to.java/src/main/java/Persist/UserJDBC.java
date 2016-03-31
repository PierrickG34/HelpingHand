/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Persist;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Core.User;
import Excpetion.AlreadyExistException;
// Start of user code (user defined imports)
import Excpetion.LoginException;

/**
 * Description of UserJDBC.
 * 
 * @author Helping Hand
 */
public class UserJDBC extends User {

	/**
	 * Description of the property jDBConnexions.
	 */
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();


	/**
	 * Instantiates a new userJDBC.
	 */
	public UserJDBC() {
		super();
	}

	/**
	 * The constructor.
	 *
	 * @param login the login
	 */
	public UserJDBC(String login) {
		super(login);

		try {
			this.jDBConnexions.executeRequest("SELECT * FROM Person WHERE email = '" + login + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.setUser(login);
	}


	/**
	 * Instantiates a new userJDBC.
	 *
	 * @param firstName the first name
	 * @param surName the surname
	 * @param mobile the mobile
	 * @param mailAddress the mail address
	 * @param password the password
	 * @param dateOfBirth the date of birth
	 * @param webSiteURL the web siteurl
	 * @param siretNumber the siretnumber
	 * @param address the address
	 */
	public UserJDBC(String firstName, String surName, String mobile, String mailAddress, String password, Date dateOfBirth, String webSiteURL, String siretNumber, String address) {
		super(firstName, surName, mobile, mailAddress, password, dateOfBirth, webSiteURL, siretNumber, address);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO Person VALUES (DEFAULT, '"+ firstName + "','"+ surName +"','" + mobile + "','" 
					+ mailAddress +"','" + password + "','" + formatter.format(dateOfBirth) + "','" + " " + "','" + webSiteURL + "','" + siretNumber + "', 'false', '"+ address +"')");
		} catch (SQLException e) {
			throw new AlreadyExistException("Your email is already used, please choose an other.");
		}
	}

	/**
	 * Permit to set the information in the database for the user.
	 *
	 * @param login the new user
	 * @throws LoginException the login exception
	 */
	public void setUser(String login) throws LoginException {
		Map m = new HashMap();

		m = this.jDBConnexions.getM();
		if (m.isEmpty()) {
			throw new LoginException("Invalid login");
		}
		else {
			this.setIdUser(Integer.parseInt((String) m.get("iduser")));
			this.setPassword((String) m.get("password"));
			this.setMailAddress((String) m.get("email"));
			this.setFirstName((String) m.get("firstname"));
			this.setSurName((String) m.get("surname"));
			this.setMobile((String) m.get("mobile"));
			this.setAddress((String) m.get("addressuser"));
			this.setProfilePicture((String) m.get("profilepicture"));
			String s =  (String) m.get("dateofbirth");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date d = sdf.parse(s);
				System.out.println(d);
				this.setDateOfBirth(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			this.setWebsiteURL((String) m.get("urlwebsite"));
			this.setSiretNumber((String) m.get("numbersiret"));
			if((String) m.get("admin")=="true")
			{
				this.setAdmin(true);
			}
			else
			{
				this.setAdmin(false);
			}

		}
	}

	/**
	 * Getter jdbc connexion
	 * @return jDBConnexions 
	 */
	public JDBConnexion getJDBConnexions() {
		return this.jDBConnexions;
	}

	/**
	 * Sets a value to attribute jDBConnexions. 
	 *
	 * @param newJDBConnexions the new JDB connexions
	 */
	public void setJDBConnexions(JDBConnexion newJDBConnexions) {
		this.jDBConnexions = newJDBConnexions;
	}

	/* (non-Javadoc)
	 * @see Core.User#modifyAccount(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void modifyAccount(String mobile, String address, String password) {
		if (mobile.isEmpty()) {
			mobile = this.getMobile();
		}
		else {
			this.setMobile(mobile);
		}
		if (address.isEmpty()) {
			address = this.getAddress();
		}
		else {
			this.setAddress(address);		
		}
		if (password.isEmpty()) {
			password = this.getPassword();
		}
		else {
			this.setPassword(password);
		}
		try {
			this.jDBConnexions.executeUpdate("UPDATE person SET mobile = '"+mobile+"', addressuser = '"+address+"', password = '"+password+"' WHERE iduser = '"+this.getIdUser()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modify account.
	 *
	 * @param firstname the firstname
	 * @param lastname the lastname
	 * @param mobile the mobile
	 * @param dateofbirth the dateofbirth
	 * @param address the address
	 * @param siretnumber the siretnumber
	 * @param websiteurl the websiteurl
	 * @param password the password
	 */
	public void modifyAccount(String firstname, String lastname, String mobile, String dateofbirth, String address, String siretnumber, String websiteurl,  String password) {
		if (firstname.isEmpty()){
			firstname = this.getFirstName();
		}
		else {
			this.setFirstName(firstname);
		}
		if (lastname.isEmpty()){
			lastname = this.getSurName();
		}
		else {
			this.setSurName(lastname);
		}
		if (mobile.isEmpty()) {
			mobile = this.getMobile();
		}
		else {
			this.setMobile(mobile);
		}
		if (dateofbirth.isEmpty()) {
			dateofbirth = this.getDateOfBirth().toString();
		}
		else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mi:ss");
			Date d;
			try {
				d = sdf.parse(dateofbirth);
				this.setDateOfBirth(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (address.isEmpty()) {
			address = this.getAddress();
		}
		else {
			this.setAddress(address);		
		}
		if(siretnumber.isEmpty()) {
			siretnumber = this.getSiretNumber();
		}
		else {
			this.setSiretNumber(siretnumber);
		}
		if(websiteurl.isEmpty()) {
			websiteurl = this.getWebsiteURL();
		}
		else {
			this.setWebsiteURL(websiteurl);
		}
		if (password.isEmpty()) {
			password = this.getPassword();
		}
		else {
			this.setPassword(password);
		}
		try {
			this.jDBConnexions.executeUpdate("UPDATE person SET firstname = '"+firstname+"', surname = '"+lastname+"', mobile = '"+mobile+"', dateofbirth = '"+dateofbirth+"', addressuser = '"+address+"', numbersiret = '"+siretnumber+"', urlwebsite = '"+websiteurl+"', password = '"+password+"' WHERE iduser = '"+this.getIdUser()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete account.
	 */
	public void deleteAccount() {
		try {
			this.jDBConnexions.executeUpdate("DELETE FROM person WHERE iduser = '"+this.getIdUser()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public List<User> getAllUsers() {
		return this.jDBConnexions.getAllUsers("SELECT * FROM person");
	}

	/* (non-Javadoc)
	 * @see Core.User#save()
	 */
	@Override
	public void save() {
	}

}
