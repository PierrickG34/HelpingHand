/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Core;

import java.util.Date;
import java.util.Observable;

//import Factory.FactoryJDBC;
import UI.ProductCreateView;


// Start of user code (user defined imports)

// End of user code

/**
 * Description of UserFacade.
 * 
 * @author pierrickgiuliani
 */
public class ProductFacade {

	
	/**
	 * Description of the property userManager.
	 */
	public ProductManager productManager = new ProductManager();

	// Start of user code (user defined attributes for UserFacade)

	// End of user code

	/**
	 * The constructor.
	 * @param ProductCreateView correspond a user
	 */
	public ProductFacade(ProductCreateView user) {
		// Start of user code constructor for UserFacade)
		super();
		// End of user code
	}

	/**
	 * Description of the method createProduct.
	 * @param login 
	 * @param password 
	 */

	public Product createProduct(String name, float price, int quantity, String category, Integer idVendeur) {
		return this.productManager.createProduct(name,price,quantity,category,idVendeur);
	}

	// Start of user code (user defined methods for UserFacade)

	// End of user code
	/**
	 * Returns userManager.
	 * @return userManager 
	 */
	public ProductManager getproductrManager() {
		return this.productManager;
	}
	
	/*
	public Product[] readProduct() {
		return this.productManager.readProduct();
	}
*/
	
	/**
	 * Sets a value to attribute userManager. 
	 * @param newuserManager 
	 */
	public void setproductManager(ProductManager newProductManager) {
		this.productManager = newProductManager;
	}
}
