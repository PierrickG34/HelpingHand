package Core;

import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;
import Persist.ActivityCategoryJDBC;
import Persist.TaskJDBC;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskManager.
 */
public class TaskManager {
	
	/** The current task. */
	private Task currentTask;
	
	/** The task factorys. */
	public AbstractFactory taskFactorys = new FactoryJDBC();

	/**
	 * Instantiates a new task manager.
	 */
	public TaskManager() {
		super();
	}

	/**
	 * Creates the task.
	 *
	 * @param name the name
	 * @param description the description
	 * @param idProduct the id product
	 * @param idPlan the id plan
	 * @return the task
	 */
	public Task createTask(String name, String description, int idProduct, int idPlan) {
		return (this.currentTask = this.taskFactorys.createTask(name, description, idProduct, idPlan));
	}

	/**
	 * Gets the all task.
	 *
	 * @return the all task
	 */
	public List<Task> getAllTask() {
		Task task = this.taskFactorys.createTask();
		return task.getAllTask();
	}

	/**
	 * Modify task.
	 *
	 * @param task the task
	 * @param description the description
	 * @param product the product
	 */
	public void modifyTask(Task task, String description, Product product) {
		this.currentTask = task;
		TaskJDBC currentTaskJDBC = (TaskJDBC) this.currentTask;
		currentTaskJDBC.modifyTask(task, description, product);
	}

	/**
	 * Delete task.
	 *
	 * @param task the task
	 */
	public void deleteTask(Task task) {
		task.delete();
	}
}
