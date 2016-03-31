package Core;

import java.util.Date;
import java.util.List;

import Persist.JDBConnexion;

/**
 * The Class Plan.
 * 
 *  @author HelpingHand
 */
public abstract class Plan {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/** Description of the id Task. */
	private Integer idPlan = Integer.valueOf(0);
	
	/**
	 * Description of the property name.
	 */
	private String namePlan = "";
	
	/**
	 * Description of the property description.
	 */
	private String observationPlan = "";
	
	/** The deadline. */
	private Date deadline;
	
	/** The tutorial. */
	private boolean tutorial;
	
	/** The is public. */
	private boolean isPublic;
	
	/** The activity category. */
	private String activityCategory;

	/** The id user create plan. */
	private int idUserCreatePlan;
	
	
	/**
	 * Gets the id user create plan.
	 *
	 * @return the id user create plan
	 */
	public int getIdUserCreatePlan() {
		return idUserCreatePlan;
	}

	/**
	 * Sets the id user create plan.
	 *
	 * @param idUserCreatePlan the new id user create plan
	 */
	public void setIdUserCreatePlan(int idUserCreatePlan) {
		this.idUserCreatePlan = idUserCreatePlan;
	}

	/**
	 * Checks if is public.
	 *
	 * @return true, if is public
	 */
	public boolean isPublic() {
		return isPublic;
	}

	/**
	 * Instantiates a new plan.
	 */
	public Plan() {
		super();
	}
	
	/**
	 * Instantiates a new plan.
	 *
	 * @param name the name
	 * @param obsPlan the obs plan
	 * @param deadline the deadline
	 * @param tutorial the tutorial
	 * @param isPublic the is public
	 * @param ac the ac
	 * @param idUser the id user
	 */
	public Plan(String name, String obsPlan, Date deadline, boolean tutorial, boolean isPublic, String ac, int idUser) {
		super();
		this.namePlan = name;
		this.observationPlan = obsPlan;
		this.deadline = deadline;
		this.tutorial = tutorial;
		this.isPublic = isPublic;
		this.activityCategory = ac;
		this.idUserCreatePlan = idUser;
	}

	/**
	 * Gets the jdb connexions.
	 *
	 * @return the jdb connexions
	 */
	public JDBConnexion getjDBConnexions() {
		return jDBConnexions;
	}

	/**
	 * Sets the jdb connexions.
	 *
	 * @param jDBConnexions the new jdb connexions
	 */
	public void setjDBConnexions(JDBConnexion jDBConnexions) {
		this.jDBConnexions = jDBConnexions;
	}

	/**
	 * Gets the id plan.
	 *
	 * @return the id plan
	 */
	public Integer getIdPlan() {
		return idPlan;
	}

	/**
	 * Sets the id plan.
	 *
	 * @param idPlan the new id plan
	 */
	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	/**
	 * Gets the name plan.
	 *
	 * @return the name plan
	 */
	public String getNamePlan() {
		return namePlan;
	}

	/**
	 * Sets the name plan.
	 *
	 * @param name the new name plan
	 */
	public void setNamePlan(String name) {
		this.namePlan = name;
	}

	/**
	 * Gets the observation plan.
	 *
	 * @return the observation plan
	 */
	public String getObservationPlan() {
		return observationPlan;
	}

	/**
	 * Sets the observation plan.
	 *
	 * @param obsPlan the new observation plan
	 */
	public void setObservationPlan(String obsPlan) {
		this.observationPlan = obsPlan;
	}
	
	/**
	 * Gets the deadline.
	 *
	 * @return the deadline
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * Sets the deadline.
	 *
	 * @param deadline the new deadline
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	/**
	 * Gets the tutorial.
	 *
	 * @return the tutorial
	 */
	public boolean getTutorial() {
		return tutorial;
	}

	/**
	 * Sets the tutorial.
	 *
	 * @param tutorial the new tutorial
	 */
	public void setTutorial(boolean tutorial) {
		this.tutorial = tutorial;
	}
	
	/**
	 * Gets the public.
	 *
	 * @return the public
	 */
	public boolean getPublic() {
		return isPublic;
	}

	/**
	 * Sets the public.
	 *
	 * @param isPublic the new public
	 */
	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	/**
	 * Gets the activity category.
	 *
	 * @return the activity category
	 */
	public String getActivityCategory() {
		return activityCategory;
	}

	/**
	 * Sets the activity category.
	 *
	 * @param ac the new activity category
	 */
	public void setActivityCategory(String ac) {
		this.activityCategory = ac;
	}
	
	/**
	 * Gets the all plan.
	 *
	 * @return the all plan
	 */
	public abstract List<Plan> getAllPlan();
	
	/**
	 * Delete.
	 */
	public abstract void delete();
	
	/**
	 * Gets the random plan.
	 *
	 * @return the random plan
	 */
	public abstract List<Plan> getRandomPlan();
	
	/**
	 * Gets the my plan.
	 *
	 * @param idUser the id user
	 * @return the my plan
	 */
	public abstract List<Plan> getMyPlan(int idUser);


}
