package Core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Persist.JDBConnexion;

// TODO: Auto-generated Javadoc
/**
 * Description of ActivityCategory.
 * 
 * @author pierrickgiuliani
 */
public abstract class ActivityCategory {

	/**
	 * Description of the property jDBConnexions.
	 */
	//public JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();

	/**
	 * Description of the property idUser.
	 */
	private Integer idActivityCategory = Integer.valueOf(0);
	
	/**
	 * Description of the property password.
	 */
	private String name = "";
	
	/**
	 * Description of the property password.
	 */
	private String shortDetail = "";
	
	/**
	 * Description of the property password.
	 */
	private String longDetail = "";
	
	/**
	 * Instantiates a new activity category.
	 *
	 * @param name the name
	 * @param shortDetail the short detail
	 * @param longDetail the long detail
	 */
	public ActivityCategory(String name, String shortDetail, String longDetail) {
		super();
		this.name = name;
		this.shortDetail = shortDetail;
		this.longDetail = longDetail;
	}

	/**
	 * Instantiates a new activity category.
	 */
	public ActivityCategory() {
		super();
	}

	/**
	 * Gets the id activity category.
	 *
	 * @return the id activity category
	 */
	public Integer getIdActivityCategory() {
		return idActivityCategory;
	}

	/**
	 * Sets the id activity category.
	 *
	 * @param idActivityCategory the new id activity category
	 */
	public void setIdActivityCategory(Integer idActivityCategory) {
		this.idActivityCategory = idActivityCategory;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the short detail.
	 *
	 * @return the short detail
	 */
	public String getShortDetail() {
		return shortDetail;
	}

	/**
	 * Sets the short detail.
	 *
	 * @param shortDetail the new short detail
	 */
	public void setShortDetail(String shortDetail) {
		this.shortDetail = shortDetail;
	}

	/**
	 * Gets the long detail.
	 *
	 * @return the long detail
	 */
	public String getLongDetail() {
		return longDetail;
	}

	/**
	 * Sets the long detail.
	 *
	 * @param longDetail the new long detail
	 */
	public void setLongDetail(String longDetail) {
		this.longDetail = longDetail;
	}
	
	/**
	 * Gets the all categories.
	 *
	 * @return the all categories
	 */
	public abstract List<ActivityCategory> getAllCategories();
	
}