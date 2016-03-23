package Core;

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
}
