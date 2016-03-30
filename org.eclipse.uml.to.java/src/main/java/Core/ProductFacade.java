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
	 * @param ProductCreateView 
	 */
	public ProductFacade(ProductCreateView productCreateView) {
		// Start of user code constructor for UserFacade)
		super();
		// End of user code
	}

	/**
	 * The constructor.
	 * @param ProductUpdateView
	 */
	public ProductFacade(UpdateProductView updateProductView) {
		super();
	}
	
	/**
	 * The constructor.
	 * @param TasCreateView
	 */
	public ProductFacade(TaskCreateView taskCreateView) {
		super();
	}
	
	/**
	 * The constructor.
	 * @param TasUpdateView
	 */
	public ProductFacade(TaskUpdateView taskUpdateView) {
		super();
	}

	/**
	 * The constructor.
	 * @param DeleteProductView
	 */
	public ProductFacade(DeleteProductView deleteProductView) {
		super();
	}

	public ProductFacade(ProductCreateViewSeller productCreateViewSeller) {
		super();
	}

	public ProductFacade(DeleteProductViewSeller deleteProductViewSeller) {
		super();
	}

	public ProductFacade(UpdateProductAdminView updateProductAdminView) {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Description of the method createProduct.
	 * @param name 
	 * @param price
	 * @param quantity
	 * @param category
	 * @param idVendeur
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
	 * Return l'ensemble des products du vendeur donn�e
	 * @param idVendeur
	 * @return List<Product>
	 */
	public List<Product> getAllProduct(Integer idVendeur) {
		return this.productManager.getAllProduct(idVendeur);
	}
	
	/**
	 * Sets a value to attribute userManager. 
	 * @param newuserManager 
	 */
	public void setproductManager(ProductManager newProductManager) {
		this.productManager = newProductManager;
	}

	/**
	 * Returns l'ensemble des produits de la base de donn�es
	 * @return List<Product> 
	 */
	public List<Product> getAllProduct() {
		return this.productManager.getAllProduct();
	}

	/**
	 * modifie le currentProduct
	 * @param product
	 * @name
	 * @price
	 * @quantity
	 * @category
	 */
	public void modifyProduct(Product product, String name, String price, String category, String quantity) {
		this.productManager.modifyProduct(product,name,price,category,quantity);
	}

	/**
	 * Supprimer currentProduct
	 * @param product
	 */
	public void DeleteProduct(Product product) {
		this.productManager.deleteProduct(product);		
	}
}


