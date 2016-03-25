package Core;

import java.util.Date;
import java.util.List;

import Persist.JDBConnexion;

public abstract class Plan {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	//public JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/**
	 * Description of the id Task
	 */
	private Integer idPlan = Integer.valueOf(0);
	
	/**
	 * Description of the property name.
	 */
	private String namePlan = "";
	
	/**
	 * Description of the property description.
	 */
	private String observationPlan = "";
	
	private Date deadline;
	
	private boolean tutorial;
	
	private boolean isPublic;
	
	private ActivityCategory activityCategory;

	private int idUserCreatePlan;
	
	
	public int getIdUserCreatePlan() {
		return idUserCreatePlan;
	}

	public void setIdUserCreatePlan(int idUserCreatePlan) {
		this.idUserCreatePlan = idUserCreatePlan;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public Plan() {
		super();
	}
	
	public Plan(String name, String obsPlan, Date deadline, boolean tutorial, boolean isPublic, ActivityCategory ac, int idUser) {
		super();
		this.namePlan = name;
		this.observationPlan = obsPlan;
		this.deadline = deadline;
		this.tutorial = tutorial;
		this.isPublic = isPublic;
		this.activityCategory = ac;
		this.idUserCreatePlan = idUser;
	}

	public JDBConnexion getjDBConnexions() {
		return jDBConnexions;
	}

	public void setjDBConnexions(JDBConnexion jDBConnexions) {
		this.jDBConnexions = jDBConnexions;
	}

	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public String getNamePlan() {
		return namePlan;
	}

	public void setNamePlan(String name) {
		this.namePlan = name;
	}

	public String getObservationPlan() {
		return observationPlan;
	}

	public void setObservationPlan(String obsPlan) {
		this.observationPlan = obsPlan;
	}
	
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	
	public boolean getTutorial() {
		return tutorial;
	}

	public void setTutorial(boolean tutorial) {
		this.tutorial = tutorial;
	}
	
	public boolean getPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}
	
	public ActivityCategory getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(ActivityCategory ac) {
		this.activityCategory = ac;
	}
	
	public abstract List<Plan> getAllPlan();
	
	public abstract void delete();


}
