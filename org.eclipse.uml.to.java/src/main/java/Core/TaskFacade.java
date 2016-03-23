package Core;

import UI.TaskCreateView;

public class TaskFacade {
	
	/**
	 * Description of the property activityCategoryManager.
	 */
	public TaskManager taskManager = new TaskManager();
	
	public TaskFacade(TaskCreateView taskCreateView) {
		super();
	}

	public Task createTask(String name, String description) {
		return this.taskManager.createTask(name, description);
		
	}

}
