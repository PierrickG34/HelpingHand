/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Persist.UserJDBC;

// Start of product code (product defined imports)

// End of product code

/**
 * Description of User.
 * 
 * @author beuleJérémy
 */
public abstract class Product {
	
	/**
	 * Description of the property idUser.
	 */
	private Integer idProduct = Integer.valueOf(0);

	//beule
	/**
	 * Description of the property name.
	 */
	private String name = "";

	/**
	 * Description of the property price.
	 */
	private float price;

	/**
	 * Description of the property quantity.
	 */
	private int quantity;

	/**
	 * Description of the property category.
	 */
	private String category = "";

	
	private int idVendeur;
	/**
	 * The constructor.
	 * @param login
	 */
	public Product(String name, float price, int quantity, String category, Integer idVendeur) {
		// Start of user code constructor for Product)
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.idVendeur = idVendeur;
		// End of user code
	}
	
	public Product() {}
	public abstract void save();


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
		return this.idProduct;
	}

	/**
	 * Sets a value to attribute idUser. 
	 * @param newIdUser 
	 */
	public void setId(Integer newIdProduct) {
		this.idProduct = newIdProduct;
	}

	public Integer getId()
	{
		return this.idProduct;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setNameProduc(String newName)
	{
		this.name = newName;
	}

	public float getPrice()
	{
		return this.price;
	}
	
	public void setPrice(float newPrice)
	{
		this.price = newPrice;
	}

	public int getQuantity()
	{
		return this.quantity;
	}
	
	public void setCategory(String s)
	{
		this.category = s;
	}
	
	public String getCategory()
	{
		return this.category;
	}
	public void setQuantity(int newQuantity)
	{
		this.quantity = newQuantity;
	}

	public abstract List<Product> getAllProduct(Integer id);







}
