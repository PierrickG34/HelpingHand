package Core;

import java.util.Date;
import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;

public class ProductManager {
	private Product currentProduct;
	private Product[] listProduct;
	public AbstractFactory jdbcFactorys = new FactoryJDBC();
	
	public ProductManager() {
		super();		// End of user code
	}
	
	

	
	public Product createProduct(String name, float price, int quantity, String category, Integer idVendeur)
	{
		this.currentProduct = this.jdbcFactorys.createProduct(name,price,quantity,category,idVendeur);
		return this.currentProduct;
	}
	
	public List<Product> getAllCategories(Integer id) {
		Product product = this.jdbcFactorys.createProduct();
		return product.getAllProduct(id);
	}
	
}
