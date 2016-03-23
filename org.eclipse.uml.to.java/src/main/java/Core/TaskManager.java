package Core;

import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;

public class TaskManager {
	
	private Task currentTask;
	public AbstractFactory taskFactorys = new FactoryJDBC();

	public TaskManager() {
		super();
	}

	public Task createTask(String name, String description, int idProduct, int idPlan) {
		return (this.currentTask = this.taskFactorys.createTask(name, description, idProduct, idPlan));
	}

	public List<Task> getAllTask() {
		Task task = this.taskFactorys.createTask();
		return task.getAllTask();
	}
}
