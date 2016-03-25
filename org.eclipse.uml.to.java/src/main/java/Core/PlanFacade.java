package Core;

import java.util.Date;
import java.util.List;

import UI.PlanCreateView;
import UI.PlanDeleteView;
import UI.PlanUpdateView;

public class PlanFacade {
	
	/**
	 * Description of the property activityCategoryManager.
	 */
	public TaskManager taskManager = new TaskManager();
	public PlanManager planManager = new PlanManager();
	
	public PlanFacade(PlanCreateView planCreateView) {
		super();
	}

	public PlanFacade(PlanUpdateView planUpdateView) {
		super();
	}

	public PlanFacade(PlanDeleteView planDeleteView) {
		super();
	}

	public Plan createPlan(String name, String observation, Date deadline, boolean tutorial, boolean isPublic, ActivityCategory ac) {
		return this.planManager.createPlan(name, observation, deadline, tutorial, isPublic, ac);
		
	}

	public List<Plan> getAllPlan() {
		return this.planManager.getAllPlan();
	}

	public void modifyPlan(Plan plan, String name, String observation, Date deadline, boolean tutorial, boolean isPublic, ActivityCategory ac) {
		this.planManager.modifyPlan(plan, name, observation, deadline, tutorial, isPublic, ac);
	}

	public void deleteTask() {
		this.planManager.deletePlan();
	}

}
