package Core;

import java.util.List;

import Persist.ProductJDBC;


/**
 * Description of Product.
 * 
 * @author HelpingHand
 */
public abstract class Product {
	
	/**
	 * Description of the property idProduct.
	 */
	private Integer idProduct = Integer.valueOf(0);


	/**
	 * Description of the property name.
	 */
	private String name = "";

	/**
	 * Description of the property price.
	 */
	private Double price;

	/**
	 * Description of the property quantity.
	 */
	private int quantity;

	/**
	 * Description of the property category.
	 */
	private String category = "";

	/**
	 * Description of the property idVendeur.
	 */
	
	private int idVendeur;
	
	/**
	 * The constructor.
	 *
	 * @param name the name
	 * @param price the price
	 * @param quantity the quantity
	 * @param category the category
	 * @param idVendeur the id vendeur
	 */
	public Product(String name, Double price, int quantity, String category, Integer idVendeur) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.idVendeur = idVendeur;
	}
	
	/**
	 * Instantiates a new product.
	 */
	public Product() {}
	
	/**
	 * Save.
	 */
	public abstract void save();
	
	/**
	 * Returns idProduct.
	 * @return idProduct 
	 */
	public Integer getId() {
		return this.idProduct;
	}

	/**
	 * Sets a value to attribute idUProduct. 
	 *
	 * @param newIdProduct the new id
	 */
	public void setId(Integer newIdProduct) {
		this.idProduct = newIdProduct;
	}

	/**
	 * Returns product name.
	 * @return name 
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets a value to attribute product name. 
	 *
	 * @param newName the new name produc
	 */
	public void setNameProduc(String newName)
	{
		this.name = newName;
	}

	/**
	 * Returns product price.
	 * @return price 
	 */
	public Double getPrice()
	{
		return this.price;
	}
	
	/**
	 * Sets a value to attribute product price. 
	 *
	 * @param newPrice the new price
	 */
	public void setPrice(Double newPrice)
	{
		this.price = newPrice;
	}

	/**
	 * Returns product quantity.
	 * @return quantity 
	 */
	public int getQuantity()
	{
		return this.quantity;
	}
	
	/**
	 * Sets a value to attribute product category. 
	 *
	 * @param newCategory the new category
	 */
	public void setCategory(String newCategory)
	{
		this.category = newCategory;
	}
	
	/**
	 * Returns product category.
	 * @return category 
	 */
	public String getCategory()
	{
		return this.category;
	}
	
	/**
	 * Sets a value to attribute product quantity. 
	 *
	 * @param newQuantity the new quantity
	 */
	public void setQuantity(int newQuantity)
	{
		this.quantity = newQuantity;
	}
	
	/**
	 * Returns all products of the seller.
	 *
	 * @param idVendeur the id seller
	 * @return List<Product>
	 */

	public static List<Product> getAllProduct(Integer idVendeur) {
		return ProductJDBC.getAllProduct(idVendeur);
	}
	
	/**
	 * Returns all products in the database.
	 *
	 * @return List<Product>
	 */
	public abstract List<Product> getAllProduct();

	/**
	 * Delete currentProduct.
	 */
	public abstract void delete();
}
