package Core;

import java.util.Date;
import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;
import Persist.ActivityCategoryJDBC;
import Persist.PlanJDBC;
import Persist.TaskJDBC;

public class PlanManager {
	
	private Plan currentPlan;
	public AbstractFactory planFactory = new FactoryJDBC();

	public PlanManager() {
		super();
	}

	public Plan createPlan(String name, String observation, Date deadline, boolean tutorial, boolean isPublic, String ac, int idUser) {
		return (this.currentPlan = this.planFactory.createPlan(name, observation, deadline, tutorial, isPublic, ac, idUser));
	}

	public List<Plan> getAllPlan() {
		Plan plan = this.planFactory.createPlan();
		return plan.getAllPlan();
	}
	
	public List<Plan> getRandomPlan() {
		Plan plan = this.planFactory.createPlan();
		return plan.getRandomPlan();
	}
	
	public List<Plan> getMyPlan(int idUser) {
		Plan plan = this.planFactory.createPlan();
		return plan.getMyPlan(idUser);
	}
	
	public void deletePlan(Plan plan) {
		plan.delete();
	}

	public List<Task> getTaskForPlan(Integer idPlan) {
		Task task = this.planFactory.createTask();
		return task.getTaskForPlan(idPlan);
	}
}
