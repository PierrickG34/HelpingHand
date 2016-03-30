package Core;

import java.util.Date;
import java.util.List;

import UI.CreatePlanSellerView;
import UI.CreatePlanUserView;
import UI.CreatePlanView;
import UI.DashboardAdminView;
import UI.DashboardSellerView;
import UI.DashboardUserView;
import UI.MyPlanViewSeller;
import UI.MyPlanViewUser;
import UI.PlanDeleteView;
import UI.PlanView;
import UI.PlanViewSeller;
import UI.PlanViewUser;
import UI.TaskCreateView;

public class PlanFacade {

	public PlanManager planManager = new PlanManager();
	
	public PlanFacade(CreatePlanView planCreateView) {
		super();
	}

	public PlanFacade(PlanDeleteView planDeleteView) {
		super();
	}

	public PlanFacade(DashboardAdminView dashboardAdminView) {
		super();
	}

	public PlanFacade(PlanView planView) {
		super();
	}

	public PlanFacade(TaskCreateView taskCreateView) {
		super();
	}

	public PlanFacade(DashboardUserView dashboardUserView) {
		super();
	}

	public PlanFacade(PlanViewUser planViewUser) {
		super();
	}

	public PlanFacade(MyPlanViewUser myPlanViewUser) {
		super();
	}

	public PlanFacade(CreatePlanUserView createPlanUserView) {
		super();
	}

	public PlanFacade(DashboardSellerView dashboardSellerView) {
		super();
	}

	public PlanFacade(PlanViewSeller planViewSeller) {
		super();
	}

	public PlanFacade(MyPlanViewSeller myPlanViewSeller) {
		super();
	}

	public PlanFacade(CreatePlanSellerView createPlanSellerView) {
		super();
	}

	public Plan createPlan(String name, String observation, Date deadline, boolean tutorial, boolean isPublic, String ac, int idUser) {
		return this.planManager.createPlan(name, observation, deadline, tutorial, isPublic, ac, idUser);
		
	}

	public List<Plan> getAllPlan() {
		return this.planManager.getAllPlan();
	}
	
	public List<Plan> getRandomPlan() {
		return this.planManager.getRandomPlan();
	}

	public List<Plan> getMyPlan(int idUser) {
		return this.planManager.getMyPlan(idUser);
	}
	
	public void deleteTask(Plan plan) {
		this.planManager.deletePlan(plan);
	}

	public List<Task> getTaskForPlan(Integer idPlan) {
		return this.planManager.getTaskForPlan(idPlan);
	}

}
