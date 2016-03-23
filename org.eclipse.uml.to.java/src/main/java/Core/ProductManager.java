package Core;

import java.util.Date;
import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;
import Persist.ProductJDBC;

public class ProductManager {
	private Product currentProduct;
	private Product[] listProduct;
	public AbstractFactory jdbcFactorys = new FactoryJDBC();
	
	public ProductManager() {
		super();		// End of user code
	}
	
	

	
	public Product createProduct(String name, Double price, int quantity, String category, Integer idVendeur)
	{
		this.currentProduct = this.jdbcFactorys.createProduct(name,price,quantity,category,idVendeur);
		return this.currentProduct;
	}
	
	public List<Product> getAllProduct(Integer id) {
		Product product = this.jdbcFactorys.createProduct();
		return product.getAllProduct(id);
	}




	public List<Product> getAllProduct() {
		Product product = this.jdbcFactorys.createProduct();
		return product.getAllProduct();
	}




	public void modifyProduct(Product product, String name, String price, String quantity, String category) {
		this.currentProduct = product;
		ProductJDBC currentProductJDBC = (ProductJDBC) this.currentProduct;
		currentProductJDBC.modifyProduct(product, name, price,quantity,category);		
	}
	
}
