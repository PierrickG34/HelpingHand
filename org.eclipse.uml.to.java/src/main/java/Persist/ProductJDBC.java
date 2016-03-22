package Persist;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Core.ActivityCategory;
import Core.Product;
import Excpetion.AlreadyExistException;

public class ProductJDBC extends Product{
	
	//public static JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	public ProductJDBC(String name, Double price, int quantity, String category, Integer idVendeur) {
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
	

	public ProductJDBC() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Product> getAllProduct(Integer id) {
		List<Product> list = new ArrayList<Product>();
		list = this.jDBConnexions.getAllProduct("SELECT * FROM product where idp =" + id ) ;
		return list;
	}
	
	/**
	 * Description of the property jDBConnexions.
	 */


	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		list = this.jDBConnexions.getAllProduct("SELECT * FROM product");
		return list;
	}
}
