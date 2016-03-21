package Persist;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import Core.Product;
import Excpetion.AlreadyExistException;

public class ProductJDBC extends Product{
	
	//public static JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	public ProductJDBC(String name, float price, int quantity, String category, Integer idVendeur) {
		super(name, price, quantity, category,idVendeur);
		try {
			jDBConnexions.executeUpdate("INSERT INTO Product VALUES (DEFAULT, '"+ name + "','"+ price +"','" + "Poisson" + "','" 
					+ quantity  + "','" + idVendeur +"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new AlreadyExistException("Your email is already used, please choose an other.");
		}
		
		
	}
	/*
	public static void readProduct() {
		try {
			jDBConnexions.executeRequest("select * from product where idactivitycategory = 1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Description of the property jDBConnexions.
	 */


	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
}
