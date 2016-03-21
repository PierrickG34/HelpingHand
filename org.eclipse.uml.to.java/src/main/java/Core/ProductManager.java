package Core;

import java.util.Date;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;

public class ProductManager {
	private User currentUser;
	public AbstractFactory jdbcFactorys = new FactoryJDBC();
	
	public ProductManager() {
		super();		// End of user code
	}
	
	
	public User getCurrentUser() {
		return this.currentUser;
	}
	
	public Product createProduct(String name, float price, int quantity, String category)
	{
		return this.jdbcFactorys.createProduct(name,price,quantity,category);
	}
	
}
