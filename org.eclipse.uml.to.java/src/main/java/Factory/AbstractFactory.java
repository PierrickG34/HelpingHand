/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Factory;

import java.util.Date;

import Core.ActivityCategory;
import Core.Plan;
import Core.Product;
import Core.Task;
import Core.User;
import Persist.ProductJDBC;

/**
 * Description of AbstractUserFactory.
 * 
 * @author HelpingHand
 */
public abstract class AbstractFactory {

	/**
	 * The constructor.
	 */
	public AbstractFactory() {
		super();
	}

	/**
	 * Description of the method createUser.
	 *
	 * @param login the login
	 * @return the user
	 */
	public abstract User createUser(String login);
	
	/**
	 * Creates a new Abstract create user.
	 *
	 * @param firstName the first name
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
	public abstract User createUser(String firstName, String surName, String mobile, String mailAddress, String password, 
			Date dateOfBirth, String webSiteURL, String siretNumber, String address);

	/**
	 * Creates a new Abstract activity category.
	 *
	 * @param name the name
	 * @param shortDetail the short detail
	 * @param longDetail the long detail
	 * @param idUser the id user
	 * @return the activity category
	 */
	public abstract ActivityCategory createActivityCategory(String name, String shortDetail, String longDetail ,int idUser);
	
	/**
	 * Creates a new Abstract produt.
	 *
	 * @param name the name
	 * @param price the price
	 * @param quantity the quantity
	 * @param category the category
	 * @param idVendeur the idvendeur
	 * @return the product jdbc
	 */
	public abstract ProductJDBC createProduct(String name, Double price, int quantity, String category, int idVendeur);
	

	/**
	 * Creates a new Abstract create category.
	 *
	 * @return the activity category
	 */
	public abstract ActivityCategory createCategory();

	/**
	 * Creates a new Abstract product.
	 *
	 * @return the product
	 */
	public abstract Product createProduct();

	/**
	 * Creates a new Abstract task.
	 *
	 * @param name the name
	 * @param description the description
	 * @param idProduct the idproduct
	 * @param idPlan the idplan
	 * @return the task
	 */
	public abstract Task createTask(String name, String description, int idProduct, int idPlan);
	
	/**
	 * Creates a new Abstract task.
	 *
	 * @return the task
	 */
	public abstract Task createTask();
	
	/**
	 * Creates a new Abstract plan.
	 *
	 * @return the plan
	 */
	public abstract Plan createPlan();

	/**
	 * Creates a new Abstract plan.
	 *
	 * @param name the name
	 * @param observation the observation
	 * @param deadline the deadline
	 * @param tutorial the tutorial
	 * @param isPublic the is public
	 * @param ac the activity category
	 * @param idUser the id user
	 * @return the plan
	 */
	public abstract Plan createPlan(String name, String observation, Date deadline, boolean tutorial, boolean isPublic,
			String ac, int idUser);
}
