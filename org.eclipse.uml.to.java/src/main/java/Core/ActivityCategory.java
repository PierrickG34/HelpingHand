package Core;

/**
 * Description of ActivityCategory.
 * 
 * @author pierrickgiuliani
 */
public abstract class ActivityCategory {


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
}