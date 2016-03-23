package Core;

import java.util.List;

import Persist.JDBConnexion;

public abstract class Task {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	//public JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/**
	 * Description of the id Task
	 */
	private Integer idTask = Integer.valueOf(0);
	
	/**
	 * Description of the id Plan
	 */
	private Integer idPlan = Integer.valueOf(0);
	
	/**
	 * Description of the property name.
	 */
	private String name = "";
	
	/**
	 * Description of the property description.
	 */
	private String description = "";
	
	
	public Task() {
		super();
	}
	
	public Task(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public JDBConnexion getjDBConnexions() {
		return jDBConnexions;
	}

	public void setjDBConnexions(JDBConnexion jDBConnexions) {
		this.jDBConnexions = jDBConnexions;
	}

	public Integer getIdTask() {
		return idTask;
	}

	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
	}

	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public abstract List<Task> getAllTask();
	
	public abstract void delete();


}
