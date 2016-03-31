/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Core;

import java.util.Date;
import java.util.List;
import java.util.Observable;

import UI.DeleteProductView;
import UI.DeleteProductViewSeller;
import UI.ProductCreateView;
import UI.ProductCreateViewSeller;
import UI.TaskCreateView;
import UI.TaskUpdateView;
import UI.UpdateProductAdminView;
import UI.UpdateProductView;

// TODO: Auto-generated Javadoc
/**
 * Description of UserFacade.
 * 
 * @author pierrickgiuliani
 */
public class ProductFacade {

	
	/**
	 * Description of the property ProductManager.
	 */
	public ProductManager productManager = new ProductManager();


	/**
	 * The constructor.
	 *
	 * @param productCreateView the product create view
	 */
	public ProductFacade(ProductCreateView productCreateView) {
		// Start of user code constructor for UserFacade)
		super();
		// End of user code
	}

	/**
	 * The constructor.
	 *
	 * @param updateProductView the update product view
	 */
	public ProductFacade(UpdateProductView updateProductView) {
		super();
	}
	
	/**
	 * The constructor.
	 *
	 * @param taskCreateView the task create view
	 */
	public ProductFacade(TaskCreateView taskCreateView) {
		super();
	}
	
	/**
	 * The constructor.
	 *
	 * @param taskUpdateView the task update view
	 */
	public ProductFacade(TaskUpdateView taskUpdateView) {
		super();
	}

	/**
	 * The constructor.
	 *
	 * @param deleteProductView the delete product view
	 */
	public ProductFacade(DeleteProductView deleteProductView) {
		super();
	}

	/**
	 * Instantiates a new product facade.
	 *
	 * @param productCreateViewSeller the product create view seller
	 */
	public ProductFacade(ProductCreateViewSeller productCreateViewSeller) {
		super();
	}

	/**
	 * Instantiates a new product facade.
	 *
	 * @param deleteProductViewSeller the delete product view seller
	 */
	public ProductFacade(DeleteProductViewSeller deleteProductViewSeller) {
		super();
	}

	/**
	 * Instantiates a new product facade.
	 *
	 * @param updateProductAdminView the update product admin view
	 */
	public ProductFacade(UpdateProductAdminView updateProductAdminView) {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Description of the method createProduct.
	 *
	 * @param name the name
	 * @param price the price
	 * @param quantity the quantity
	 * @param category the category
	 * @param idVendeur the id vendeur
	 * @return Product
	 */

	public Product createProduct(String name, Double price, int quantity, String category, Integer idVendeur) {
		return this.productManager.createProduct(name,price,quantity,category,idVendeur);
	}


	/**
	 * Returns userManager.
	 * @return userManager 
	 */
	public ProductManager getproductrManager() {
		return this.productManager;
	}
	
	/**
	 * Return l'ensemble des products du vendeur donn�e.
	 *
	 * @param idVendeur the id vendeur
	 * @return List<Product>
	 */
	public List<Product> getAllProduct(Integer idVendeur) {
		return this.productManager.getAllProduct(idVendeur);
	}
	
	/**
	 * Sets a value to attribute userManager. 
	 *
	 * @param newProductManager the new product manager
	 */
	public void setproductManager(ProductManager newProductManager) {
		this.productManager = newProductManager;
	}

	/**
	 * Returns l'ensemble des produits de la base de donn�es.
	 *
	 * @return List<Product>
	 */
	public List<Product> getAllProduct() {
		return this.productManager.getAllProduct();
	}

	/**
	 * modifie le currentProduct.
	 *
	 * @param product the product
	 * @param name the name
	 * @param price the price
	 * @param category the category
	 * @param quantity the quantity
	 * @name 
	 * @price 
	 * @quantity 
	 * @category 
	 */
	public void modifyProduct(Product product, String name, String price, String category, String quantity) {
		this.productManager.modifyProduct(product,name,price,category,quantity);
	}

	/**
	 * Supprimer currentProduct.
	 *
	 * @param product the product
	 */
	public void DeleteProduct(Product product) {
		this.productManager.deleteProduct(product);		
	}
}


