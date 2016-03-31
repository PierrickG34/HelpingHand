package Core;

import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;
import Persist.ProductJDBC;

/**
 * The Class ProductManager.
 * 
 * @author HelpingHand
 */
public class ProductManager {
	
	/** The current product. */
	private Product currentProduct;
	
	/** The list product. */
	private Product[] listProduct;
	
	/** The jdbc factorys. */
	public AbstractFactory jdbcFactorys = new FactoryJDBC();
	
	/**
	 * Instantiates a new product manager.
	 */
	public ProductManager() {
		super();		// End of user code
	}
	
	

	
	/**
	 * Creates the product.
	 *
	 * @param name the name
	 * @param price the price
	 * @param quantity the quantity
	 * @param category the category
	 * @param idVendeur the id vendeur
	 * @return the product
	 */
	public Product createProduct(String name, Double price, int quantity, String category, Integer idVendeur)
	{
		this.currentProduct = this.jdbcFactorys.createProduct(name,price,quantity,category,idVendeur);
		return this.currentProduct;
	}
	
	/**
	 * Gets the all product.
	 *
	 * @param id the id
	 * @return the all product
	 */
	public List<Product> getAllProduct(Integer id) {
		Product product = this.jdbcFactorys.createProduct();
		return product.getAllProduct(id);
	}




	/**
	 * Gets the all product.
	 *
	 * @return the all product
	 */
	public List<Product> getAllProduct() {
		Product product = this.jdbcFactorys.createProduct();
		return product.getAllProduct();
	}




	/**
	 * Modify product.
	 *
	 * @param product the product
	 * @param name the name
	 * @param price the price
	 * @param category the category
	 * @param quantity the quantity
	 */
	public void modifyProduct(Product product, String name, String price, String category, String quantity) {
		this.currentProduct = product;
		ProductJDBC currentProductJDBC = (ProductJDBC) this.currentProduct;
		currentProductJDBC.modifyProduct(product, name, price,category,quantity);		
	}




	/**
	 * Delete product.
	 *
	 * @param product the product
	 */
	public void deleteProduct(Product product) {
		product.delete();
	}
	
}
