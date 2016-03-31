package Core;

import java.util.List;

import UI.TaskCreateView;
import UI.TaskDeleteView;
import UI.TaskUpdateView;

/**
 * The Class TaskFacade.
 * 
 * @author HelpingHand
 */
public class TaskFacade {
	
	/**
	 * Description of the property activityCategoryManager.
	 */
	public TaskManager taskManager = new TaskManager();
	
	/**
	 * Instantiates a new task facade.
	 *
	 * @param taskCreateView the task create view
	 */
	public TaskFacade(TaskCreateView taskCreateView) {
		super();
	}

	/**
	 * Instantiates a new task facade.
	 *
	 * @param taskUpdateView the task update view
	 */
	public TaskFacade(TaskUpdateView taskUpdateView) {
		super();
	}

	/**
	 * Instantiates a new task facade.
	 *
	 * @param taskDeleteView the task delete view
	 */
	public TaskFacade(TaskDeleteView taskDeleteView) {
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
		return this.taskManager.createTask(name, description, idProduct, idPlan);
		
	}

	/**
	 * Gets the all task.
	 *
	 * @return the all task
	 */
	public List<Task> getAllTask() {
		return this.taskManager.getAllTask();
	}

	/**
	 * Modify task.
	 *
	 * @param task the task
	 * @param description the description
	 * @param product the product
	 */
	public void modifyTask(Task task, String description, Product product) {
		this.taskManager.modifyTask(task,description,product);
	}

	/**
	 * Delete task.
	 *
	 * @param task the task
	 */
	public void deleteTask(Task task) {
		this.taskManager.deleteTask(task);
	}

}
