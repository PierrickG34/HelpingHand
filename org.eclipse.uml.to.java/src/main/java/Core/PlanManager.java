package Core;

import java.util.Date;
import java.util.List;

import Factory.AbstractFactory;
import Factory.FactoryJDBC;
import Persist.ActivityCategoryJDBC;
import Persist.PlanJDBC;
import Persist.TaskJDBC;

// TODO: Auto-generated Javadoc
/**
 * The Class PlanManager.
 */
public class PlanManager {
	
	/** The current plan. */
	private Plan currentPlan;
	
	/** The plan factory. */
	public AbstractFactory planFactory = new FactoryJDBC();

	/**
	 * Instantiates a new plan manager.
	 */
	public PlanManager() {
		super();
	}

	/**
	 * Creates the plan.
	 *
	 * @param name the name
	 * @param observation the observation
	 * @param deadline the deadline
	 * @param tutorial the tutorial
	 * @param isPublic the is public
	 * @param ac the ac
	 * @param idUser the id user
	 * @return the plan
	 */
	public Plan createPlan(String name, String observation, Date deadline, boolean tutorial, boolean isPublic, String ac, int idUser) {
		return (this.currentPlan = this.planFactory.createPlan(name, observation, deadline, tutorial, isPublic, ac, idUser));
	}

	/**
	 * Gets the all plan.
	 *
	 * @return the all plan
	 */
	public List<Plan> getAllPlan() {
		Plan plan = this.planFactory.createPlan();
		return plan.getAllPlan();
	}
	
	/**
	 * Gets the random plan.
	 *
	 * @return the random plan
	 */
	public List<Plan> getRandomPlan() {
		Plan plan = this.planFactory.createPlan();
		return plan.getRandomPlan();
	}
	
	/**
	 * Gets the my plan.
	 *
	 * @param idUser the id user
	 * @return the my plan
	 */
	public List<Plan> getMyPlan(int idUser) {
		Plan plan = this.planFactory.createPlan();
		return plan.getMyPlan(idUser);
	}
	
	/**
	 * Delete plan.
	 *
	 * @param plan the plan
	 */
	public void deletePlan(Plan plan) {
		plan.delete();
	}

	/**
	 * Gets the task for plan.
	 *
	 * @param idPlan the id plan
	 * @return the task for plan
	 */
	public List<Task> getTaskForPlan(Integer idPlan) {
		Task task = this.planFactory.createTask();
		return task.getTaskForPlan(idPlan);
	}
}
