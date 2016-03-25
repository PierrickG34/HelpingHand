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

	public Plan createPlan(String name, String observation, Date deadline, boolean tutorial, boolean isPublic, ActivityCategory ac, int idUser) {
		return (this.currentPlan = this.planFactory.createPlan(name, observation, deadline, tutorial, isPublic, ac, idUser));
	}

//	public List<Plan> getAllPlan() {
//		Plan plan = this.planFactory.createPlan();
//		return plan.getAllPlan();
//	}
//
//	public void modifyPlan(Plan plan, String name, String observation, Date deadline, boolean tutorial, boolean isPublic, ActivityCategory ac) {
//		this.currentPlan = plan;
//		PlanJDBC currentPlanJDBC = (PlanJDBC) this.currentPlan;
//		currentPlanJDBC.modifyPlan(plan, name, observation, deadline, tutorial, isPublic, ac);
//	}
//
	public void deletePlan(Plan plan) {
		plan.delete();
	}
}
