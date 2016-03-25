package Core;

import java.util.Date;
import java.util.List;

import UI.CreatePlanView;

public class PlanFacade {

	public PlanManager planManager = new PlanManager();
	
	public PlanFacade(CreatePlanView planCreateView) {
		super();
	}

	public Plan createPlan(String name, String observation, Date deadline, boolean tutorial, boolean isPublic, ActivityCategory ac, int idUser) {
		return this.planManager.createPlan(name, observation, deadline, tutorial, isPublic, ac, idUser);
		
	}

	public List<Plan> getAllPlan() {
		return this.planManager.getAllPlan();
	}
//
//	public void modifyPlan(Plan plan, String name, String observation, Date deadline, boolean tutorial, boolean isPublic, ActivityCategory ac) {
//		this.planManager.modifyPlan(plan, name, observation, deadline, tutorial, isPublic, ac);
//	}
//
	public void deleteTask(Plan plan) {
		this.planManager.deletePlan(plan);
	}

}
