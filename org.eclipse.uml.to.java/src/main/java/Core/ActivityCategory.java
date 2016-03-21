package Core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Persist.JDBConnexion;

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
	
	public ActivityCategory(String name, String shortDetail, String longDetail) {
		super();
		this.name = name;
		this.shortDetail = shortDetail;
		this.longDetail = longDetail;
	}

	public ActivityCategory() {
		super();
	}

	public Integer getIdActivityCategory() {
		return idActivityCategory;
	}

	public void setIdActivityCategory(Integer idActivityCategory) {
		this.idActivityCategory = idActivityCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDetail() {
		return shortDetail;
	}

	public void setShortDetail(String shortDetail) {
		this.shortDetail = shortDetail;
	}

	public String getLongDetail() {
		return longDetail;
	}

	public void setLongDetail(String longDetail) {
		this.longDetail = longDetail;
	}
	
	public abstract List<ActivityCategory> getAllCategories();
	
}