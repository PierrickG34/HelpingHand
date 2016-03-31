/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Factory;

import java.util.Date;

import Core.ActivityCategory;
import Core.Plan;
import Core.Product;
import Core.Task;
import Persist.ActivityCategoryJDBC;
import Persist.PlanJDBC;
import Persist.ProductJDBC;
import Persist.TaskJDBC;
import Persist.UserJDBC;


/**
 * Description of UserFactory.
 * 
 * @author HelpingHand
 */
public class FactoryJDBC extends AbstractFactory {
	
	/**
	 * Description of the property usersJDBC.
	 */
	public UserJDBC userJDBC = null;
	
	/**
	 * Description of the property activityCategoryJDBC.
	 */
	public ActivityCategoryJDBC activityCategoryJDBC = null;

	/**
	 * The constructor.
	 */
	public FactoryJDBC() {
		super();
	}

	/**
	 * Description of the method createUser.
	 *
	 * @param login the login
	 * @return the user jdbc
	 */
	public UserJDBC createUser(String login) {
		return new UserJDBC(login);
	}
	
	/* (non-Javadoc)
	 * @see Factory.AbstractFactory#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.lang.String, java.lang.String, java.lang.String)
	 */
	public UserJDBC createUser(String firstName, String surName, String mobile, String mailAddress, String password, Date dateOfBirth, String webSiteURL, String siretNumber, String address) {
		return new UserJDBC(firstName, surName, mobile, mailAddress, password, dateOfBirth, webSiteURL, siretNumber, address);
	}
	
	/* (non-Javadoc)
	 * @see Factory.AbstractFactory#createProduct(java.lang.String, java.lang.Double, int, java.lang.String, int)
	 */
	public ProductJDBC createProduct(String name, Double price, int quantity, String category, int idVendeur)
	{ 
		return new ProductJDBC(name,price,quantity,category,idVendeur);
	}
	
	/**
	 * Description of the getter user.
	 * @return users 
	 */
	public UserJDBC getUsers() {
		return this.userJDBC;
	}

	/**
	 * Sets a value to attribute users. 
	 *
	 * @param newUsers the new users
	 */
	public void setUsers(UserJDBC newUsers) {
		this.userJDBC = newUsers;
	}

	/* (non-Javadoc)
	 * @see Factory.AbstractFactory#createActivityCategory(java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public ActivityCategoryJDBC createActivityCategory(String name, String shortDetail, String longDetail, int idUser) {
		return new ActivityCategoryJDBC(name, shortDetail, longDetail, idUser);
	}

	/* (non-Javadoc)
	 * @see Factory.AbstractFactory#createCategory()
	 */
	@Override
	public ActivityCategory createCategory() {
		return new ActivityCategoryJDBC();
	}
	
	/* (non-Javadoc)
	 * @see Factory.AbstractFactory#createProduct()
	 */
	public Product createProduct() {
		return new ProductJDBC();
	}

	/* (non-Javadoc)
	 * @see Factory.AbstractFactory#createTask(java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public Task createTask(String name, String description, int idProduct, int idPlan) {
		Task task = new TaskJDBC(name, description, idProduct, idPlan);
		Task contain = new TaskJDBC(idProduct);
		return task;
	}

	/* (non-Javadoc)
	 * @see Factory.AbstractFactory#createTask()
	 */
	@Override
	public Task createTask() {
		return new TaskJDBC();
	}
	
	/* (non-Javadoc)
	 * @see Factory.AbstractFactory#createPlan(java.lang.String, java.lang.String, java.util.Date, boolean, boolean, java.lang.String, int)
	 */
	@Override
	public Plan createPlan(String name, String observation, Date deadline, boolean tutorial, boolean isPublic, String ac, int idUser) {
		return new PlanJDBC(name, observation, deadline, tutorial, isPublic, ac, idUser);
	}

	/* (non-Javadoc)
	 * @see Factory.AbstractFactory#createPlan()
	 */
	@Override
	public Plan createPlan() {
		return new PlanJDBC();
	}
}

