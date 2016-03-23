package Core;

import java.util.List;

import UI.TaskCreateView;
import UI.TaskUpdateView;

public class TaskFacade {
	
	/**
	 * Description of the property activityCategoryManager.
	 */
	public TaskManager taskManager = new TaskManager();
	
	public TaskFacade(TaskCreateView taskCreateView) {
		super();
	}

	public TaskFacade(TaskUpdateView taskUpdateView) {
		super();
	}

	public Task createTask(String name, String description, int idProduct, int idPlan) {
		return this.taskManager.createTask(name, description, idProduct, idPlan);
		
	}

	public List<Task> getAllTask() {
		return this.taskManager.getAllTask();
	}

	public void modifyTask(Task task, String description, Product product) {
		this.taskManager.modifyTask(task,description,product);
	}

}
