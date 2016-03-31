package Core;

import java.util.List;

import Persist.JDBConnexion;

// TODO: Auto-generated Javadoc
/**
 * The Class Task.
 */
public abstract class Task {
	
	/**
	 * Description of the property jDBConnexions.
	 */
	//public JDBConnexion jDBConnexions = new JDBConnexion();
	public JDBConnexion jDBConnexions = JDBConnexion.createConnect();
	
	/** Description of the id Task. */
	private Integer idTask = Integer.valueOf(0);
	
	/** Description of the id Plan. */
	private Integer idPlan = Integer.valueOf(0);
	
	/**
	 * Description of the property name.
	 */
	private String name = "";
	
	/**
	 * Description of the property description.
	 */
	private String description = "";
	
	
	/**
	 * Instantiates a new task.
	 */
	public Task() {
		super();
	}
	
	/**
	 * Instantiates a new task.
	 *
	 * @param name the name
	 * @param description the description
	 */
	public Task(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	/**
	 * Gets the j db connexions.
	 *
	 * @return the j db connexions
	 */
	public JDBConnexion getjDBConnexions() {
		return jDBConnexions;
	}

	/**
	 * Sets the j db connexions.
	 *
	 * @param jDBConnexions the new j db connexions
	 */
	public void setjDBConnexions(JDBConnexion jDBConnexions) {
		this.jDBConnexions = jDBConnexions;
	}

	/**
	 * Gets the id task.
	 *
	 * @return the id task
	 */
	public Integer getIdTask() {
		return idTask;
	}

	/**
	 * Sets the id task.
	 *
	 * @param idTask the new id task
	 */
	public void setIdTask(Integer idTask) {
		this.idTask = idTask;
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
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the all task.
	 *
	 * @return the all task
	 */
	public abstract List<Task> getAllTask();
	
	/**
	 * Delete.
	 */
	public abstract void delete();

	/**
	 * Gets the task for plan.
	 *
	 * @param idPlan2 the id plan2
	 * @return the task for plan
	 */
	public abstract List<Task> getTaskForPlan(Integer idPlan2);


}
