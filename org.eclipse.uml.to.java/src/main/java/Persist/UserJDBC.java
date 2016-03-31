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
import Excpetion.PasswordException;

// End of user code

/**
 * Description of UserJDBC.
 * 
 * @author pierrickgiuliani
 */
public class UserJDBC extends User {
	// Start of user code (user defined attributes for UserJDBC)
	
	/**
	 * Description of the property jDBConnexions.
	 */
	//public JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();

	// End of user code

	public UserJDBC() {
		super();
	}
	/**
	 * The constructor.
	 * @param login
	 */
	public UserJDBC(String login) {
		// Start of user code constructor for UserJDBC
		super(login);
		// Connexion to the database with the login
		
		try {
			this.jDBConnexions.executeRequest("SELECT * FROM Person WHERE email = '" + login + "';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setUser(login);
	}
	
	
	public UserJDBC(String firstName, String surName, String mobile, String mailAddress, String password, Date dateOfBirth, String webSiteURL, String siretNumber, String address) {
		super(firstName, surName, mobile, mailAddress, password, dateOfBirth, webSiteURL, siretNumber, address);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO Person VALUES (DEFAULT, '"+ firstName + "','"+ surName +"','" + mobile + "','" 
					+ mailAddress +"','" + password + "','" + formatter.format(dateOfBirth) + "','" + " " + "','" + webSiteURL + "','" + siretNumber + "', 'false', '"+ address +"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new AlreadyExistException("Your email is already used, please choose an other.");
		}
	}

	// Start of user code (user defined methods for UserJDBC)

	/**
	 * Permit to set the information in the database for the user
	 * @param login 
	 */
	public void setUser(String login) throws LoginException {
		Map m = new HashMap();
		
		// Start of user code for method setUser
		// End of user code
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
				// TODO Auto-generated catch block
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
	

	// End of user code
	/**
	 * Returns jDBConnexions.
	 * @return jDBConnexions 
	 */
	public JDBConnexion getJDBConnexions() {
		return this.jDBConnexions;
	}

	/**
	 * Sets a value to attribute jDBConnexions. 
	 * @param newJDBConnexions 
	 */
	public void setJDBConnexions(JDBConnexion newJDBConnexions) {
		this.jDBConnexions = newJDBConnexions;
	}
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteAccount() {
		try {
			this.jDBConnexions.executeUpdate("DELETE FROM person WHERE iduser = '"+this.getIdUser()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<User> getAllUsers() {
		return this.jDBConnexions.getAllUsers("SELECT * FROM person");
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
