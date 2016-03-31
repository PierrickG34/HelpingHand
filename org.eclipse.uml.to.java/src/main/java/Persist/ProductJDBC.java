package Persist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Core.Product;

/**
 * The Class ProductJDBC.
 * @author Helping Hand
 */
public class ProductJDBC extends Product{
	
	/** The JDBconnexions. */
	public static JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/**
	 * Constructeur ProductJDBC.
	 *
	 * @param name the name
	 * @param price the price
	 * @param quantity the quantity
	 * @param category the category
	 * @param idVendeur the id vendeur
	 * @return Product
	 */
	public ProductJDBC(String name, Double price, int quantity, String category, Integer idVendeur) {
		super(name, price, quantity, category,idVendeur);
		try {
			jDBConnexions.executeUpdate("INSERT INTO Product VALUES (DEFAULT, '"+ name + "','"+ price +"','" + "Poisson" + "','" 
					+ quantity  + "','" + idVendeur +"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Instantiates a new productJDBC.
	 */
	public ProductJDBC() {
	}

	/**
	 * Returns l'ensemble des produits du currentVendeur.
	 *
	 * @param id the id
	 * @return List<Product>
	 */
	public static List<Product> getAllProduct(Integer id) {
		List<Product> list = new ArrayList<Product>();
		list = jDBConnexions.getAllProduct("SELECT * FROM product where idvendeur =" + id) ;
		return list;
	}
	
	/**
	 * modifie le product.
	 *
	 * @param ac the activity category
	 * @param name the name
	 * @param price the price
	 * @param category the category
	 * @param quantity the quantity
	 */
	public void modifyProduct(Product ac, String name, String price, String category, String quantity) {
		Double p;
		int q;
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
			price = this.getPrice().toString();
			p = Double.parseDouble(price);
		}
		else {
			this.setPrice(Double.parseDouble(price));
			p = Double.parseDouble(price);
		}
		if (quantity.isEmpty()) {
			quantity = String.valueOf(this.getQuantity());
			q = Integer.parseInt(quantity);
		}
		else {
			this.setQuantity(Integer.parseInt(quantity));
			q = Integer.parseInt(quantity);
		}
		String id = String.valueOf(ac.getId());
		try {
			this.jDBConnexions.executeUpdate("UPDATE product SET name = '"+name+"', price = '"+p+"', quantity = '"+q+"', category = '" + category + "' WHERE idp = '" + id+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see Core.Product#save()
	 */
	@Override
	public void save() {
	}

	/**
	 * Returns l'ensemble des produits de la base de donnees.
	 *
	 * @return List<Product>
	 */
	@Override
	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		list = this.jDBConnexions.getAllProduct("SELECT * FROM product");
		return list;
	}

	/**
	 * supprime le Product.
	 */
	
	public void delete() {
		this.jDBConnexions.delete("DELETE FROM product where idp =" + this.getId());
	}
}
