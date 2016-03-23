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
	public static JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
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

	public static List<Product> getAllProduct(Integer id) {
		List<Product> list = new ArrayList<Product>();
		System.out.println("Je passe ici");
		list = jDBConnexions.getAllProduct("SELECT * FROM product where idvendeur =" + id) ;
		return list;
	}
	public void modifyProduct(Product ac, String name, String price, String category, String quantity) {
		double priceP = 0;
		Integer quantityP = 0;
		if (name.isEmpty()) {
			name = this.getName();
		}
		else {
			this.setNameProduc(name);
		}
		if (category.isEmpty()) {
			category = this.getCategory();
		}
		else {
			this.setCategory(category);
		}
		if (price.isEmpty()) {
			priceP = this.getPrice();
		}
		else {
			this.setPrice(Double.parseDouble(price));
		}
		if (quantity.isEmpty()) {
			quantityP = this.getQuantity();
		}
		else {
			this.setQuantity(Integer.parseInt(price));
		}
		String id = String.valueOf(ac.getId());
		try {
			this.jDBConnexions.executeUpdate("UPDATE product SET name = '"+name+"', price = '"+priceP+"', quantity = '"+quantityP+"', category = '" + category + "' WHERE idp = '" + id+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	              



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


	public void delete() {
			this.jDBConnexions.delete("DELETE FROM product where idp =" + this.getId());
	}
}
