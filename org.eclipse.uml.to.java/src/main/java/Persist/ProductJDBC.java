package Persist;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import Core.Product;
import Excpetion.AlreadyExistException;

public class ProductJDBC extends Product{
	
	public JDBConnexion jDBConnexions = new JDBConnexion();
	
	public ProductJDBC(String name, float price, int quantity, String category) {
		super(name, price, quantity, category);
		System.out.println("Cass ProductJDBC : Constructeur");
		System.out.println(name);
		System.out.println(price);
		System.out.println(quantity);
		System.out.println(category);
		try {
			this.jDBConnexions.executeUpdate("INSERT INTO Product VALUES (DEFAULT, '"+ name + "','"+ price +"','" + "Poisson" + "','" 
					+ quantity +"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new AlreadyExistException("Your email is already used, please choose an other.");
		}
	}

	/**
	 * Description of the property jDBConnexions.
	 */


	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
}
