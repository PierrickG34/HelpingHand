/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Core;

import java.util.Date;

import Excpetion.LoginException;
import Excpetion.PasswordException;
import Persist.UserJDBC;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of User.
 * 
 * @author pierrickgiuliani
 */
public abstract class User {
	
	/**
	 * Description of the property idUser.
	 */
	private Integer idUser = Integer.valueOf(0);

	//beule
	/**
	 * Description of the property password.
	 */
	private String password = "";

	/**
	 * Description of the property firstName.
	 */
	private String firstName = "";

	/**
	 * Description of the property surName.
	 */
	private String surName = "";

	/**
	 * Description of the property mobile.
	 */
	private String mobile = "";

	/**
	 * Description of the property mailAddress.
	 */
	private String mailAddress = "";

	/**
	 * Description of the property dateOfBirth.
	 */
	private Date dateOfBirth;

	/**
	 * Description of the property profilePicture.
	 */
	private String profilePicture = "";

	/**
	 * Description of the property siretNumber.
	 */
	private String siretNumber = "";

	/**
	 * Description of the property websiteURL.
	 */
	private String websiteURL = "";

	/**
	 * Description of the property admin.
	 */
	private Boolean admin = Boolean.FALSE;
	
	/**
	 * Description of the address (postal)
	 */
	
	private String address = "";

	// Start of user code (user defined attributes for User)

	// End of user code

	/**
	 * The constructor.
	 * @param login
	 */
	public User(String login) {
		// Start of user code constructor for User)
		super();
		this.mailAddress = login;
		// End of user code
	}
	
	public User(String firstName, String surName, String mobile, String mailAddress, String password, 
			Date dateOfBirth, String profilePicture, String webSiteURL, String siretNumber, String address) {
		super();
		this.firstName = firstName;
		this.surName = surName;
		this.mobile = mobile;
		this.mailAddress = mailAddress;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.profilePicture = profilePicture;
		this.websiteURL = webSiteURL;
		this.siretNumber = siretNumber;
		this.address = address;
	}
	
	public abstract void save();

	/**
	 * Description of the method validatePassword.
	 * @param passwordIn
	 * @return true if the password correspond, else false
	 */
	public boolean validatePassword(String passwordIn) {
		// Start of user code for method validatePassword
		if (!passwordIn.equals(this.password)) {
			throw new PasswordException("Invalid password");
		}
		return passwordIn.equals(this.password);
		// End of user code	
	}

	/**
	 * Description of the method setUser.
	 * @param login 
	 */
	/*public void setUser(String login) {
		// Start of user code for method setUser
		UserJDBC userJDBC = (UserJDBC) this;
		userJDBC.setUser(this.mailAddress);
		// End of user code
	}*/

	// Start of user code (user defined methods for User)

	// End of user code
	/**
	 * Returns idUser.
	 * @return idUser 
	 */
	public Integer getIdUser() {
		return this.idUser;
	}

	/**
	 * Sets a value to attribute idUser. 
	 * @param newIdUser 
	 */
	public void setIdUser(Integer newIdUser) {
		this.idUser = newIdUser;
	}

	/**
	 * Returns password.
	 * @return password 
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets a value to attribute password. 
	 * @param newPassword 
	 */
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	/**
	 * Return address postal
	 * @return
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Sets a value to attribute address
	 * @param newAddress
	 */
	public void setAddress(String newAddress) {
		this.address = newAddress;
	}

	/**
	 * Returns firstName.
	 * @return firstName 
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets a value to attribute firstName. 
	 * @param newFirstName 
	 */
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	/**
	 * Returns surName.
	 * @return surName 
	 */
	public String getSurName() {
		return this.surName;
	}

	/**
	 * Sets a value to attribute surName. 
	 * @param newSurName 
	 */
	public void setSurName(String newSurName) {
		this.surName = newSurName;
	}

	/**
	 * Returns mobile.
	 * @return mobile 
	 */
	public String getMobile() {
		return this.mobile;
	}

	/**
	 * Sets a value to attribute mobile. 
	 * @param newMobile 
	 */
	public void setMobile(String newMobile) {
		this.mobile = newMobile;
	}

	/**
	 * Returns mailAddress.
	 * @return mailAddress 
	 */
	public String getMailAddress() {
		return this.mailAddress;
	}

	/**
	 * Sets a value to attribute mailAddress. 
	 * @param newMailAddress 
	 */
	public void setMailAddress(String newMailAddress) {
		this.mailAddress = newMailAddress;
	}

	/**
	 * Returns dateOfBirth.
	 * @return dateOfBirth 
	 */
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	/**
	 * Sets a value to attribute dateOfBirth. 
	 * @param newDateOfBirth 
	 */
	public void setDateOfBirth(Date newDateOfBirth) {
		this.dateOfBirth = newDateOfBirth;
	}

	/**
	 * Returns profilePicture.
	 * @return profilePicture 
	 */
	public String getProfilePicture() {
		return this.profilePicture;
	}

	/**
	 * Sets a value to attribute profilePicture. 
	 * @param newProfilePicture 
	 */
	public void setProfilePicture(String newProfilePicture) {
		this.profilePicture = newProfilePicture;
	}

	/**
	 * Returns siretNumber.
	 * @return siretNumber 
	 */
	public String getSiretNumber() {
		return this.siretNumber;
	}

	/**
	 * Sets a value to attribute siretNumber. 
	 * @param newSiretNumber 
	 */
	public void setSiretNumber(String newSiretNumber) {
		this.siretNumber = newSiretNumber;
	}

	/**
	 * Returns websiteURL.
	 * @return websiteURL 
	 */
	public String getWebsiteURL() {
		return this.websiteURL;
	}

	/**
	 * Sets a value to attribute websiteURL. 
	 * @param newWebsiteURL 
	 */
	public void setWebsiteURL(String newWebsiteURL) {
		this.websiteURL = newWebsiteURL;
	}

	/**
	 * Returns admin.
	 * @return admin 
	 */
	public Boolean getAdmin() {
		return this.admin;
	}

	/**
	 * Sets a value to attribute admin. 
	 * @param newAdmin 
	 */
	public void setAdmin(Boolean newAdmin) {
		this.admin = newAdmin;
	}

}
