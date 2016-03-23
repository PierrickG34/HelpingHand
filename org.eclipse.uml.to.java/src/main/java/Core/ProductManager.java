package Core;

import java.util.Date;
import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;
import Persist.ActivityCategoryJDBC;
import Persist.ProductJDBC;

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
	
	public List<Product> getAllProduct(Integer id) {
		return Product.getAllProduct(id);
	}
	
	public void modifyProduct(Product p,String name, String price, String category, String quantity) {
		System.out.println("modifyProduct : ProductManager");
		this.currentProduct = p;
		ProductJDBC currentProductJDBC = (ProductJDBC) this.currentProduct;
		currentProductJDBC.modifyProduct(p, name, price,category,quantity);
	}
	
}
