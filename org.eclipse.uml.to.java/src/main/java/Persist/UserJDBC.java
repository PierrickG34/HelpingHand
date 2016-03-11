/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Persist;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
	public JDBConnexion jDBConnexions = new JDBConnexion();

	// End of user code

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
	
	
	public UserJDBC(String firstName, String surName, String mobile, String mailAddress, String password, Date dateOfBirth, String profilePicture, String webSiteURL, String siretNumber, String address) {
		super(firstName, surName, mobile, mailAddress, password, dateOfBirth, profilePicture, webSiteURL, siretNumber, address);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO Person VALUES (DEFAULT, '"+ firstName + "','"+ surName +"','" + mobile + "','" 
					+ mailAddress +"','" + password + "','" + formatter.format(dateOfBirth) + "','" + profilePicture + "','" + webSiteURL + "','" + siretNumber + "', 'false', '"+ address +"')");
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
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

}
